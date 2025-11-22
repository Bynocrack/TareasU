const form = document.querySelector("form");
const tabla = document.querySelector("table");
let usuarios = [];
function render() {
  tabla.innerHTML = "";
  usuarios.forEach((u, i) => {
    const tr = document.createElement("tr");
    tr.dataset.index = i;
    const td1 = document.createElement("td");
    const td2 = document.createElement("td");
    const td3 = document.createElement("td");
    const b1 = document.createElement("button");
    const b2 = document.createElement("button");
    td1.textContent = u.nombre;
    td2.textContent = u.edad;
    b1.textContent = "Editar";
    b2.textContent = "Eliminar";
    td3.appendChild(b1);
    td3.appendChild(b2);
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tabla.appendChild(tr);
  });
}
tabla.addEventListener("click", (e) => {
  if (e.target.tagName === "BUTTON") {
    const index = e.target.closest("tr").dataset.index;
    if (e.target.textContent === "Eliminar") {
      usuarios.splice(index, 1);
      render();
    }
    if (e.target.textContent === "Editar") {
      const nuevo = prompt("Nuevo nombre");
      if (nuevo !== null) {
        usuarios[index].nombre = nuevo;
        render();
      }
    }
  }
});
form.addEventListener("submit", (e) => {
  e.preventDefault();
  const n = form.querySelectorAll("input")[0].value;
  const e2 = form.querySelectorAll("input")[1].value;
  usuarios.push({ nombre: n, edad: e2 });
  form.reset();
  render();
});
