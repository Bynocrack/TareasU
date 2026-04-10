const boton = document.getElementById("btn1");
const div = document.getElementById("contenedor");

boton.addEventListener("click", () => {
  for (let index = 0; index < 3; index++) {
    const parrafo = document.createElement("p");
    parrafo.textContent = "Parrafo " + (index + 1);
    div.appendChild(parrafo);
  }
  setTimeout(() => {
    div.children[1].remove();
  }, 2000);
});
