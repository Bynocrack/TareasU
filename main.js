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
  console.log("hola");
};
