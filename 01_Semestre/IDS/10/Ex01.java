import java.util.Scanner;

public class Ex01 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      double nota1, nota2, nota3, promedio;

      System.out.print("Digite la primera nota: ");
      nota1 = sc.nextDouble();
      System.out.print("Digite la segunda nota: ");
      nota2 = sc.nextDouble();
      System.out.print("Digite la tercera nota: ");
      nota3 = sc.nextDouble();

      promedio = (nota1 + nota2 + nota3)/3.0;

      if (promedio >= 13.0) {
	 System.out.print("Aprobaste!");
      } else {
	 System.out.print("No has aprobado.");
      }
   }
}
