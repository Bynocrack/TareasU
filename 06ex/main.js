const sumar = document.getElementById("sumar");
const resta = document.getElementById("resta");
const parra = document.getElementById("contador");
let valor = 0;

sumar.addEventListener("click", (e) => {
  valor++;
  parra.innerText = valor;
});

resta.addEventListener("click", (e) => {
  valor--;
  parra.innerText = valor;
});
