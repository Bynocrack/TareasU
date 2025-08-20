import java.util.Scanner;

public class Ex02 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int num1, num2, mcd = 1, resto = 1;

      System.out.print("Digite un entero positivo: ");
      num1 = sc.nextInt();
      System.out.print("Digite otro entero positivo: ");
      num2  = sc.nextInt();

      while (resto != 0) {
	 resto = num1%num2;
	 num1 = num2;
	 mcd = num2;
	 num2 = resto;
      }
      System.out.print("El mcd es: " + mcd);
   }
}
