import java.util.Scanner;

public class Ex02 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int pos = 0, neg = 0, num;
      while (true) {
	 System.out.print("Digite un número: ");
	 num = sc.nextInt();

	 if (num == 0) break;
	 if (num > 0) pos++;
	 if (num < 0) neg++;
      }
      System.out.println("La cantidad de positivos es: " + pos);
      System.out.print("La cantida de negativos es: " + neg);
   }
}
