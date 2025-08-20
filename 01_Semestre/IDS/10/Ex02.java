import java.util.Scanner;

public class Ex02 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      int num1, num2;

      System.out.print("Digite el primer número: ");
      num1 = sc.nextInt();
      System.out.print("Digite el segundo número: ");
      num2 = sc.nextInt();

      if (num1 <= num2) {
	 System.out.print(num1 + " " + num2);
      } else {
	 System.out.print(num2 + " " + num1);
      }
   }
}
