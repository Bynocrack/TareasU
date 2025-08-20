import java.util.Scanner;

public class Ex05 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Digite la cantidad de datos: ");
      int n = sc.nextInt();

      int[] datos = new int[n];
      for (int i = 0; i < n; i++) {
	 System.out.print("Digite el " + (i+1) + " elemento: ");
	 datos[i] = sc.nextInt();
      }
      System.out.print("Que elemento quiere buscar? ");
      int buscar = sc.nextInt();

      int metodo1 = parar(datos, buscar);
      int metodo2 = noParar(datos, buscar);

      if (metodo1 != metodo2) {
	 System.out.print("ERROR!");
      } else {
	 if (metodo1 != -1) {
	    System.out.print("El elemento esta en la posición: " + metodo1);
	 } else {
	    System.out.print("No se encontro el elemento");
	 }
      }
   }
   public static int parar (int[] lista, int objetivo) {
      for (int i = 0; i < lista.length; i++) {
	 if (lista[i] == objetivo) { return i; }
      }
      return -1;
   }
   public static int noParar (int[] lista, int objetivo) {
      int pos = -1;
      for (int i = 0; i < lista.length; i++) {
	 if (lista[i] == objetivo) { pos = i; }
      }
      return pos;
   }
}
