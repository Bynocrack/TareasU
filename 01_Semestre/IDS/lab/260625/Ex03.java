import java.util.Scanner;

public class Ex03 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int[] lista = {12, 6, -8, 4, 30, -40, 6, 9, 4, 22};
      double prom;

      prom = promedio3divisores(lista);
      System.out.print("El promedio de los números con exactamente 3 divisores es: " + prom);
   }

   public static double promedio3divisores(int[] lista) {
      int suma = 0, conteo = 0;
      for (int i = 0; i < lista.length; i++) {
	 if (Divisores3(lista[i])) {
	    suma += lista[i];
	    conteo++;
	 }
      }
      if (conteo == 0) {
	 return 0.0;
      }
      return (double) suma/conteo;
   }

   public static boolean Divisores3(int n) {
      int divisores = 0;
      if (n <= 0) {
	 return false;
      }
      for (int i = 1; i <= n; i++) {
	 if (n%i == 0) {
	    divisores += 1;
	 }
	 if (divisores > 3) {
	    return false;
	 }
      }
      if (divisores == 3) {
	 return true;
      }
      return false;
   }
}
