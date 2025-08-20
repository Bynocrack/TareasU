import java.util.Scanner;

public class Ex04b {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int m, n, pares = 0, impares = 0;

      System.out.print("Digite el valor de m: ");
      m = sc.nextInt();
      System.out.print("Digite el valore de n: ");
      n = sc.nextInt();

      int i = m;
      while (i <= n) {
	 if (i%2 == 0) {
	    pares += i;
	 } else {
	    impares += i;
	 }
	 i++;
      }

      System.out.println("La sumatoria de los pares es: "+ pares);
      System.out.print("La sumatoria de los impares es:"+impares);
   }
}
