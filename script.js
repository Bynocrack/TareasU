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

const ex11 = () => {
  class Producto {
    #precio;
    #stock;
    #nombre;

    constructor(nombre, precio, stock) {
      this.#nombre = nombre;
      this.#precio = precio;
      this.#stock = stock;
    }
    venta(cantidad) {
      if (cantidad > this.#stock) {
        console.log("No se pudo realizar la venta, no hay stock suficiente");
        return;
      }
      this.#stock -= cantidad;
      console.log("Se realizo la venta correctamente");
    }
    set nombre(nombre) {
      this.#nombre = nombre;
    }
    get nombre() {
      return this.#nombre;
    }
    set precio(precio) {
      if (precio < 0) {
        console.log(
          "No se coloco el precio, el argumento debe de ser positivo",
        );
        return;
      }
      this.#precio = precio;
    }
    get precio() {
      return "$" + parseFloat(this.#precio).toFixed(2);
    }
    set stock(cantidad) {
      if (cantidad < 0) {
        console.log("No se coloco el stock, el argumento debe de ser positivo");
        return;
      }
      this.#stock = cantidad;
    }
    get stock() {
      return this.#stock;
    }
  }

  const arroz = new Producto("Arroz", 1.2, 100);
  console.log(arroz.stock);
  arroz.venta(101);
  console.log(arroz.stock);
  arroz.venta(90);
  console.log(arroz.stock);
  console.log(arroz.precio);
  arroz.precio = -12;
  console.log(arroz.precio);
  arroz.precio = 2;
  console.log(arroz.precio);
  console.log(arroz.stock);
  arroz.stock = -23;
  console.log(arroz.stock);
  arroz.stock = 1000;
  console.log(arroz.stock);
};

const ex12 = () => {
  class Producto {
    #precio;
    #stock;
    #nombre;

    constructor(nombre, precio, stock) {
      this.#nombre = nombre;
      this.#precio = precio;
      this.#stock = stock;
    }
    venta(cantidad) {
      if (cantidad > this.#stock) {
        console.log("No se pudo realizar la venta, no hay stock suficiente");
        return;
      }
      this.#stock -= cantidad;
      console.log("Se realizo la venta correctamente");
    }
    set nombre(nombre) {
      this.#nombre = nombre;
    }
    get nombre() {
      return this.#nombre;
    }
    set precio(precio) {
      parseFloat(precio).toFixed(2);
      if (precio < 0) {
        console.log(
          "No se coloco el precio, el argumento debe de ser positivo",
        );
        return;
      }
      this.#precio = precio;
    }
    get precio() {
      return "$" + parseFloat(this.#precio).toFixed(2);
    }
    set stock(cantidad) {
      if (cantidad < 0) {
        console.log("No se coloco el stock, el argumento debe de ser positivo");
        return;
      }
      this.#stock = cantidad;
    }
    get stock() {
      return this.#stock;
    }
  }

  let prod = new Producto("Mani", 10, 100);
  console.log(prod.precio);

  prod.precio = "120.5";
  console.log(prod.precio);
};

const ex13 = () => {
  class Figura {
    area() {}
    perimetro() {}
  }

  class Cuadrado extends Figura {
    lado;
    constructor(lado) {
      super();
      this.lado = lado;
    }

    area() {
      return this.lado ** 2;
    }
    perimetro() {
      return this.lado * 4;
    }
  }

  class Triangulo extends Figura {
    base;
    altura;
    constructor(lado1, lado2, lado3) {
      super();
      this.lados = [lado1, lado2, lado3];
      this.semi = (this.lados[0] + this.lados[1] + this.lados[2]) / 2;
    }

    area() {
      return Math.sqrt(
        this.semi *
          (this.semi - this.lados[0]) *
          (this.semi - this.lados[1]) *
          (this.semi - this.lados[2]),
      );
    }

    perimetro() {
      return this.semi * 2;
    }
  }

  let cuadrado = new Cuadrado(5);
  let triangulo = new Triangulo(5, 10, 8);

  console.log(cuadrado.area());
  console.log(cuadrado.perimetro());
  console.log(triangulo.area());
  console.log(triangulo.perimetro());
};

const ex14 = () => {
  class Usuario {
    nombre;
    email;

    constructor(nombre, email) {
      this.nombre = nombre;
      this.email = email;
    }
    mostrarInfo() {
      console.log("Nombre: " + this.nombre + "\nEmail: " + this.email);
    }
  }

  class Cliente extends Usuario {
    #fidelidad;

    constructor(nombre, email, fidelidad) {
      super(nombre, email);
      this.#fidelidad = fidelidad;
    }

    mostrarInfo() {
      console.log(
        "Nombre: " +
          this.nombre +
          "\nEmail: " +
          this.email +
          "\nFidelidad: " +
          this.#fidelidad,
      );
    }
    set fidelidad(num) {
      if (1 <= num && num <= 5) {
        this.#fidelidad = num;
      }
    }
  }

  class Administrador extends Usuario {
    constructor(nombre, email) {
      super(nombre, email);
    }
    mostrarInfo() {
      console.log("Nombre: " + this.nombre + "\nEmail: " + this.email);
    }
    crear(nombre, email) {
      let c = new Cliente(nombre, email, 1);
      return c;
    }
    editar(cliente, fidelidad) {
      cliente.fidelidad = fidelidad;
    }
    eliminar() {
      return null;
    }
  }
  let admin = new Administrador("Pedro", "pedro@gmail.com");
  let c = admin.crear("juan", "juan@hotmail.com");
  c.mostrarInfo();
  admin.editar(c, 4);
  c.mostrarInfo();
};

const ex15 = () => {
  class Usuario {
    nombre;
    email;

    constructor(nombre, email) {
      this.nombre = nombre;
      this.email = email;
    }
    mostrarInfo() {
      console.log("Nombre: " + this.nombre + "\nEmail: " + this.email);
    }
  }

  class Cliente extends Usuario {
    #fidelidad;

    constructor(nombre, email, fidelidad) {
      super(nombre, email);
      this.#fidelidad = fidelidad;
    }

    mostrarInfo() {
      console.log(
        "Nombre: " +
          this.nombre +
          "\nEmail: " +
          this.email +
          "\nFidelidad: " +
          this.#fidelidad,
      );
    }
    set fidelidad(num) {
      if (1 <= num && num <= 5) {
        this.#fidelidad = num;
      }
    }
  }

  class Administrador extends Usuario {
    constructor(nombre, email) {
      super(nombre, email);
    }
    mostrarInfo() {
      console.log("Nombre: " + this.nombre + "\nEmail: " + this.email);
    }
    crear(nombre, email) {
      let c = new Cliente(nombre, email, 1);
      return c;
    }
    editar(cliente, fidelidad) {
      cliente.fidelidad = fidelidad;
    }
    eliminar() {
      return null;
    }
  }
  let listaUsuarios = new Array();

  listaUsuarios[0] = new Cliente("Juan", "Juan@hotmail.com", 5);
  listaUsuarios[1] = new Administrador("Pedro", "Pedro@gmail.com");

  listaUsuarios.forEach((element) => {
    element.mostrarInfo();
  });
};

const ex16 = () => {
  class Empleado {
    nombre;
    sueldoBase;
    constructor(nombre, sueldoBase = 0) {
      this.nombre = nombre;
      this.sueldoBase = sueldoBase;
    }
  }

  class Programador extends Empleado {
    lenguaje;
    constructor(nombre, sueldoBase = 0, lenguaje = "JavaScript") {
      super(nombre, sueldoBase);
      this.lenguaje = lenguaje;
    }

    calcularSueldo() {
      return this.sueldoBase * 1.1;
    }
  }

  class ProgramadorSenior extends Programador {
    constructor(nombre, sueldoBase = 0, lenguaje = "JavaScript") {
      super(nombre, sueldoBase, lenguaje);
    }

    calcularSueldo() {
      return super.calcularSueldo() + this.sueldoBase * 0.15;
    }
  }
};

const ex17 = () => {
  class Cuenta {
    #saldo;
    constructor(saldo = 0) {
      this.#saldo = saldo;
    }

    depositar(monto) {
      if (typeof monto !== "number" || monto <= 0) {
        console.log("Deposito rechazado: monto inválido");
        return false;
      }
      this.#saldo += monto;
      return true;
    }

    retirar(monto) {
      if (typeof monto !== "number" || monto <= 0) {
        console.log("Retiro rechazado: monto inválido");
        return false;
      }
      if (monto > this.#saldo) {
        console.log("Retiro rechazado: saldo insuficiente");
        return false;
      }
      this.#saldo -= monto;
      return true;
    }

    retirarSinValidar(monto) {
      this.#saldo -= monto;
      return true;
    }

    transferir(destCuenta, monto) {
      if (!(destCuenta instanceof Cuenta)) {
        console.log("Transferencia rechazada: destinatario inválido");
        return false;
      }
      if (!this.retirar(monto)) return false;
      destCuenta.depositar(monto);
      return true;
    }

    get saldo() {
      return Number(this.#saldo.toFixed(2));
    }
  }

  class CuentaAhorro extends Cuenta {
    constructor(saldo = 0) {
      super(saldo);
    }

    retirar(monto) {
      if (typeof monto !== "number" || monto <= 0) {
        console.log("Retiro rechazado: monto inválido");
        return false;
      }
      if (monto > this.saldo) {
        console.log(
          "Retiro rechazado: no se permite sobregiro en CuentaAhorro",
        );
        return false;
      }
      return super.retirar(monto);
    }
  }

  class CuentaCorriente extends Cuenta {
    #limiteDescubierto;
    constructor(saldo = 0, limiteDescubierto = 500) {
      super(saldo);
      if (
        typeof limiteDescubierto !== "number" ||
        Number.isNaN(limiteDescubierto) ||
        limiteDescubierto < 0
      ) {
        throw new TypeError("limiteDescubierto debe ser un número >= 0");
      }
      this.#limiteDescubierto = limiteDescubierto;
    }

    retirar(monto) {
      if (typeof monto !== "number" || monto <= 0) {
        console.log("Retiro rechazado: monto inválido");
        return false;
      }
      const disponible = this.saldo + this.#limiteDescubierto;
      if (monto > disponible) {
        console.log("Retiro rechazado: excede límite de sobregiro");
        return false;
      }

      return super.retirarSinValidar(monto);
    }

    get limiteDescubierto() {
      return this.#limiteDescubierto;
    }
  }
};

const ex18 = () => {
  class Carrito {
    items = [];

    static _precioNumero(producto) {
      let p = producto?.precio;
      if (typeof p === "string") {
        p = p.replace(/[^\d.-]/g, "");
      }
      const n = parseFloat(p);
      return Number.isFinite(n) ? n : NaN;
    }

    agregarProducto(producto, cantidad = 1) {
      if (
        !producto ||
        (typeof producto.nombre !== "string" &&
          typeof producto.nombre !== "function")
      ) {
        console.log("Producto inválido");
        return false;
      }
      const nombre =
        typeof producto.nombre === "function"
          ? producto.nombre()
          : producto.nombre;
      const precioNum = Carrito._precioNumero(producto);
      if (Number.isNaN(precioNum) || precioNum < 0) {
        console.log("Precio inválido en el producto:", nombre);
        return false;
      }
      if (typeof cantidad !== "number" || cantidad <= 0) {
        console.log("Cantidad inválida");
        return false;
      }

      const existente = this.items.find(
        (it) => it.producto === producto || it.producto.nombre === nombre,
      );
      if (existente) {
        existente.cantidad += cantidad;
      } else {
        this.items.push({ producto, cantidad });
      }
      return true;
    }

    calcularTotal() {
      const total = this.items.reduce((acc, it) => {
        const precio = Carrito._precioNumero(it.producto);
        return acc + precio * it.cantidad;
      }, 0);
      return Number(total.toFixed(2));
    }

    mostrarResumen() {
      if (this.items.length === 0) {
        console.log("Carrito vacío");
        return;
      }
      console.log("Resumen del carrito:");
      this.items.forEach((it) => {
        const nombre = it.producto.nombre;
        const precio = Carrito._precioNumero(it.producto);
        const subtotal = (precio * it.cantidad).toFixed(2);
        console.log(
          `${nombre} x ${it.cantidad} — $${precio.toFixed(2)} c/u — Subtotal: $${subtotal}`,
        );
      });
      console.log("Total: $" + this.calcularTotal().toFixed(2));
    }

    vaciar() {
      this.items = [];
    }
  }
};

const ex19 = () => {
  class Notificacion {
    constructor(mensaje = "") {
      if (typeof mensaje !== "string")
        throw new TypeError("mensaje debe ser una cadena");
      this.mensaje = mensaje;
    }

    enviar() {
      throw new Error("Método enviar() debe ser implementado por la subclase");
    }
  }

  class Email extends Notificacion {
    constructor(destinatario, asunto, mensaje) {
      super(mensaje);
      if (typeof destinatario !== "string" || typeof asunto !== "string") {
        throw new TypeError("destinatario y asunto deben ser cadenas");
      }
      this.destinatario = destinatario;
      this.asunto = asunto;
    }

    enviar() {
      console.log(
        `Email -> Para: ${this.destinatario} | Asunto: ${this.asunto} | Mensaje: ${this.mensaje}`,
      );
      return true;
    }
  }

  class SMS extends Notificacion {
    constructor(telefono, mensaje) {
      super(mensaje);
      if (typeof telefono !== "string")
        throw new TypeError("telefono debe ser una cadena");
      this.telefono = telefono;
    }

    enviar() {
      console.log(`SMS -> Para: ${this.telefono} | Mensaje: ${this.mensaje}`);
      return true;
    }
  }

  class Push extends Notificacion {
    constructor(deviceId, mensaje) {
      super(mensaje);
      if (typeof deviceId !== "string")
        throw new TypeError("deviceId debe ser una cadena");
      this.deviceId = deviceId;
    }

    enviar() {
      console.log(
        `Push -> Dispositivo: ${this.deviceId} | Mensaje: ${this.mensaje}`,
      );
      return true;
    }
  }

  const procesarNotificaciones = (lista) => {
    if (!Array.isArray(lista))
      throw new TypeError("Se esperaba un array de notificaciones");
    for (const n of lista) {
      if (!(n instanceof Notificacion)) {
        console.log("Elemento ignorado: no es una Notificacion", n);
        continue;
      }
      try {
        n.enviar();
      } catch (err) {
        console.log("Error al enviar notificación:", err.message);
      }
    }
  };
};
