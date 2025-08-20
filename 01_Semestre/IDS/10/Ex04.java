import java.util.Scanner;

public class Ex04 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      double interes, monto, capital;

      System.out.print("Digite el capital a invertir: ");
      capital = sc.nextDouble();
      System.out.print("Digite el porcentaje de interes anual: ");
      interes = sc.nextDouble();

      monto = capital*(1+interes/100.0);

      if (monto - capital < 200) {
	 System.out.print("No te conviene invertir (interes menor a 200)");
      } else {
	 System.out.println("Te conviene invertir");
	 System.out.print("El monto al finalizar el año sera: " + monto);
      }
   }
}
