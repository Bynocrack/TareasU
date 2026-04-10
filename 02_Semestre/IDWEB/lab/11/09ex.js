while (true) {
  let num = parseInt(prompt("Digite el valor de N"));
  let suma = 0;
  if (num < 0) {
    console.log("...?");
    continue;
  }
  for (let i = 1; i <= num; i++) {
    if (i % 5 != 0) {
      suma += i;
    }
  }
  console.log(
    `La suma de todos los valores no multiplos de 5 hasta ${num} es: ${suma}`,
  );
  let rpta = prompt("Desea continuar? (S/n)").toLowerCase().charAt(0);
  if (rpta == "n") {
    break;
  }
}
