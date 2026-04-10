let pares = 0;
let impares = 0;

for (let i = 1; i < 11; i++) {
  let num = parseInt(prompt("Digite un número"));
  if (num % 2 == 0) {
    pares++;
  } else {
    impares++;
  }
}

console.log(`Usted digitó ${pares} números pares.`);
console.log(`Y digitó ${impares} números impares.`);
