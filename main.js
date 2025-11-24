const ex03 = () => {
  const dividir = (dividendo, divisor) => {
    if (divisor === 0) {
      throw new Error("No se puede dividir entre 0!");
    } else {
      return dividendo / divisor;
    }
  };
  try {
    let divison = dividir(50, 0);
    console.log(divison);
  } catch (e) {
    console.log(e);
  }
};

const ex04 = () => {
  try {
    let texto = "{nombre: Juan}";
    let obj = JSON.parse(texto);
    console.log(obj);
  } catch (e) {
    console.log(`Error\n${e.name}\n${e.message}`);
  }
};

const ex05 = () => {
  try {
    let texto = "hola";
    console.log(hola.hola);
  } catch (e) {
    console.log("falló :C");
  } finally {
    console.log("Siempre se imprime.");
  }
};

const ex06 = () => {
  const validarEdad = (edad) => {
    if (isNaN(edad)) {
      throw new Error("Edad inválida");
    }
    if (edad < 0) {
      throw new Error("Edad inválida");
    }
  };

  try {
    validarEdad("abv");
    console.log("todo bien");
  } catch (e) {
    console.log(e.message);
  }
};
