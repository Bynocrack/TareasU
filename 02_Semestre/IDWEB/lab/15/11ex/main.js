const section = document.getElementById("section");
const boton = document.getElementById("btn1");

boton.addEventListener("click", (e) => {
  const ul = document.createElement("ul");
  for (let i = 1; i < 6; i++) {
    const li = document.createElement("li");
    li.innerHTML = `Element ${i}`;
    ul.appendChild(li);
  }
  document.body.append(ul);
});
