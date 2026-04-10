const json = `[
    {"titulo":"Libro A","autor":"Autor A"},
    {"titulo":"Libro B","autor":"Autor B"}
]`;
const libros = JSON.parse(json);
const tabla = document.querySelector("#tabla");
libros.forEach((l) => {
  const tr = document.createElement("tr");
  const td1 = document.createElement("td");
  const td2 = document.createElement("td");
  td1.textContent = l.titulo;
  td2.textContent = l.autor;
  tr.appendChild(td1);
  tr.appendChild(td2);
  tabla.appendChild(tr);
});
