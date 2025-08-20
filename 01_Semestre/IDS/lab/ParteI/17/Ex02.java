import java.util.Scanner;

public class Ex02 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int n, cuantos = 1, actual = 2;
      boolean esPrimo;

      System.out.print("Digite la cantidad de primos: ");
      n= sc.nextInt();
      while (cuantos <= n) {
	 esPrimo = true;
	 for (int i = 2; i < actual; i++) {
	    if (actual % i == 0) {
	       esPrimo = false;
	       break;
	    }
	 }
	 if (esPrimo) {
	    cuantos++;
	    System.out.println(actual);
	 }
	 actual++;
      }
   }
}
