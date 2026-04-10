async function buscarStats() {
  const entrada = document.getElementById("entrada").value.trim().toLowerCase();
  const resultado = document.getElementById("resultado");
  if (!entrada) {
    resultado.innerHTML = "<p>Escribe un Pokémon.</p>";
    return;
  }
  try {
    const res = await fetch(`https://pokeapi.co/api/v2/pokemon/${entrada}`);
    if (!res.ok) throw new Error("No encontrado");
    const data = await res.json();
    let tabla = `
            <h3>${data.name.toUpperCase()}</h3>
            <img src="${data.sprites.front_default}" alt="${data.name}">
            <table>
                <tr><th>Stat</th><th>Valor</th></tr>
        `;
    data.stats.forEach((s) => {
      tabla += `
                <tr>
                    <td>${s.stat.name}</td>
                    <td>${s.base_stat}</td>
                </tr>
            `;
    });
    tabla += "</table>";
    resultado.innerHTML = tabla;
  } catch (err) {
    resultado.innerHTML = "<p style='color:red;'>Pokémon no encontrado.</p>";
  }
}
