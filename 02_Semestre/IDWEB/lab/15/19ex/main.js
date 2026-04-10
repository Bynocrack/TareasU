const boton = document.getElementById("btn1");

boton.addEventListener("click", () => {
  const listaDivs = Array.from(document.querySelectorAll("div"));
  const p = document.createElement("p");
  p.textContent = listaDivs.length;
  document.body.append(p);
});
