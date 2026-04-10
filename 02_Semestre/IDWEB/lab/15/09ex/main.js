const boton = document.getElementById("btn1");

boton.addEventListener("click", (e) => {
  const p = document.createElement("p");
  p.innerHTML = "Elemento insertado con JS";
  document.body.appendChild(p);
});
