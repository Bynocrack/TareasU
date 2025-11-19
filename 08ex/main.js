const form = document.getElementById("formulario");
const nombre = document.getElementById("nombre");
const correo = document.getElementById("correo");

form.addEventListener("submit", (e) => {
  e.preventDefault();
  let error = false;
  if (nombre.value == "") {
    let span = document.createElement("span");
    span.innerHTML = "Coloque su nombre!";
    span.style.color = "red";
    form.appendChild(nombre, span);
    error = true;
  }
  if (correo.value == "") {
    let span = document.createElement("span");
    span.innerHTML = "Coloque su correo!";
    form.appendChild(correo, span);
    error = true;
  }
  if (!error) {
    alert("Enviado!");
  }
});
