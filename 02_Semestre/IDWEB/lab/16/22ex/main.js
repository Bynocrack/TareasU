const form = document.querySelector("#form");
const perfil = document.querySelector("#perfil");
form.addEventListener("submit", (e) => {
  e.preventDefault();
  const obj = {
    nombre: form.nombre.value,
    edad: form.edad.value,
    pais: form.pais.value,
  };
  localStorage.setItem("perfil", JSON.stringify(obj));
  mostrar();
});
function mostrar() {
  const data = JSON.parse(localStorage.getItem("perfil"));
  if (data) {
    perfil.textContent = data.nombre + " - " + data.edad + " - " + data.pais;
  }
}
mostrar();
