import java.util.Scanner;

public class Ex01 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int jugador, computadora, dificultad, yo = 0, pc = 0, turnos = 0;

      System.out.print("Digite el nivel de dificultad: ");
      dificultad = sc.nextInt();
      while (true) {
	 turnos++;
	 System.out.print("Digite el número que usted cree que la computadora eligio (1-" + dificultad + "): ");
	 jugador = sc.nextInt();

	 computadora = (int) (Math.random()*dificultad)+1;

	 System.out.print("Dificultad: " + dificultad + "\nNúmero generado: " + computadora + "\nNúmero ingresado: " + jugador + "\nGanador: ");
	 if (jugador == computadora) {
	    System.out.println("Jugador");
	    yo++;
	 } else {
	    System.out.println("Computadora");
	    pc++;
	 }
	 System.out.print("Desea seguir jugando? (s/n) ");
	 if (sc.next().toUpperCase().charAt(0) == 'N') { break; }
      }
      System.out.println("Dificultad: " + dificultad + "\nPC: " + pc + "\nJugador: " + yo);
      if (yo > pc) { System.out.print("Ganador: Jugador"); }
      else if (yo < pc) { System.out.print("Ganador: Computadora"); }
      else { System.out.print("Es un empate."); }
   }
}
