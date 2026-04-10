let boton = document.getElementById("btn1");
boton.addEventListener("click", () => {
  let p = document.createElement("p");
  fetch("https://jsonplaceholder.typicode.com/users/2")
    .then((respuesta) => respuesta.json())
    .then((usuario) => {
      p.innerHTML = `Nombre: ${usuario.name}<br>Email: ${usuario.email}<br>Ciudad: ${usuario.address.city}`;
      document.body.append(p);
    })
    .catch((e) => console.log(e));
});
