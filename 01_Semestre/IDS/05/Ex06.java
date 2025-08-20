import java.util.Scanner;

public class Ex06 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      double capital, interes, monto;

      System.out.print("Digite su capital: ");
      capital = sc.nextDouble();

      interes = capital*0.085;
      monto = capital + interes;

      System.out.println("El interés que gano es de " + interes);
      System.out.println("El monto total que posee es de " + monto);
   }
}
