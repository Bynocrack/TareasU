import java.util.Scanner;

public class Ex07 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      int num1, num2, resultado;

      System.out.print("Digite el primer número: ");
      num1 = sc.nextInt();
      System.out.print("Digite el segundo número: ");
      num2 = sc.nextInt();

      if (num1 == num2) {
	 resultado = num1*num2;
      } else if (num1 > num2) {
	 resultado = num1 - num2;
      } else {
	 resultado = num1 + num2;
      }

      System.out.print("El resultado de operarlos es: " + resultado);
   }
}
