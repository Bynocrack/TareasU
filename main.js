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

const ex07 = () => {
  try {
    let x = null;
    x.nombre;
    console.log("listo");
  } catch (e) {
    if (e instanceof TypeError) {
      console.log("Error de tipo ");
    } else {
      console.log("No es un error de tipo, pero es un error");
    }
  }
};

const ex08 = () => {
  const dividir = (divisor) => {
    try {
      return dividendo / divisor;
    } catch (e) {
      console.log("Nivel 2 atrapó el error: " + e.message);
      throw e;
    }
  };
  const operadores = (func, a, b) => {
    try {
      let x = func(a);
      return x;
    } catch (e) {
      console.log("Nivel 1 atrapó el error: " + e.message);
      throw e;
    }
  };

  try {
    let resultado = operadores(dividir, 5, 10);
    console.log(resultado);
  } catch (e) {
    console.log("ERROR FINAL capturado en el nivel superior: " + e.message);
  }
};

const ex09 = () => {
  const cargarMensaje = (func) => {
    setTimeout(() => {
      func("Mensaje cargado");
    }, 1000);
  };

  const ortografia = (texto) => {
    console.log(texto + ".");
  };

  cargarMensaje(ortografia);
};

const ex10 = () => {
  const cargarUsuario = (func) => {
    let tiempo = Math.trunc(Math.random() * 701) + 800;
    let usuario = {
      id: "US001",
      nombre: "Josue",
    };
    setTimeout(() => {
      func(usuario);
    }, tiempo);
  };
  const imprimirUsuario = (usuario) => {
    console.log(`Usuario Cargado: ${usuario.nombre} (ID:${usuario.id})`);
  };

  cargarUsuario(imprimirUsuario);
};
