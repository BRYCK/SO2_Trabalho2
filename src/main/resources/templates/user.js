const express = require("express");
const app = express();
app.listen(8443, () => console.log("porta 4883"));
app.use(express.static("public"));

app.post("/utilizador/add", (request, response) => {
  console.log(request);
});
