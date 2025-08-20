import java.util.Scanner;

public class Ex03b {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int m, n;

      System.out.print("Digite el valor de m: ");
      m = sc.nextInt();
      System.out.print("Digite el valore de n: ");
      n = sc.nextiInt();

      int i = m;
      while (i <= n) {
	 if (i%2 == 0) {
	    System.out.println(i);
	 }
	 i++;
      }
   }
}
