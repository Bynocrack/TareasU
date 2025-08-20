import java.util.Scanner;

public class Ex08 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      double num1, num2, num3, num4, max;
      
      System.out.print("Digite el primer número: ");
      num1 = sc.nextDouble();
      System.out.print("Digite el segundo número: ");
      num2 = sc.nextDouble();
      System.out.print("Digite el tercer número: ");
      num3 = sc.nextDouble();
      System.out.print("Digite el cuarto número: ");
      num4 = sc.nextDouble();

      max = num1;
      if (num2 > max)
	 max = num2;
      if (num3 > max)
	 max = num3;
      if (num4 > max)
	 max = num4;

      System.out.print("El mayor valor es " + max);
   }
}
