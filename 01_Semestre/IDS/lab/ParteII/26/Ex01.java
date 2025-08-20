import java.util.*;

public class Ex01 {
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
	 if (num2 == 0) { throw new Exception("Denomiador 0"); }
	 ans = num1/num2;
	 System.out.print("El resultado de la división es: " + ans);
      } catch (NumberFormatException e) {
	 System.out.print("Tienen que ser números!");
      } catch (Exception e) {
	 System.out.print("Algo salio mal (probablemente denominador = 0)");
      }
   }
}
