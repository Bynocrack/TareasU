let listaPokemon = [];
let pagina = 0;
window.onload = async function () {
  for (let id = 1; id <= 12; id++) {
    const res = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);
    const data = await res.json();
    listaPokemon.push(data);
  }
  mostrarPokemons();
};
function mostrarPokemons() {
  const grid = document.getElementById("grid");
  grid.innerHTML = "";

  const inicio = pagina * 3;
  const fin = inicio + 3;

  const grupo = listaPokemon.slice(inicio, fin);

  grupo.forEach((p) => {
    grid.innerHTML += `
            <div class="card">
                <img src="${p.sprites.front_default}" alt="${p.name}">
                <h3>${p.name.toUpperCase()}</h3>
                <p>ID: ${p.id}</p>
            </div>
        `;
  });

  actualizarBotones();
}
function mostrarSiguiente() {
  if ((pagina + 1) * 3 < listaPokemon.length) {
    pagina++;
    mostrarPokemons();
  }
}
function mostrarAnterior() {
  if (pagina > 0) {
    pagina--;
    mostrarPokemons();
  }
}
function actualizarBotones() {
  document.getElementById("btnAnterior").disabled = pagina === 0;
  document.getElementById("btnSiguiente").disabled =
    (pagina + 1) * 3 >= listaPokemon.length;
}
