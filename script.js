const ex03 = () => {
  const doblarNumeros = (arr) => {
    let output = [];
    for (let i = 0; i < arr.length; i++) {
      output[i] = arr[i] * 2;
    }
    return output;
  };

  alert(doblarNumeros([2, 3, 4, 5, 6]));
};

const ex04 = () => {
  const filtrarYTransformar = (arr) => {
    let suma = 0;
    for (num of arr) {
      suma += num < 0 ? 0 : num ** 2;
    }
    return suma;
  };

  alert(filtrarYTransformar([2, -3, 0, 4, -6, 5]));
};

const ex05 = () => {
  const reordenarPalabras = (frase) => {
    let palabras = [];
    let palabra = "";
    for (c of frase) {
      if (c == " ") {
        if (palabra.length > 0) {
          palabras.push(palabra.toUpperCase());
          palabra = "";
        }
      } else {
        palabra += c;
      }
    }
    if (palabra.length > 0) {
      palabras.push(palabra.toUpperCase());
      palabra = "";
    }
    palabras.sort();

    return palabras;
  };

  alert(reordenarPalabras("Hola    como estas amigo"));
};

const ex06 = () => {
  let nombres = ["Jose", "Josue", "JOSUE", "Johan", "Jafet", "Jazmin"];
  let conjunto = new Set();

  nombres.forEach((x) => conjunto.add(x.toUpperCase()));
  nombres = [];
  conjunto.forEach((x) => nombres.push(x[0] + x.slice(1).toLowerCase()));
  alert(nombres);
};

const ex07 = () => {
  const tieneDuplicados = (arr) => {
    let set = new Set(arr);
    return set.size == arr.length ? false : true;
  };

  alert(tieneDuplicados([2, 3, 3]));
};

const ex08 = () => {
  const precios = new Map([
    ["arroz", 3.5],
    ["fideos", 4],
    ["azucar", 3],
  ]);
  let lista = [0, 0, 0];
  while (true) {
    let opt = parseInt(
      prompt(
        "Que desea añadir a su lista?\n1) Arroz\n2) Fideos\n3) Azucar\n0) Salir",
      ),
    );
    let salir = false;
    switch (opt) {
      case 0:
        salir = true;
        break;
      case 1:
        lista[0]++;
        break;
      case 2:
        lista[1]++;
        break;
      case 3:
        lista[2]++;
        break;
      default:
        alert("ERROR, DIGITE SOLO 0, 1, 2 o 3, NO SE AÑADIO NADA");
    }
    if (salir) {
      break;
    }
  }

  let precio =
    precios.get("arroz") * lista[0] +
    precios.get("fideos") * lista[1] +
    precios.get("azucar") * lista[2];
  alert("El precio final es " + precio);
};

const ex09 = () => {
  const contarPalabras = (texto) => {
    texto = texto.toLowerCase();
    let indice = texto.indexOf(" ");
    let mapa = new Map();
    while (indice != -1) {
      let palabra = texto.slice(0, indice);
      texto = texto.slice(indice + 1);
      indice = texto.indexOf(" ");
      if (!mapa.has(palabra)) {
        mapa.set(palabra, 1);
      } else {
        mapa.set(palabra, mapa.get(palabra) + 1);
      }
    }
    palabra = texto;
    if (!mapa.has(palabra)) {
      mapa.set(palabra, 0);
    } else {
      mapa.set(palabra, mapa.get(palabra) + 1);
    }
    let output = "Map {";
    mapa.forEach((x, y) => (output += " " + y + " => " + x + " "));
    return output + "}";
  };

  alert(
    contarPalabras(
      "Hola amigos y digo HOLA porque es halloween! viva! nos vemos amigos",
    ),
  );
};

const ex10 = () => {
  const invertirMap = (map) => {
    let mapa = new Map();
    map.forEach((x, y) => mapa.set(x, y));

    let output = "Map {";
    mapa.forEach((x, y) => (output += " " + y + " => " + x + " "));
    return output + "}";
  };

  const map = new Map([
    ["Perú", "Lima"],
    ["Chile", "Santiago"],
  ]);
  alert(invertirMap(map));
};

const ex11 = () => {
  const carro = {
    marca: "Mitsubishi",
    modelo: "Pajero Jr",
    año: 1998,
    detalles() {
      alert(`marca: ${this.marca}\nmodelo: ${this.modelo}\naño: ${this.año}`);
    },
  };

  carro.detalles();
};

const ex12 = () => {
  const contarLetras = (texto) => {
    const letras = {};
    for (c of texto) {
      letras[c] = (letras[c] || 0) + 1;
    }
    return letras;
  };
  console.log(contarLetras("raul es cabro"));
};

const ex13 = () => {
  const combinarCatalagos = (tiendaA, tiendaB) => {
    let claves = Object.keys(tiendaA);
    Object.keys(tiendaB).forEach((x) => claves.push(x));
    claves = [...new Set(claves)];
    const catalogo = {};
    for (let i = 0; i < claves.length; i++) {
      let valor1 = Infinity;
      let valor2 = Infinity;
      if (tiendaA[claves[i]] != undefined) {
        valor1 = tiendaA[claves[i]];
      }
      if (tiendaB[claves[i]] != undefined) {
        valor2 = tiendaB[claves[i]];
      }
      catalogo[claves[i]] = valor1 > valor2 ? valor2 : valor1;
    }
    return catalogo;
  };

  const tiendaA = {
    arroz: 3.5,
    queso: 15,
    azucar: 4,
  };

  const tiendaB = {
    arroz: 4,
    azucar: 3,
    leche: 5.5,
  };

  console.log(combinarCatalagos(tiendaA, tiendaB));
};

const ex14 = () => {
  class Empleado {
    constructor(id, nombre, area, salario) {
      this.id = id;
      this.nombre = nombre;
      this.salario = salario;
      this.area = area;
    }
  }

  const gestionarEmpleados = (empleados) => {
    let map = new Map();
    for (let empleado of empleados) {
      if (map.has(empleado.area)) {
        map.get(empleado.area).push(empleado.nombre);
      } else {
        map.set(empleado.area, [empleado.nombre]);
      }
    }
    return map;
  };

  let empleados = [
    new Empleado(1, "Juan", "Ventas", 2400),
    new Empleado(2, "Marta", "Ventas", 2600),
    new Empleado(3, "Luis", "TI", 4000),
    new Empleado(4, "Ana", "Recursos Humanos", 3000),
  ];

  console.log(gestionarEmpleados(empleados));
};
