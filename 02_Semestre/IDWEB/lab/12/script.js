const ex03 = () => {
  const esPar = (num) => {
    return num % 2 == 0 ? true : false;
  };
  let numero = parseInt(prompt("Digite un número"));
  alert(esPar(numero));
};

const ex04 = () => {
  const areaRectanguloBase = (altura, base) => {
    return altura * base;
  };
  let error = "";
  let altura = 0;
  let base = 0;
  while (true) {
    base = parseFloat(prompt(`${error}Digite la base del rectángulo`));
    if (base > 0) {
      break;
    }
    error = "Tiene que ser mayor a 0!\n";
  }
  error = "";
  while (true) {
    altura = parseFloat(prompt(`${error}Digite la altura del rectángulo`));
    if (altura > 0) {
      break;
    }
    error = "Tiene que ser mayor a 0!\n";
  }
  alert(areaRectanguloBase(altura, base));
};

const ex05 = () => {
  const esMultiplo = (a, b) => {
    return a % b == 0 ? true : false;
  };
  let num1 = parseInt(prompt("Digite el valor de a"));
  let num2 = parseInt(prompt("Digite el valor de b"));
  alert(esMultiplo(num1, num2));
};

const ex06 = () => {
  const mayorDeTres = (a, b, c) => {
    a = a > b ? a : b;
    a = a > c ? a : c;
    return a;
  };
  let num1 = parseInt(prompt("Digite el valor de a"));
  let num2 = parseInt(prompt("Digite el valor de b"));
  let num3 = parseInt(prompt("Digite el valor de c"));
  alert(mayorDeTres(num1, num2, num3));
};

const ex07 = () => {
  function promedio(nota1, nota2, nota3) {
    return (nota1 + nota2 + nota3) / 3;
  }
  let nota1 = 0;
  let nota2 = 0;
  let nota3 = 0;
  let error = "";
  while (true) {
    nota1 = parseInt(prompt(`${error}Digite el valor de la primera nota`));
    nota2 = parseInt(prompt(`${error}Digite el valor de la segunda nota`));
    nota3 = parseInt(prompt(`${error}Digite el valor de la tercera nota`));
    if (
      0 <= nota1 &&
      nota1 <= 20 &&
      0 <= nota2 &&
      nota2 <= 20 &&
      0 <= nota3 &&
      nota3 <= 20
    ) {
      break;
    }
    error = "Las notas deben estar entre 0 y 20!\n";
  }
  alert(promedio(nota1, nota2, nota3));
};

const ex08 = () => {
  function converirAMayusculas(texto) {
    return texto.toUpperCase();
  }
  let ejemplo = prompt("Digite la frase para volverla mayusculas");
  alert(converirAMayusculas(ejemplo));
};

const ex09 = () => {
  function calcularDescuento(precio, porcentaje) {
    return precio * (1 - porcentaje / 100);
  }
  let precio = 0;
  let descuento = 0;
  let error = "";

  while (true) {
    precio = parseFloat(prompt(`${error}Digite el precio del producto`));
    if (precio >= 0) {
      break;
    }
    error = "El precio debe ser positio!\n";
  }
  error = "";

  while (true) {
    descuento = parseFloat(
      prompt(`${error}Digite el descuento que se le aplicara <0;100]`),
    );
    if (0 < descuento && descuento <= 100) {
      break;
    }
    error = "Debe ser entre 0 (no incluido) y 100 (incluido)\n";
  }

  alert(calcularDescuento(precio, descuento));
};

const ex10 = () => {
  const saludo = (nombre) => {
    return `Hola ${nombre}, como estás?`;
  };
  let nombre = prompt("Digite su nombre");

  alert(saludo(nombre));
};

const ex11 = () => {
  const esPositivo = (num) => {
    return num > 0 ? true : false;
  };
  let num = parseFloat(prompt("Digite un número"));

  alert(esPositivo(num));
};

const ex12 = () => {
  const componerTransformaciones = (func1, func2) => {
    return function (texto) {
      return func1(func2(texto));
    };
  };

  const signo = (texto) => {
    return texto + "!";
  };

  const mayusculas = (texto) => {
    return texto.toUpperCase();
  };

  const transformar = componerTransformaciones(signo, mayusculas);

  let frase = prompt("Digite una frase");
  alert(transformar(frase));
};

