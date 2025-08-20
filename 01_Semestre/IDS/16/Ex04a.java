import java.util.Scanner;

public class Ex04a {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int num1;

      System.out.print("Digite un número: ");
      num1 = sc.nextInt();

      muestra(num1);
   }
   public static void muestra (int num1) {
      if (num1 % 2 == 0) { System.out.print(num1 + " es par."); }
      else { System.out.print(num1 + " es impar."); }
   }
}
