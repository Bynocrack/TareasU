import java.util.Scanner;

public class Ex01c {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int m, n;

      System.out.print("Digite el valor de m: ");
      m = sc.nextInt();
      System.out.print("Digite el valore de n: ");
      n = sc.nextInt();

      int i = m;
      do {
	 System.out.println(i);
	 i++;
      } while (i <= n);
   }
}
