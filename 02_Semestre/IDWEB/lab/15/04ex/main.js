const parrafos = document.getElementsByTagName("p");
const boton = document.getElementById("btn1");

boton.addEventListener("click", (e) => {
  for (let p of parrafos) {
    p.innerHTML = "Texto actualizado dinámicamente";
  }
});
