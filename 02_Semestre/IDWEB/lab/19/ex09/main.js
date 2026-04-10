async function mostrarPokemon(nombre) {
  const pokemon = document.getElementById("pokemon");
  try {
    const res = await fetch(`https://pokeapi.co/api/v2/pokemon/${nombre}`);
    const data = await res.json();
    const habilidades = data.abilities.map((a) => a.ability.name).join(", ");
    pokemon.innerHTML = `<h2>${data.name.toUpperCase()}</h2>
            <img src="${data.sprites.front_default}" alt="${data.name}">
            <p>Peso: ${data.weight}</p>
            <p>Altura: ${data.height}</p>
            <p>Habilidades: ${habilidades}</p>`;
  } catch (error) {
    pokemon.innerHTML = "<h3> Error al obtener datos </h3>";
  }
}
const nom = prompt("Introduzca el nombre del pokemon");
mostrarPokemon(nom.toLowerCase());

