import { sumar, restar } from "./sumaResta.js";
import multiplicar, { dividir } from "./multiplicacionDivision.js";

try {
  let a = 5;
  let b = 0;
  console.log(sumar(a, b));
  console.log(restar(a, b));
  console.log(multiplicar(a, b));
  console.log(dividir(a, b));
} catch (e) {
  console.log("Error de división:", e.message);
}
