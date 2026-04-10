let error = "";
let min = 0;
let max = 0;
let pares = 0;
while (true) {
  let rpta = parseInt(
    prompt(
      error +
        "1) Calcular estadísticas de N notas\n2) Contar números pares e impares en un rango\n3) Generar tabla de multiplicar\n0) Salir",
    ),
  );
  error = "";
  if (rpta == 0) {
    break;
  }
  switch (rpta) {
    case 1:
      let suma = 0;
      max = 0;
      min = 20;
      pares = 0;
      let notas = [];
      let n = 0;
      while (true) {
        let nota = parseInt(prompt(`${error}\nDigite la ${n + 1}° nota`));
        if (nota < 0 || nota > 20) {
          error = "Las notas son de 0 a 20 (inclusive) por si acaso\n";
          continue;
        }
        error = "";
        notas[n] = nota;
        n++;
        suma += nota;
        if (nota > max) {
          max = nota;
        }
        if (nota < min) {
          min = nota;
        }
        if (nota % 2 == 0) {
          pares++;
        }
        let seguir = prompt("Desea seguir digitando notas? (S/n)")
          .toLowerCase()
          .charAt(0);
        if (seguir == "n") {
          break;
        }
      }
      let prom = suma / n;
      let encima = 0;
      for (let i = 0; i < n; i++) {
        if (notas[i] > prom) {
          encima++;
        }
      }
      console.log("El promedio de las notas es: " + prom);
      console.log("La nota más alta es: " + max);
      console.log("La nota más baja es: " + min);
      console.log(
        `La cantidad de pares es ${pares} y la de impares es ${n - pares}`,
      );
      console.log("La cantidad que esta por encima del promedio es: " + encima);
      break;
    case 2:
      min = parseInt(prompt("Digite el límite inferior (inclusive)"));
      max = parseInt(prompt("Digite el límite superior (no inclusive)"));
      pares = 0;
      for (let i = min; i < max; i++) {
        if (i % 2 == 0) {
          pares++;
        }
      }
      console.log(
        `La cantidad de pares en ese rango es ${pares} y la de impares es ${max - min - pares}`,
      );
      break;
    case 3:
      let num = parseInt(
        prompt("Digite el multiplicando del cual se quiere la tabla: "),
      );
      max = parseInt(
        prompt(
          "Digite el límite superior de la tabla de multiplicar (no inclusive)",
        ),
      );
      min = parseInt(
        prompt(
          "Digite el límite inferior de la tabla de multiplicar (inclusive)",
        ),
      );
      for (let i = min; i < max; i++) {
        console.log(`${num} x ${i} = ${num * i}`);
      }
    default:
      error = rpta + " No esta en las opciones\n";
      break;
  }
}
