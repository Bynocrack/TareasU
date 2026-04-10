const imgs = document.getElementsByTagName("img");
const boton = document.getElementById("btn1");

boton.addEventListener("click", (e) => {
  imgs[0].setAttribute("src", "imgs/img02.jpg");
  imgs[0].setAttribute("alt", "Solo Senju");
});
