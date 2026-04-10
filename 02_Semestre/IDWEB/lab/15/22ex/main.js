const boton = document.getElementById("btn1");
boton.addEventListener("click", () => {
  const section = document.getElementById("seccion");

  const h2Original = section.getElementsByTagName("h2")[0];

  const nuevoH2 = document.createElement("h2");
  nuevoH2.textContent = "Título nuevo";

  const nuevoP = document.createElement("p");
  nuevoP.textContent = "Descripción generada";

  const ul = document.createElement("ul");
  for (let i = 1; i <= 3; i++) {
    const li = document.createElement("li");
    li.textContent = `Elemento ${i}`;
    ul.appendChild(li);
  }

  section.appendChild(nuevoH2);
  section.appendChild(nuevoP);
  section.appendChild(ul);

  if (h2Original) {
    h2Original.remove();
  }
});
