const boton = document.getElementById("btn1");
const p = document.getElementsByTagName("p")[0];

boton.addEventListener("click", (e) => {
  const h3 = document.createElement("h3");
  h3.innerHTML = "titulo dinamico";
  document.body.insertBefore(h3, p);
});
