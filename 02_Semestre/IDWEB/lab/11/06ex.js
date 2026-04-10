while (true) {
  let num = parseInt(prompt("Digite un número"));
  for (i = 1; i < 13; i++) {
    console.log(`${i} x ${num} = ${i * num}`);
  }
  let rpta = prompt("Desea continuar? (S/n)").toLowerCase().charAt(0);
  if (rpta == "n") {
    break;
  }
}
