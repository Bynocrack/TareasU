import java.util.Scanner;

public class Ex06a {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int num1, num2;

      System.out.print("Digite un número: ");
      num1 = sc.nextInt();
      System.out.print("Digite otro número: ");
      num2 = sc.nextInt();

      muestra(num1, num2);
   }
   public static void muestra (int num1, int num2) {
      if (num2 % num1 == 0) { System.out.print("Su multiplicación es: " + (num1*num2)); }
      else { System.out.print("Su división es: " + ((double) num1/num2)); }
   }
}
