import java.util.*;

public class Ex02 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      String in1, in2;
      double num1, num2, ans;
      System.out.print("Digite el numerador: ");
      in1 = sc.next();
      System.out.print("Digite el denominador: ");
      in2 = sc.next();
      try {
	 num1 = Integer.parseInt(in1);
	 num2 = Integer.parseInt(in2);
	 ans = cociente(num1, num2);
	 System.out.print("El resultado de dividir es: " + ans);
      } catch (Exception e) {
	 System.out.print(e);
      }
   }
   public static double cociente(double num, double den) throws Exception {
      if (den == 0) { throw new Exception("El denominador debe ser distinto de 0!"); }
      return num/den;
   }
}
