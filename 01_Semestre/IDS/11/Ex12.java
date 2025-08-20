import java.util.Scanner;

public class Ex12{
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double nota;

      System.out.print("Digite su nota: ");
      nota = sc.nextDouble();

      nota = (int) (nota*10+0.5)/ 10.0;

      if (nota <= 4.9) {
	 System.out.print("Reprobado, repite el semestre.");
      } else if (nota <= 10.4) {
	 System.out.print("Reprobado, pasa a subsanación.");
      } else if (nota <= 15.9) {
	 System.out.print("Aprobado");
      } else {
	 System.out.print("Aprobado con distinción máxima.");
      }
   }
}




