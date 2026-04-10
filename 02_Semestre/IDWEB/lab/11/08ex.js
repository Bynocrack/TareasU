while (true) {
  let tope = parseInt(prompt("Digite un número"));
  for (let i = 2; i < tope; i++) {
    let primo = true;
    for (let j = 2; j < i; j++) {
      if (j != i && i % j == 0) {
        primo = false;
      }
    }
    if (primo) {
      console.log(i + " es un número primo menor a " + tope);
    }
  }
  let rpta = prompt("Desea continuar? (S/n)").toLowerCase().charAt(0);
  if (rpta == "n") {
    break;
  }
}
