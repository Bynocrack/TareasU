const ex03 = async () => {
  id = prompt("Digite el ID de un pokemon");
  try {
    id = id.replace(/^0+/, "");
    const res = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);
    const data = await res.json();

    nombre = data.name;
    console.log(nombre);
  } catch (e) {
    console.log(e);
  }
};

const ex04 = () => {
  fetch("https://pokeapi.co/api/v2/pokemon/pikachu")
    .then((res) => res.json())
    .then((pkmn) => {
      console.log("Altura de pikachu:", pkmn.height);
      console.log("Peso de pikachu:", pkmn.weight);
    })
    .catch((e) => {
      console.log(e);
    });
};

const ex05 = async () => {
  try {
    res = await fetch("https://pokeapi.co/api/v2/pokemon/pikachu");
    pkmn = await res.json();

    console.log("Altura de pikachu:", pkmn.height);
    console.log("Peso de pikachu:", pkmn.weight);
  } catch (e) {
    console.log(e);
  }
};

const ex06 = async () => {
  try {
    res = await fetch("https://pokeapi.co/api/v2/pokemon/charizard");
    pkmn = await res.json();

    console.log(pkmn.sprites.front_default);
  } catch (e) {
    console.log(e);
  }
};

const ex07 = async () => {
  try {
    res = await fetch("https://pokeapi.co/api/v2/pokemon?limit=20");
    pkmns = await res.json();

    pkmns.results.forEach((pkmn) => {
      console.log(pkmn.name);
    });
  } catch (e) {
    console.log(e);
  }
};

const ex08 = async () => {
  try {
    id = Math.trunc(Math.random() * 898) + 1;

    res = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);
    pkmn = await res.json();

    console.log(pkmn.name);
  } catch (e) {
    console.log(e);
  }
};
