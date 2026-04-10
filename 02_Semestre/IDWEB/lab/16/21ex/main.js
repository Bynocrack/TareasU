const tareasJSON = `[
    {"titulo":"Estudiar","completada":true},
    {"titulo":"Comprar","completada":false}
]`;
const tareas = JSON.parse(tareasJSON);
const lista = document.querySelector("#lista");
tareas.forEach((t) => {
  const li = document.createElement("li");
  li.textContent = t.titulo;
  if (t.completada) li.style.color = "green";
  lista.appendChild(li);
});
