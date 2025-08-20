import java.util.Scanner;

public class Ex01 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int m, n;

      System.out.print("Digite el tope: ");
      n = sc.nextInt();
      System.out.print("Digite el minimo: ");
      m = sc.nextInt();

      for (int i = m; i<=n; i += 5) {
	 if (i%5 != 0)
	    i = i + 5 - (i%5);
	 System.out.println(i + " Es múltiplo de 5");
      }
   }
}
