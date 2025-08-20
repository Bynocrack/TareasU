import java.util.Scanner;

public class Ex02 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      double num1, num2, resultado;

     System.out.print("Digite el primer número: ");
     num1 = sc.nextDouble();
     System.out.print("Digite el segundo número: ");
     num2 = sc.nextDouble();

     resultado = (num1 + num2)*(num1 + num2);

     System.out.print("Al sumarlos y elevarlos al cuadrado da: " + resultado);
   }
}
