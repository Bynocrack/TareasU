const divs = document.getElementsByTagName("div");
const boton = document.getElementById("btn1");

let rojo = 255;
let verde = 255;
let azul = 255;

boton.addEventListener("click", (e) => {
  let paso = 255 / divs.length;
  for (let div of divs) {
    div.style.backgroundColor = `rgb(${rojo}, ${verde}, ${azul})`;
    rojo -= paso;
    verde -= paso;
    azul -= paso;
  }
});
