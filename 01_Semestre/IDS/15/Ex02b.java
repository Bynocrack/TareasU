import java.util.Scanner;

public class Ex02b {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int num1, num2;
      System.out.print("Digite el primer número: ");
      num1 = sc.nextInt();
      System.out.print("Digite el segundo número: ");
      num2 = sc.nextInt();

      if (num1 < 0 || num2 < 0) { System.out.print("Uno de los números ingresados es negativo!!"); }
      else { System.out.print(factorial(num1) * factorial(num2)); }
   }
   public static int factorial(int num) {
      if (num == 0) { return 1; }
      else { return num*factorial(num-1); }
   }
}
