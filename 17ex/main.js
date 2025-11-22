const usuario = { nombre: "Luis", correo: "l@gmail.com", rol: "admin" };
localStorage.setItem("usuario", JSON.stringify(usuario));
const rec = JSON.parse(localStorage.getItem("usuario"));
document.querySelector("#mostrar").textContent = rec.nombre;
