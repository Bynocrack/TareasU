while (true) {
  let monto = parseInt(
    prompt("Dijite cuanto dinero desea retirar (solo saldran billetes)"),
  );
  if (monto < 0) {
    console.log("...?");
    continue;
  }
  let cant = parseInt(monto / 100);
  console.log(`${cant} billtes de 100`);
  monto = monto % 100;
  cant = parseInt(monto / 50);
  console.log(`${cant} billetes de 50`);
  monto = monto % 50;
  cant = parseInt(monto / 20);
  console.log(`${cant} billetes de 20`);
  monto = monto % 20;
  cant = parseInt(monto / 10);
  console.log(`${cant} billetes de 10`);
  monto = monto % 10;
  if (monto != 0) {
    console.log(
      `Hubo ${monto} soles que no se pudieron retirar pues no existen billetes tan pequeños`,
    );
  }
  let rpta = prompt("Desea seguir retirando? (S/n)").toLowerCase().charAt(0);
  if (rpta == "n") {
    break;
  }
}
