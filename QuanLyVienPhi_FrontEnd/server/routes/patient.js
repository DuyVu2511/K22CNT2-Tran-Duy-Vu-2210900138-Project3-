const express = require("express");
const router = express.Router();
const db = require("../config/db");

// Lấy thông tin bệnh nhân, hóa đơn và thanh toán theo CMND/CCCD
router.get("/patient/:cmnd", (req, res) => {
  const cmnd = req.params.cmnd;

  const patientQuery = "SELECT * FROM TDV_BenhNhan WHERE TDV_CMND_CCCD = ?";
  const invoiceQuery = `
    SELECT h.* 
    FROM TDV_HoaDon h
    JOIN TDV_BenhNhan bn ON h.TDV_MaBenhNhan = bn.TDV_MaBenhNhan
    WHERE bn.TDV_CMND_CCCD = ?
  `;
  const paymentQuery = `
    SELECT t.* 
    FROM TDV_ThanhToan t
    JOIN TDV_HoaDon h ON t.TDV_MaHoaDon = h.TDV_MaHoaDon
    JOIN TDV_BenhNhan bn ON h.TDV_MaBenhNhan = bn.TDV_MaBenhNhan
    WHERE bn.TDV_CMND_CCCD = ?
  `;

  db.query(patientQuery, [cmnd], (err, patientResult) => {
    if (err) return res.status(500).json({ error: err.message });
    if (patientResult.length === 0)
      return res.status(404).json({ message: "Không tìm thấy bệnh nhân" });

    db.query(invoiceQuery, [cmnd], (err, invoiceResult) => {
      if (err) return res.status(500).json({ error: err.message });

      db.query(paymentQuery, [cmnd], (err, paymentResult) => {
        if (err) return res.status(500).json({ error: err.message });

        res.json({
          patient: patientResult[0],
          invoices: invoiceResult,
          payments: paymentResult,
        });
      });
    });
  });
});

// Xử lý thanh toán với dữ liệu từ form
router.post("/pay/:invoiceId", (req, res) => {
  const invoiceId = req.params.invoiceId;
  const { paymentMethod, paymentAmount, paymentNote } = req.body;

  const checkInvoiceQuery =
    "SELECT TDV_SoTienPhaiTra, TDV_TrangThaiThanhToan FROM TDV_HoaDon WHERE TDV_MaHoaDon = ?";
  db.query(checkInvoiceQuery, [invoiceId], (err, result) => {
    if (err) return res.status(500).json({ error: err.message });
    if (result.length === 0)
      return res.status(404).json({ message: "Không tìm thấy hóa đơn" });

    const { TDV_SoTienPhaiTra, TDV_TrangThaiThanhToan } = result[0];
    if (TDV_TrangThaiThanhToan === "Đã thanh toán") {
      return res.status(400).json({ message: "Hóa đơn đã được thanh toán" });
    }
    if (parseFloat(paymentAmount) !== parseFloat(TDV_SoTienPhaiTra)) {
      return res.status(400).json({ message: "Số tiền thanh toán không khớp" });
    }

    const insertPaymentQuery = `
      INSERT INTO TDV_ThanhToan (TDV_MaHoaDon, TDV_PhuongThuc, TDV_SoTien, TDV_GhiChu)
      VALUES (?, ?, ?, ?)
    `;
    db.query(
      insertPaymentQuery,
      [invoiceId, paymentMethod, paymentAmount, paymentNote || ""],
      (err) => {
        if (err) return res.status(500).json({ error: err.message });

        const updateInvoiceQuery = `
        UPDATE TDV_HoaDon 
        SET TDV_TrangThaiThanhToan = 'Đã thanh toán'
        WHERE TDV_MaHoaDon = ?
      `;
        db.query(updateInvoiceQuery, [invoiceId], (err) => {
          if (err) return res.status(500).json({ error: err.message });
          res.json({ message: "Thanh toán thành công" });
        });
      }
    );
  });
});

module.exports = router;
