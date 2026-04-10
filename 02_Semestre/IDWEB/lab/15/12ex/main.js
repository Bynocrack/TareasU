const p = document.getElementById("parrafo");
const boton = document.getElementById("btn1");

boton.addEventListener("click", (e) => {
  p.outerHTML = "<div>Parrafo reemplazado</div>";
});
