async function buscarPokemon() {
  const entrada = document.getElementById("entrada").value.trim().toLowerCase();
  const resultado = document.getElementById("resultado");

  if (!entrada) {
    resultado.innerHTML = "<p>Escribe un nombre o ID.</p>";
    return;
  }

  try {
    const res = await fetch(`https://pokeapi.co/api/v2/pokemon/${entrada}`);
    if (!res.ok) throw new Error("No encontrado");

    const data = await res.json();

    const tipos = data.types
      .map((t) => `<span class="tipo">${t.type.name}</span>`)
      .join(" ");

    resultado.innerHTML = `
            <h3>${data.name.toUpperCase()}</h3>
            <img src="${data.sprites.front_default}" alt="${data.name}">
            <p><strong>Tipos:</strong></p>
            <div>${tipos}</div>
        `;
  } catch (error) {
    resultado.innerHTML = "<p style='color:red;'>Pokémon no encontrado.</p>";
  }
}

