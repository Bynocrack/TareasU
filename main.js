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

const ex11 = () => {
  const dividirAsync = (a, b, func) => {
    setTimeout(() => {
      if (b === 0) {
        func(new Error("No se puede dividir entre cero"), null);
      } else {
        func(null, a / b);
      }
    }, 1500);
  };

  const manejarErrores = (err, resultado) => {
    if (err) {
      console.log("Error: " + err.message);
    } else {
      console.log("Resultado: " + resultado);
    }
  };

  dividirAsync(3, 0, manejarErrores);
};

const ex12 = () => {
  const procesarLista = (arr, func) => {
    let sinProcesar = arr.length;

    for (let i of arr) {
      let tiempo = Math.trunc(Math.random() * 1001) + 500;

      setTimeout(() => {
        console.log("Procesando " + i);
        sinProcesar--;

        if (sinProcesar == 0) {
          func("Proceso completo");
        }
      }, tiempo);
    }
  };

  const imprimir = (str) => {
    console.log(str);
  };

  procesarLista([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], imprimir);
};

const ex13 = () => {
  const cargarMensaje = () => {
    console.log("Iniciando tarea");
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve("Mensaje cargado");
      }, 1000);
    });
  };

  const ortografia = (texto) => {
    console.log(texto + ".");
  };

  cargarMensaje()
    .then(ortografia)
    .catch((error) => {
      console.log("Error:", error);
    });
};

const ex14 = () => {
  const cargarUsuario = () => {
    console.log("Iniciando tarea...");
    return new Promise((resolve, reject) => {
      let tiempo = Math.trunc(Math.random() * 701) + 800;
      let usuario = {
        id: "US001",
        nombre: "Josue",
      };
      setTimeout(() => {
        resolve(usuario);
      }, tiempo);
    });
  };
  const imprimirUsuario = (usuario) => {
    console.log(`Usuario Cargado: ${usuario.nombre} (ID:${usuario.id})`);
  };

  cargarUsuario()
    .then(imprimirUsuario)
    .catch((e) => {
      console.log("Error asd:", e);
    });
};

const ex15 = () => {
  const dividirAsync = (a, b) => {
    console.log("Iniciando tarea...");
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (b === 0) {
          reject(new Error("No se puede dividir entre cero"));
        } else {
          resolve(a / b);
        }
      }, 1500);
    });
  };

  dividirAsync(3, 0)
    .then((resultado) => {
      console.log("Resultado:", resultado);
    })
    .catch((e) => console.log(e));
};

const ex16 = () => {
  const procesarLista = (arr) => {
    console.log("Iniciando tarea...");
    return new Promise((resolve, reject) => {
      let sinProcesar = arr.length;

      for (let i of arr) {
        let tiempo = Math.trunc(Math.random() * 1001) + 500;

        setTimeout(() => {
          console.log("Procesando " + i);
          sinProcesar--;

          if (sinProcesar == 0) {
            resolve("Proceso completo");
          }
        }, tiempo);
      }
    });
  };

  const imprimir = (str) => {
    console.log(str);
  };

  procesarLista([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    .then(imprimir)
    .catch((e) => {
      console.log(e);
    });
};

const ex17 = async () => {
  console.log("Iniciando tarea...");

  const resultado = await new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("Mensaje cargado");
    }, 1000);
  });

  console.log(resultado);
};

const ex18 = async () => {
  console.log("Iniciando tarea...");

  const resultado = await new Promise((resolve, reject) => {
    let tiempo = Math.trunc(Math.random() * 701) + 800;
    setTimeout(() => {
      let usuario = {
        id: "US001",
        nombre: "Josue",
      };
      resolve(usuario);
    }, tiempo);
  });
  console.log(`Usuario Cargado: ${resultado.nombre} (ID:${resultado.id})`);
};

const ex19 = () => {
  const dividirAsync = async (a, b) => {
    console.log("Iniciando tarea...");

    const resultado = await new Promise((resolve, reject) => {
      setTimeout(() => {
        if (b === 0) {
          reject("No se puede dividir entre 0");
        }
        resolve(a / b);
      });
    });

    console.log(resultado);
  };

  dividirAsync(3, 0).catch((e) => {
    console.log("Error:", e);
  });
};

const ex20 = () => {
  const procesarLista = async (arr) => {
    console.log("Iniciando tarea...");

    const resultado = await new Promise((resolve, reject) => {
      let restantes = arr.length;
      for (let i of arr) {
        let tiempo = Math.trunc(Math.random() * 1001) + 500;
        console.log("Procesando", i);
        setTimeout(() => {
          console.log(i, "procesado");
          restantes--;
          if (restantes == 0) {
            resolve("Proceso completo");
          }
        }, tiempo);
      }
    });

    console.log(resultado);
  };

  procesarLista([1, 2, 3, 4]).catch((e) => {
    console.log("Error:", e);
  });
};
