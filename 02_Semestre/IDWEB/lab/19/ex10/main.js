const resultados = [];

async function obtenerPokemon(id) {
  const res = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);
  if (!res.ok) throw new Error("Error al obtener Pokémon " + id);
  const data = await res.json();
  return data;
}
async function cargarPokemons() {
  const grid = document.getElementById("grid");
  const loading = document.getElementById("loading");

  try {
    for (let id = 1; id <= 10; id++) {
      const data = await obtenerPokemon(id);
      resultados.push(data);
    }

    resultados.forEach((p) => {
      const card = document.createElement("div");
      card.className = "card";
      const img = document.createElement("img");
      img.className = "poke-img";
      img.src = p.sprites.front_default || "";
      img.alt = p.name;
      const name = document.createElement("p");
      name.className = "name";
      name.textContent = p.name;
      const idEl = document.createElement("div");
      idEl.className = "id";
      idEl.textContent = `ID: ${p.id}`;
      card.appendChild(img);
      card.appendChild(name);
      card.appendChild(idEl);
      grid.appendChild(card);
    });

    loading.style.display = "none";
  } catch (err) {
    loading.textContent = "Ocurrió un error al cargar los Pokémon.";
    console.error(err);
  }
}

cargarPokemons();
