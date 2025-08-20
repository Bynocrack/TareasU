import javax.swing.*;

public class Ex03 {
   public static void main (String[] args) {
      int d1, d2, d3, d4, j1, j2;
      JOptionPane.showMessageDialog(null, "El jugador 1 va a jugar!");

      d1 = (int) (Math.random() * 6) + 1;
      d2 = (int) (Math.random() * 6) + 1;

      JOptionPane.showMessageDialog(null, d1 + " y " + d2);
      JOptionPane.showMessageDialog(null, "Ahora le toca al jugador 2!");
      
      d3 = (int) (Math.random() * 6) + 1;
      d4 = (int) (Math.random() * 6) + 1;

      JOptionPane.showMessageDialog(null, d3 + " y " + d4);
      JOptionPane.showMessageDialog(null, "Jugador 1: " +d1+" "+d2+ " = " +(d1+d2)+ "\nJugador 2: " +d3+" "+d4+ " = " +(d3+d4));
   }
}
