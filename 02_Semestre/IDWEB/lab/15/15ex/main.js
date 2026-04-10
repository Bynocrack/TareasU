const boton = document.getElementById("btn1");
const articulo = document.getElementsByTagName("article")[0].cloneNode(true);

boton.addEventListener("click", (e) => {
  document
    .getElementsByTagName("main")[0]
    .insertAdjacentHTML("afterend", articulo.outerHTML);
});
