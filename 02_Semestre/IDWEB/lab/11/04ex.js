let edad = parseInt(prompt("Digite su edad"));

while (edad < 0 || edad > 120) {
  edad = parseInt(prompt("...?"));
}

if (edad < 12) {
  console.log("Niño");
} else if (edad < 17) {
  console.log("Adolescente");
} else if (edad < 59) {
  console.log("Adulto");
} else {
  console.log("Adulto mayor");
}
