const ex03 = () => {
  let num = parseFloat(prompt("Digite un número decimal"));
  alert(`${Math.floor(num)}\n${Math.ceil(num)}\n${Math.round(num)}`);
};

const ex04 = () => {
  const numeroAleatorio = (min, max) => {
    return Math.round(Math.random() * (max - min) + min);
  };

  let max = parseInt(prompt("Digite el máximo"));
  let min = parseInt(prompt("Digite el mínimo"));

  alert(numeroAleatorio(min, max));
};

const ex05 = () => {
  const lanzarDado = () => {
    return Math.round(Math.random() * (6 - 1) + 1);
  };
  alert(lanzarDado() + lanzarDado());
};

const ex06 = () => {
  let num = parseFloat(prompt("Digite un número"));
  alert(
    `Cuadrado ${Math.pow(num, 2)}\nCubo ${Math.pow(num, 3)}\nRaiz ${Math.sqrt(num)}`,
  );
};

const ex07 = () => {
  const gradosARadianes = (grados) => {
    let radianes = (Math.PI * grados) / 180;
    alert(`Seno ${Math.sin(radianes)}\nCoseno ${Math.cos(radianes)}`);
    return radianes;
  };
  const radianesAGrados = (radianes) => {
    let grados = (radianes * 180) / Math.PI;
    return grados;
  };

  let angulo = parseFloat(prompt("Digite un ángulo en grados sexagesimales"));
  let radianes = gradosARadianes(angulo);
  alert(
    `Radianes ${radianes}\nSexagesimales(errores de redondeo) ${radianesAGrados(radianes)}`,
  );
};

const ex08 = () => {
  const generarContraseña = () => {
    let pass = "";
    for (let i = 0; i < 6; i++) {
      pass += Math.round(Math.random() * 9);
    }
    return pass;
  };
  alert(generarContraseña());
};

const ex09 = () => {
  const calcularDistancia = (x1, y1, x2, y2) => {
    return Math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2);
  };
  let x1 = parseFloat(
    prompt("Digite el valor en el eje x de la primera coordenada"),
  );
  let y1 = parseFloat(
    prompt("Digite el valor en el eje y de la primera coordenada"),
  );
  let x2 = parseFloat(
    prompt("Digite el valor en el eje x de la segunda coordenada"),
  );
  let y2 = parseFloat(
    prompt("Digite el valor en el eje y de la segunda coordenada"),
  );

  let entre = calcularDistancia(x1, y1, x2, y2);
  let origen =
    calcularDistancia(x1, y1, 0, 0) + calcularDistancia(x2, y2, 0, 0);
  alert(`Distancia entre ellos ${entre}\nSuma al origen ${origen}`);
};

const ex10 = () => {
  let calificaciones = [19, 2, 17, 5, 10];
  let maximo = Math.max(...calificaciones);
  let normalizadas = [];
  for (let i = 0; i < calificaciones.length; i++) {
    normalizadas[i] = calificaciones[i] / maximo;
  }
  alert(normalizadas);
};
