let sum = 0;
let error = "";
while (true) {
  let precio = parseFloat(prompt(error + "Digite el precio del producto"));
  if (precio < 0) {
    error = "Costo negativo?\n";
    continue;
  }
  sum += precio;
  let rpta = prompt("Desea continuar? (S/n)").toLowerCase().charAt(0);
  if (rpta == "n") {
    break;
  }
}

console.log("El total de su compra es de " + sum);

let descuento = 1;
if (sum > 100) {
  console.log("Tiene un descuento del 10%!");
  descuento = 0.9;
} else if (sum > 50) {
  console.log("Tiene un descuento del 5%!");
  descuento = 0.95;
} else {
  console.log("No aplica descuento");
}
console.log(`Su total a pagar es ${(sum * descuento).toFixed(2)}`);
