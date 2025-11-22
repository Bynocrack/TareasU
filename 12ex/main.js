const d = document.querySelector("div");
const b = document.querySelectorAll("button");
b[0].addEventListener("click", () => {
  d.classList.add("mover");
});
b[1].addEventListener("click", () => {
  d.classList.remove("mover");
});
