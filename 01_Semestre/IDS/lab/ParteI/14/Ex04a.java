import java.util.Scanner;

public class Ex04a {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int m, n, pares = 0, impares = 0;

      System.out.print("Digite el valor de m: ");
      m = sc.nextInt();
      System.out.print("Digite el valore de n: ");
      n = sc.nextInt();

      for (int i = m; i <= n; i++) {
	 if (i%2 == 0) {
	    pares += i;
	 } else {
	    impares += i;
	 }
      }

      System.out.println("La sumatoria de los pares es: "+ pares);
      System.out.print("La sumatoria de los impares es:"+impares);
   }
}
