// Laboratorio Nro 10 - Ejercicio5
// Autor: Josue Alexander Madueño Macedo
// Colaboró: nadie
// Tiempo: 5

import java.util.Scanner;

public class Ex05 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int jugador, computadora, dificultad;

      System.out.print("Digite el nivel de dificultad (1-5): ");
      dificultad = sc.nextInt();
      System.out.print("Digite el número que usted cree que la computadora eligio (1-" + dificultad + "): ");
      jugador = sc.nextInt();

      computadora = (int) (Math.random()*dificultad)+1;

      System.out.print("Dificultad: " + dificultad + "\nNúmero generado: " + computadora + "\nNúmero ingresado: " + jugador + "\nGanador: ");
      if (jugador == computadora) {
	 System.out.print("Jugador");
      } else {
	 System.out.print("Computadora");
      }
   }
}
