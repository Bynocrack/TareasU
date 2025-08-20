import java.util.Scanner;

public class Ex09 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double mujeres = 0, hombres = 0;
      char actual;
      while (true) {
	 System.out.print("Digite si el siguiente alumno es hombre o mujer (h/m): ");
	 actual = sc.next().toUpperCase().charAt(0);
	 if (actual == 'H') hombres++;
	 else if (actual == 'M') mujeres++;
	 else System.out.println("No es una respuesta valida, ingrese solo hombre o mujer.");

	 System.out.println("El total de hombres es " + hombres + " y en porcentaje es " + (hombres/(hombres+mujeres)*100 + "%"));
	 System.out.println("El total de mujeres es " + mujeres + " y en porcentaje es " + (mujeres/(hombres+mujeres)*100 + "%"));
      }
   }
}
