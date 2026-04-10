const form = document.getElementById("formulario");
const nombre = document.getElementById("nombre");
const correo = document.getElementById("correo");

form.addEventListener("submit", (e) => {
  e.preventDefault();
  let error = false;
  if (nombre.value == "") {
    let span = document.createElement("span");
    let br = document.createElement("br");
    span.innerHTML = "Coloque su nombre!";
    span.style.color = "red";
    nombre.insertAdjacentElement("afterend", span);
    nombre.insertAdjacentElement("afterend", br);
    error = true;
  }
  if (correo.value == "") {
    let span = document.createElement("span");
    let br = document.createElement("br");
    span.innerHTML = "Coloque su correo!";
    span.style.color = "red";
    correo.insertAdjacentElement("afterend", span);
    correo.insertAdjacentElement("afterend", br);
    error = true;
  }
  if (!error) {
    alert("Enviado!");
  }
});
