import java.util.Scanner;
import javax.swing.JOptionPane;

public class Ex05b {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int dificultad, yo = 0, pc = 0, jugador, computadora, seguir;
      String ganador;

      JOptionPane.showMessageDialog(null, "Vamos a jugar un juego!");
      dificultad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la dificultad (1-5)"));
      while (true) {
	 seguir = JOptionPane.showConfirmDialog(null, "Desea seguir jugando?", "Confirmation", JOptionPane.YES_NO_OPTION);
	 if (seguir == JOptionPane.NO_OPTION) break;
	 jugador = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un número entre 1-"+dificultad+" tratando de adivinar el número de la computadora"));
	 computadora = (int) (Math.random()*dificultad)+1;
	 if (computadora == jugador) {
	    yo++;
	    ganador = "Usted ganó esta ronda!";
	 } else {
	    pc++;
	    ganador = "La computadora ganó esta ronda!";
	 }
	 JOptionPane.showMessageDialog(null, "Dificultad: "+dificultad+"\nComputador: "+computadora+"\nJugador: "+jugador+"\n\n"+ganador);
      }

      if (yo > pc) ganador = "Usted ganó el juego!";
      else if (yo < pc) ganador = "La computadora ganó el juego!";
      else ganador = "Es un empate!";

      JOptionPane.showMessageDialog(null, "Computadora: "+pc+"\nUsted: "+yo+"\n\n"+ganador);
      
   }
}
