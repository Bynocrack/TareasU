import java.util.Scanner;

public class Ex09b {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      int antiguedad;
      double salario, bono;

      System.out.print("Digite su salario: ");
      salario = sc.nextDouble();
      System.out.print("Digite su antiguedad (en meses): ");
      antiguedad = (int) (sc.nextInt()/12);

      switch (antiguedad) {
	 case 0:
	    bono = salario * 0.05;
	    break;
	 case 1:
	    bono = salario * 0.07;
	    break;
	 case 2:
	 case 3:
	 case 4:
	    bono = salario * 0.1;
	    break;
	 case 5:
	 case 6:
	 case 7:
	 case 8:
	 case 9:
	    bono = salario * 0.15;
	    break;
	 default:
	    bono = salario * 0.2;
	    break;
      }
      System.out.print("Su bono es de: " + bono);
   }
}
