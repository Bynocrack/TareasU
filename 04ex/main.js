const boton = document.getElementById("btn1");
const parrafo = document.getElementById("p1");
btn1.addEventListener("click", (e) => {
  if (p1.innerHTML == "Texto cambiado.") {
    p1.innerHTML = "Texto original.";
  } else {
    p1.innerHTML = "Texto cambiado.";
  }
});
