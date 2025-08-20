import java.util.Scanner;

public class Ex04 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      double radio, area;

      System.out.print("Digite el radio de un círculo: ");
      radio = sc.nextDouble();

      area = radio*radio*(Math.PI);

      System.out.print("El área de dicho círculo es " + area);
   }
}
