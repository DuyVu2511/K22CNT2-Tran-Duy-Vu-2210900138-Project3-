import React from "react";
import ReactDOM from "react-dom/client"; // Thay đổi import
import App from "./App";

// Tạo root và render
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
