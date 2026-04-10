const boton = document.getElementById("btn1");
const contenedor = document.getElementById("contenedor");

boton.addEventListener("click", (e) => {
  let textos = [];
  let i = 0;
  for (let elemento of contenedor.children) {
    if (elemento.nodeName == "P") {
      textos[i] = elemento.innerHTML;
      i++;
    }
  }
  textos.sort();
  for (let elemento of contenedor.children) {
    if (elemento.nodeName == "P") {
      elemento.innerHTML = textos[0];
      textos.shift();
    }
  }
});
