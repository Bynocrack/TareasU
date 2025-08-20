import java.util.Scanner;

public class Ex02a {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int num1, num2, resultado = 1;
      System.out.print("Digite el primer número: ");
      num1 = sc.nextInt();
      System.out.print("Digite el segundo número: ");
      num2 = sc.nextInt();

      if (num1 < 0 || num2 < 0) { System.out.print("Uno de los números es negativo!!"); }
      else {
	 for (int i = num1; i > 1; i--) { resultado *= i; }
	 for (int i = num2; i > 1; i--) { resultado *= i; }
	 System.out.print(resultado);
      }
   }
}
