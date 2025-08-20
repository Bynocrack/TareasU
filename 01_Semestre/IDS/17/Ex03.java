import java.util.Scanner;

public class Ex03 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      int n;

      System.out.print("Digite el tamaño del arreglo: ");
      n = sc.nextInt();
      int[] numeros = ingresar(n);
      modificar(numeros);
      imprimir(numeros);
   }
   public static int[] ingresar (int n) {
      int[] output = new int[n];
      for (int i = 0; i < n; i++) {
	 System.out.print("Digite el valor de la posición " + i + " del arreglo: ");
	 output[i] = sc.nextInt();
      }
      return output;
   }
   public static void modificar (int[] arreglo) {
      for (int i = 0; i < arreglo.length; i++) {
	 arreglo[i] *= 2;
      }
   }
   public static void imprimir (int[] arreglo) {
      for (int i = 0; i < arreglo.length; i++) {
	 System.out.println("El nuevo valor de la posición " + i + " del arreglo es: " + arreglo[i]);
      }
   }
}