const ex13 = () => {
  const procesarTexto = (texto) => {
    const limpiarEspacios = (texto) => {
      return texto.replaceAll(" ", "");
    };

    const contarPalabras = (texto) => {
      let espacio = false;
      let palabras = 0;
      if (texto.length > 0) {
        palabras = 1;
      }
      for (let c of texto) {
        if (!espacio && c == " ") {
          espacio = true;
          palabras++;
        } else if (c != " ") {
          espacio = false;
        }
      }
      return palabras;
    };

    return [limpiarEspacios(texto), contarPalabras(texto)];
  };

  let frase = prompt("Digite una frase");
  alert(procesarTexto(frase));
};

const ex14 = () => {
  const operacionesMatematicas = (operacion, a = 0, b = 0) => {
    const sumar = (num1 = a, num2 = b) => num1 + num2;
    const resta = (num1 = a, num2 = b) => num1 - num2;
    const multi = (num1 = a, num2 = b) => num1 * num2;
    const divid = (num1 = a, num2 = b) =>
      num2 != 0 ? num1 / num2 : "No se puede dividir entre 0";

    switch (operacion) {
      case "s":
        return sumar;
      case "r":
        return resta;
      case "m":
        return multi;
      case "d":
        return divid;
      default:
        return "No es válido";
    }
  };
  const sumar = operacionesMatematicas("s");
  const resta = operacionesMatematicas("r", 4, 5);
  alert(sumar(3, 5));
  alert(resta());
  alert(resta(2, 5));
};

const ex15 = () => {
  const crearContador = () => {
    let n = 0;
    return [
      function () {
        n++;
        return n;
      },
      function () {
        n = 0;
        return n;
      },
    ];
  };
  let [incrementar, resetear] = crearContador();
  alert(incrementar());
  alert(resetear());
  alert(incrementar());
};

const ex16 = () => {
  const acumulador = (valorInicial) => {
    return function (x) {
      valorInicial += x;
      return valorInicial;
    };
  };

  const inicio5 = acumulador(5);
  alert(inicio5(10));
  alert(inicio5(25));
};

const ex17 = () => {
  const saludo = (nombre = "Amigo") => {
    alert(`Hola ${nombre}`);
  };

  saludo();
  saludo("j0tar");
};

const ex18 = () => {
  const media = (...numeros) => {
    let suma = 0;
    for (let num of numeros) {
      suma += num;
    }
    return suma / numeros.length;
  };

  alert(media(3, 4, 5, 6));
  alert(media(1, 2, 3, 4));
};

const ex19 = () => {
  const mostrarDatos = (nombre, edad, ...hobbies) => {
    let output = "Mi nombre es: " + nombre;
    output += "\nMi edad es: " + edad + "\nMis hobbies son:\n";
    for (let hobbie of hobbies) {
      output += hobbie + "\n";
    }
    return output;
  };

  alert(mostrarDatos("Josue", 18, "Programar", "Jugar", "Caminar"));
};

const ex20 = () => {
  const ejecutarOperacion = (fn, x, y) => {
    return fn(x, y);
  };
  const sumar = (a, b) => a + b;
  const resta = (a, b) => a - b;

  alert(ejecutarOperacion(sumar, 4, 5));
  alert(ejecutarOperacion(resta, 4, 5));
};

const ex21 = () => {
  const filtrarArreglo = (arr, callback) => {
    let output = [];
    let i = 0;
    for (item of arr) {
      if (callback(item)) {
        output[i] = item;
        i++;
      }
    }
    return output;
  };

  const filtro = (item) => {
    if (item > 6) {
      return true;
    }
    return false;
  };

  alert(filtrarArreglo([3, 4, 5, 6, 7, 2, 1, 9], filtro));
};

const ex22 = () => {
  const descargarArchivo = (url, callback) => {
    alert("Descargando...");
    callback(url);
  };

  const descarga = (url) => {
    alert("Descarga completa de " + url);
  };

  descargarArchivo("https://www.J0tar.com", descarga);
};

const ex23 = () => {
  const elevar = (base, exponente) => {
    if (exponente == 0) {
      return 1;
    } else if (exponente > 0) {
      return base * elevar(base, exponente - 1);
    } else {
      return 1 / elevar(base, exponente * -1);
    }
  };

  alert(elevar(3, 4));
  alert(elevar(3, -4));
};

const ex24 = () => {
  const crearSecuencia = (inicio, paso) => {
    inicio -= paso;
    return function () {
      inicio += paso;
      return inicio;
    };
  };

  const secuencia = crearSecuencia(2, 3);
  alert(secuencia());
  alert(secuencia());
  alert(secuencia());
  alert(secuencia());
};
