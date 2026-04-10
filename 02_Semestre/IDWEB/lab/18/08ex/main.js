let boton = document.getElementById("btn1");
boton.addEventListener("click", async () => {
  try {
    let p = document.createElement("p");
    const respuesta = await fetch(
      "https://jsonplaceholder.typicode.com/users/2",
    );
    const usuario = await respuesta.json();
    p.innerHTML = `Nombre: ${usuario.name}<br>Email: ${usuario.email}<br>Ciudad: ${usuario.address.city}`;
    document.body.append(p);
  } catch (e) {
    console.log("Error:", e.message);
  }
});
