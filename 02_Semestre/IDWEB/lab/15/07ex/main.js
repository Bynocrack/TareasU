const lista = document.getElementById("lista");
const boton = document.getElementById("btn1");

boton.addEventListener("click", (e) => {
  for (let li of lista.children) {
    console.log(li.innerHTML);
  }
});
