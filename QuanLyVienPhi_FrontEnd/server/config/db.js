const mysql = require("mysql2");

const connection = mysql.createConnection({
  host: "localhost",
  user: "root", // Thay bằng username MySQL của bạn
  password: "01232317428Aa", // Thay bằng password MySQL của bạn
  database: "TDV_QuanLyVienPhi",
});

connection.connect((err) => {
  if (err) throw err;
  console.log("Connected to MySQL Database");
});

module.exports = connection;
