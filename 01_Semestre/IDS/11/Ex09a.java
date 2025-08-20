import java.util.Scanner;

public class Ex09a {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      int antiguedad;
      double salario, bono;

      System.out.print("Digite su salario: ");
      salario = sc.nextDouble();
      System.out.print("Digite su antiguedad (en meses): ");
      antiguedad = (int) (sc.nextInt()/12);

      if (antiguedad < 1) {
	 bono = salario * 0.05;
      } else if (antiguedad < 2) {
	 bono = salario * 0.07;
      } else if (antiguedad < 5) {
	 bono = salario * 0.1;
      } else if (antiguedad < 10) {
	 bono = salario * 0.15;
      } else {
	 bono = salario * 0.2;
      }

      System.out.print("Su bono es de: " + bono);
   }
}
