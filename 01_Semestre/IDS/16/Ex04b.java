import java.util.Scanner;

public class Ex04a {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int num1;
      boolean par;

      System.out.print("Digite un número: ");
      num1 = sc.nextInt();

      par = retorna(num1);

      if (par) { System.out.print(num1 + " es par."); }
      else { System.out.print(num1 + " es impar."); }
   }
   public static boolean retorna (int num1) {
      if (num1 % 2 == 0) { return true; }
      return false;
   }
}
