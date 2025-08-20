import java.util.Scanner;

public class Ex06b {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int num1, num2;
      double resultado;

      System.out.print("Digite un número: ");
      num1 = sc.nextInt();
      System.out.print("Digite otro número: ");
      num2 = sc.nextInt();

      resultado = retorna(num1, num2);

      System.out.print("El resultado de operarlos es: " + resultado);
   }
   public static double retorna (int num1, int num2) {
      if (num2 % num1 == 0) { return (double) num1*num2; }
      return (double) num1/num2; 
   }
}
