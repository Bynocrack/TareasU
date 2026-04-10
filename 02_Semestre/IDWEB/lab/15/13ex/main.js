const boton = document.getElementById("btn1");
const ps = document.getElementsByTagName("p");

boton.addEventListener("click", (e) => {
  let ultimo = ps.length - 1;
  ps[ultimo].remove();
});
