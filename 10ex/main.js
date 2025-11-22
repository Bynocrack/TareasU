const productos = [
  { nombre: "Laptop", precio: 3500 },
  { nombre: "Mouse", precio: 80 },
];
const crear = document.querySelector("#crear");
const cont = document.querySelector("#tabla");
crear.addEventListener("click", () => {
  const table = document.createElement("table");
  productos.forEach((p) => {
    const tr = document.createElement("tr");
    const td1 = document.createElement("td");
    const td2 = document.createElement("td");
    td1.textContent = p.nombre;
    td2.textContent = p.precio;
    tr.appendChild(td1);
    tr.appendChild(td2);
    table.appendChild(tr);
  });
  cont.innerHTML = "";
  cont.appendChild(table);
});
