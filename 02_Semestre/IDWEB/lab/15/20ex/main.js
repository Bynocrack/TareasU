const boton = document.getElementById("btn1");

boton.addEventListener("click", () => {
  const ul = document.createElement("ul");

  for (let index = 0; index < 4; index++) {
    const li = document.createElement("li");
    const span = document.createElement("span");
    span.textContent = "Nivel interno";
    li.appendChild(span);
    ul.appendChild(li);
  }

  document.body.appendChild(ul);
});
