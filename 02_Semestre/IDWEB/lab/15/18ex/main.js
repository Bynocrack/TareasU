const boton = document.getElementById("btn1");

boton.addEventListener("click", () => {
  const listaSections = Array.from(document.querySelectorAll("section"));

  for (let index = 0; index < listaSections.length; index++) {
    console.log(listaSections[index]);
    listaSections[index].setAttribute("data-index", index);
  }
});
