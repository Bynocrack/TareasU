import java.util.Scanner;

public class Ex03b {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int m, n, num, intentos = 0;

      System.out.print("Digite el minimo: ");
      m = sc.nextInt();
      System.out.print("Digite el máximo: ");
      n = sc.nextInt();
      while (m > n) {
	 System.out.print("No puede ser mas pequeño que el minimo!, pruebe de nuevo: ");
	 n = sc.nextInt();
      }
      num = m-1;

      while (num < m || num > n) {
	 System.out.print("Digite un número: ");
	 num = sc.nextInt();
	 intentos++;
      }

      System.out.print("Logró ingresar un número en el rango, la cantidad de intentos fue: " + intentos);
   }
}
