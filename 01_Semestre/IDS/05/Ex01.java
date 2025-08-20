import java.util.Scanner;

public class Ex01 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      int num1, num2, num3, suma;

      System.out.print("Digite el primer número a sumar: ");
      num1 = sc.nextInt();
      System.out.print("Digite el segundo número a sumar: ");
      num2 = sc.nextInt();
      System.out.print("Digite el tercer número a sumar: ");
      num3 = sc.nextInt();

      suma = num1 + num2 + num3;

      System.out.print("La suma de los tres números es " + suma);
   }
}
