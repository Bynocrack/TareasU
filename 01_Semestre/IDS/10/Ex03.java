import java.util.Scanner;

public class Ex03 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      int num1, num2;

      System.out.print("Digite el primer número: ");
      num1 = sc.nextInt();
      System.out.print("Digite el segundo número: ");
      num2 = sc.nextInt();

      if (num1 == num2) {
	 System.out.print("Los operadores válidos son ==, <= y >=");
      } else {
	 System.out.print("Los operadores válidos son !=, ");
	 if (num1 < num2) {
	    System.out.print("<");
	 } else {
	    System.out.print(">");
	 }
      }
   }
}
