import java.util.Scanner;

public class Ex04 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double prom = 0, suma = 0;
      int nota, total, n, min = 21;

      System.out.print("Digite la cantidad de alumnos (en números): ");
      n = sc.nextInt();
      while (n<0) {
	 System.out.print("Tienes alumnos negativos???, prueba de nuevo: ");
	 n = sc.nextInt();
      }

      for (int i = 0; i<n; i++) {
	 System.out.print("Digite una nota: ");
	 nota = sc.nextInt();
	 while (nota > 20 || nota < 0) {
	    System.out.print("Esta fuera del rango, pruebe de nuevo: ");
	    nota = sc.nextInt();
	 }
	 if (nota < min) min = nota;
	 suma += nota;
      }

      if (n != 0) prom = suma/n;
      System.out.print("El promedio es: " + prom + ", y la nota mínima es: " + min);
   }
}
