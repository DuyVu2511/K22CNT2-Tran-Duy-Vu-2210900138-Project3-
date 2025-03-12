import React, { useState } from "react";

function PatientPage() {
  const [cmnd, setCmnd] = useState("");
  const [patientData, setPatientData] = useState(null);
  const [error, setError] = useState("");
  const [showPaymentModal, setShowPaymentModal] = useState(false);
  const [selectedInvoice, setSelectedInvoice] = useState(null);

  const handleSearch = async (e) => {
    e.preventDefault();
    setError("");
    setPatientData(null);

    try {
      const response = await fetch(`http://localhost:5000/api/patient/${cmnd}`);
      if (!response.ok) {
        throw new Error("Không tìm thấy dữ liệu");
      }
      const data = await response.json();
      setPatientData(data);
    } catch (err) {
      setError(err.message || "Không thể kết nối đến server");
    }
  };

  const openPaymentModal = (invoice) => {
    setSelectedInvoice(invoice);
    setShowPaymentModal(true);
  };

  const closePaymentModal = () => {
    setShowPaymentModal(false);
    setSelectedInvoice(null);
  };

  const handlePayment = async (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const paymentMethod = formData.get("paymentMethod");
    const paymentAmount = formData.get("paymentAmount");
    const paymentNote = formData.get("paymentNote");

    try {
      const response = await fetch(
        `http://localhost:5000/api/pay/${selectedInvoice.TDV_MaHoaDon}`,
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({ paymentMethod, paymentAmount, paymentNote }),
        }
      );
      const result = await response.json();
      if (response.ok) {
        alert(result.message);
        closePaymentModal();
        const updatedResponse = await fetch(
          `http://localhost:5000/api/patient/${cmnd}`
        );
        const updatedData = await updatedResponse.json();
        setPatientData(updatedData);
      } else {
        setError(result.message || "Thanh toán thất bại");
      }
    } catch (err) {
      setError("Không thể kết nối đến server");
    }
  };

  return (
    <div
      style={{
        backgroundImage: `url('/tdv-quanlyvienphi.jpg')`, // Ảnh từ public
        backgroundSize: "cover",
        backgroundPosition: "center",
        backgroundRepeat: "no-repeat",
        height: "100vh", // Chiều cao toàn màn hình
        width: "100vw", // Chiều rộng toàn màn hình
        margin: 0, // Loại bỏ margin mặc định
        padding: "20px", // Padding để nội dung không sát mép
        overflow: "auto", // Cho phép cuộn nếu nội dung dài
        display: "flex",
        justifyContent: "center", // Căn giữa nội dung theo chiều ngang
        alignItems: "flex-start", // Căn nội dung từ trên xuống
      }}
    >
      <div className="patient-page">
        <header className="header">
          <p>Trần Duy Vũ - Quản Lý Viện Phí</p>
        </header>

        <h1>Tra Cứu Thông Tin Bệnh Nhân</h1>
        <form onSubmit={handleSearch} className="search-form">
          <input
            type="text"
            placeholder="Nhập CMND/CCCD"
            value={cmnd}
            onChange={(e) => setCmnd(e.target.value)}
          />
          <button type="submit">Tìm kiếm</button>
        </form>

        {error && <p className="error">{error}</p>}

        {patientData && (
          <div className="patient-info">
            <h2>Thông Tin Bệnh Nhân</h2>
            <p>
              <strong>Họ tên:</strong> {patientData.patient.TDV_HoTen}
            </p>
            <p>
              <strong>Ngày sinh:</strong>{" "}
              {new Date(patientData.patient.TDV_NgaySinh).toLocaleDateString()}
            </p>
            <p>
              <strong>Giới tính:</strong> {patientData.patient.TDV_GioiTinh}
            </p>
            <p>
              <strong>CMND/CCCD:</strong> {patientData.patient.TDV_CMND_CCCD}
            </p>
            <p>
              <strong>Số điện thoại:</strong>{" "}
              {patientData.patient.TDV_SoDienThoai}
            </p>
            <p>
              <strong>Địa chỉ:</strong> {patientData.patient.TDV_DiaChi}
            </p>
            <p>
              <strong>Mã bảo hiểm:</strong>{" "}
              {patientData.patient.TDV_MaBaoHiem || "Không có"}
            </p>

            <h2>Danh Sách Hóa Đơn</h2>
            {patientData.invoices.length > 0 ? (
              <table>
                <thead>
                  <tr>
                    <th>Mã HĐ</th>
                    <th>Ngày Lập</th>
                    <th>Tổng Tiền</th>
                    <th>BH Hỗ Trợ</th>
                    <th>Phải Trả</th>
                    <th>Trạng Thái</th>
                    <th>Thanh Toán</th>
                  </tr>
                </thead>
                <tbody>
                  {patientData.invoices.map((invoice) => (
                    <tr key={invoice.TDV_MaHoaDon}>
                      <td>{invoice.TDV_MaHoaDon}</td>
                      <td>
                        {new Date(invoice.TDV_NgayLap).toLocaleDateString()}
                      </td>
                      <td>
                        {parseFloat(invoice.TDV_TongTien).toLocaleString()} VNĐ
                      </td>
                      <td>
                        {parseFloat(invoice.TDV_BaoHiemHoTro).toLocaleString()}{" "}
                        VNĐ
                      </td>
                      <td>
                        {parseFloat(invoice.TDV_SoTienPhaiTra).toLocaleString()}{" "}
                        VNĐ
                      </td>
                      <td>{invoice.TDV_TrangThaiThanhToan}</td>
                      <td>
                        {invoice.TDV_TrangThaiThanhToan ===
                        "Chưa thanh toán" ? (
                          <button
                            className="pay-button"
                            onClick={() => openPaymentModal(invoice)}
                          >
                            Thanh Toán
                          </button>
                        ) : (
                          "Đã thanh toán"
                        )}
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            ) : (
              <p>Không có hóa đơn nào.</p>
            )}

            <h2>Thông Tin Thanh Toán</h2>
            {patientData.payments && patientData.payments.length > 0 ? (
              <table>
                <thead>
                  <tr>
                    <th>Mã Thanh Toán</th>
                    <th>Mã HĐ</th>
                    <th>Phương Thức</th>
                    <th>Số Tiền</th>
                    <th>Ngày Thanh Toán</th>
                    <th>Ghi Chú</th>
                  </tr>
                </thead>
                <tbody>
                  {patientData.payments.map((payment) => (
                    <tr key={payment.TDV_MaThanhToan}>
                      <td>{payment.TDV_MaThanhToan}</td>
                      <td>{payment.TDV_MaHoaDon}</td>
                      <td>{payment.TDV_PhuongThuc}</td>
                      <td>
                        {parseFloat(payment.TDV_SoTien).toLocaleString()} VNĐ
                      </td>
                      <td>
                        {new Date(
                          payment.TDV_NgayThanhToan
                        ).toLocaleDateString()}
                      </td>
                      <td>{payment.TDV_GhiChu}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            ) : (
              <p>Chưa có thanh toán nào.</p>
            )}
          </div>
        )}

        {/* Modal Form Thanh Toán */}
        {showPaymentModal && selectedInvoice && (
          <div className="modal">
            <div className="modal-content">
              <h3>Thanh Toán Hóa Đơn #{selectedInvoice.TDV_MaHoaDon}</h3>
              <form onSubmit={handlePayment}>
                <label>
                  Số tiền phải trả:{" "}
                  {parseFloat(
                    selectedInvoice.TDV_SoTienPhaiTra
                  ).toLocaleString()}{" "}
                  VNĐ
                </label>
                <br />
                <label>
                  Phương thức thanh toán:
                  <select name="paymentMethod" required>
                    <option value="Tiền mặt">Tiền mặt</option>
                    <option value="Chuyển khoản">Chuyển khoản</option>
                    <option value="Bảo hiểm & Tiền mặt">
                      Bảo hiểm & Tiền mặt
                    </option>
                  </select>
                </label>
                <br />
                <label>
                  Số tiền thanh toán:
                  <input
                    type="number"
                    name="paymentAmount"
                    defaultValue={selectedInvoice.TDV_SoTienPhaiTra}
                    required
                  />
                </label>
                <br />
                <label>
                  Ghi chú:
                  <textarea name="paymentNote" rows="3" />
                </label>
                <br />
                <button type="submit" className="submit-button">
                  Xác nhận thanh toán
                </button>
                <button
                  type="button"
                  className="cancel-button"
                  onClick={closePaymentModal}
                >
                  Hủy
                </button>
              </form>
            </div>
          </div>
        )}
      </div>
    </div>
  );
}

export default PatientPage;
