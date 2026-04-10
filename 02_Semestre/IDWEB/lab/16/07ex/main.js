const enviar = document.getElementById("enviar");
const eliminar = document.getElementById("eliminar");
const lista = document.getElementById("lista");

enviar.addEventListener("click", (e) => {
  let texto = document.getElementById("input").value;
  const li = document.createElement("li");
  li.innerText = texto;
  lista.appendChild(li);
});

eliminar.addEventListener("click", (e) => {
  if (lista.children.length != 0) {
    lista.lastChild.remove();
  }
});
