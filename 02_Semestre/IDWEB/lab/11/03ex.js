let suma = 0;
for (let i = 1; i < 6; i++) {
  let nota = parseFloat(prompt(`Digite la ${i}° nota`));
  if (0 > nota || nota > 20) {
    console.log("La nota no puede ser mayor a 20 o menor a 0");
    i--;
  } else {
    suma += nota;
  }
}

let prom = suma / 5;
console.log(`El promedio de las notas es ${prom}`);
