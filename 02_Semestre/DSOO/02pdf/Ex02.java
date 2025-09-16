import java.util.*;

public class Ex02 {
   // Escaner global en caso sea necesario
   static Scanner sc = new Scanner(System.in);

   // Main
   public static void main (String [] args) {
      // Declaramos variables y solicitamos la cantidad de productos
      System.out.print("Digite la cantidad de productos: ");
      int n = sc.nextInt();
      String codigo;
      String nombre;
      int cant;
      Producto[] productos = new Producto[n];

      // Añadimos cada producto con su codigo y su nombre
      for (int i = 0; i < n; i++) {
	 System.out.print("Digite el nombre del producto: ");
	 nombre = sc.next();
	 System.out.print("Digite el codigo del producto: ");
	 codigo = sc.next();
	 productos[i] = new Producto(codigo, nombre);
      }

      // Ordenamos el array alfabeticamente por codigo
      ordenarCodigo(productos);

      // Mostramos que esta ordenado
      System.out.println("\nProductos ordenados por codigo");
      mostrarTodo(productos);

      // Añadimos y quitamos cosas de stock para comprobar funcionalidad
      System.out.print("Digite el codigo del producto a incrementar: ");
      codigo = sc.next();
      System.out.print("Digite la cantidad en la que se va a incrementar: ");
      cant = sc.nextInt();
      agregarStockSecuencial(codigo, cant, productos);
      
      System.out.print("Digite el codigo del producto a retirar: ");
      codigo = sc.next();
      System.out.print("Digite la cantidad en la que se va a retirar: ");
      cant = sc.nextInt();
      retirarStockBinario(codigo, cant, productos);

      // Ordenamos por stock y lo mostramos nuevamente
      ordenarStock(productos);
      System.out.println("\nProductos ordenados por stock");
      mostrarTodo(productos);
   }

   // Funcion para mostrar array
   public static void mostrarTodo(Producto[] lista) {
      for (Producto objeto : lista) {
	 System.out.println(objeto);
      }
      System.out.println();
   }

   // Funcion para ordenar por codigo (bubble sorting)
   public static void ordenarCodigo(Producto[] lista) {
      for (int i = 0; i < lista.length-1; i++) {
	 for (int j = 0; j < lista.length-1-i; j++) {
	    if (lista[j].getCodigo().compareTo(lista[j+1].getCodigo()) > 0) {
	       Producto aux = lista[j];
	       lista[j] = lista[j+1];
	       lista[j+1] = aux;
	    }
	 }
      }
   }

   // Funcion para ordenar por stock (bubble sorting de nuevo xd)
   public static void ordenarStock(Producto[] lista) {
      for (int i = 0; i < lista.length-1; i++) {
	 for (int j = 0; j < lista.length-1-i; j++) {
	    if (lista[j].getStock() < lista[j+1].getStock()) {
	       Producto aux = lista[j];
	       lista[j] = lista[j+1];
	       lista[j+1] = aux;
	    }
	 }
      }
   }

   // Funcion para agregar stock (busqueda secuencial)
   public static void agregarStockSecuencial(String codigo, int cant, Producto[] lista) {
      // Por si ingresan numero negativo xd
      if (cant < 0) {
	 System.out.println("Deseas agregar o retirar? ._.");
	 return;
      }

      // Buscamos el producto, y en caso lo encontremos, modificamos su stock
      for (Producto objeto : lista) {
	 if (codigo.equals(objeto.getCodigo())) {
	    objeto.agregarStock(cant);
	    System.out.println("El nuevo stock de ese producto es: " + objeto.getStock());
	    return;
	 }
      }

      // En caso no encontremos el producto
      System.out.println("Codigo de producto no encontrado");
   }

   // Funcion para retirar stock (Busqueda binaria)
   public static void retirarStockBinario(String codigo, int cant, Producto[] lista) {
      // Quitas o añades?
      if (cant < 0) {
	 System.out.println("Deseas retirar o agregar? ._.");
      }

      // Inicializamos las variables necesarias para la busqueda
      int anteriorPuntero;
      int puntero = lista.length/2;
      int abajo = 0;
      int arriba = lista.length-1;

      // Buscamos el producto
      while (!codigo.equals(lista[puntero].getCodigo())) {
	 // Ya veras para que sirve ;)
	 anteriorPuntero = puntero;

	 // Nos movemos hacia adelante o hacia atras segun sea necesario
	 if (codigo.compareTo(lista[puntero].getCodigo()) < 0) {
	    arriba = puntero;
	    puntero = (abajo+puntero)/2;
	 } else if (codigo.compareTo(lista[puntero].getCodigo()) > 0) {
	    abajo = puntero;
	    puntero = (arriba+puntero+1)/2;
	 }

	 // Si el puntero no se modifica, entonces a alcanzado un bucle infinito
	 // y por lo tanto no encontro el objeto que estaba buscando
	 if (anteriorPuntero == puntero) {
	    System.out.println("Codigo de producto no encontrado");
	    return;
	 }
      }

      // Nos aseguramos que no quede stock negativo antes de modificar
      if (lista[puntero].getStock() - cant < 0) {
	 System.out.println("No se puede efectuar, tendrias stock negativo.");
	 System.out.println("El stock actual de ese producto es: " + lista[puntero].getStock());
      } else {
	 lista[puntero].retirarStock(cant);
	 System.out.println("Hecho!\nEl nuevo stock de ese producto es: " +lista[puntero].getStock());
      }
   }
}
