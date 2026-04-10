const boton = document.getElementById("btn1");
const ul = document.getElementsByTagName("ul")[0];

boton.addEventListener("click", (e) => {
  const li = ul.lastElementChild.cloneNode(true);
  ul.lastElementChild.remove();
  ul.prepend(li);
});
