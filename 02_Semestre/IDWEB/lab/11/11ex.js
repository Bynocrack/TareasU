while (true) {
  let num = prompt("Digite un número positivo");
  let longitud = num.length;
  let numInt = parseInt(num);
  let suma = 0;
  if (numInt <= 0) {
    console.log("...?");
    continue;
  }
  for (let i = 0; i < longitud; i++) {
    suma += parseInt(num[i]) ** longitud;
  }
  if (suma == numInt) {
    console.log(`${num} es un número Armstrong`);
  } else {
    console.log(`${num} no es un número Armstrong`);
  }
  let rpta = prompt("Desea continuar? (S/n)").toLowerCase().charAt(0);
  if (rpta == "n") {
    break;
  }
}
