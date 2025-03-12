const express = require("express");
const cors = require("cors");
const patientRoutes = require("./routes/patient");

const app = express();

app.use(cors());
app.use(express.json());
app.use("/api", patientRoutes);

const PORT = 5000;
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});
