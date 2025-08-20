import java.util.Scanner;

public class Ex01 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int[] numeros = {1, 2, 3, 4, 5};
      int suma;

      suma = sumar(numeros);

      System.out.print("La suma es: " + suma);
   }
   public static int sumar(int[] a) {
      for (int i = 1; i<a.length; i++) {
	 a[0] += a[i];
      }
      return a[0];
   }
}
