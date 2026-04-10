const lis = document.getElementsByTagName("li");
const boton = document.getElementById("btn1");
const ocultos = document.querySelectorAll(".oculto");

boton.addEventListener("click", (e) => {
  for (let li of ocultos) {
    li.classList.remove("oculto");
  }
  for (let li of lis) {
    li.classList.add("resaltado");
  }
});
