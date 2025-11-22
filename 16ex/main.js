const arr = [
  { nombre: "Lapicero", precio: 2 },
  { nombre: "Cuaderno", precio: 5 },
];
const json = JSON.stringify(arr);
const obj = JSON.parse(json);
const lista = document.querySelector("#lista");
obj.forEach((item) => {
  const li = document.createElement("li");
  li.textContent = item.nombre;
  lista.appendChild(li);
});
