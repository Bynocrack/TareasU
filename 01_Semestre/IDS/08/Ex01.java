import javax.swing.*;

public class Ex01 {
   public static void main (String[] args) {
      int total, elegido;
      String n;

      n = JOptionPane.showInputDialog(null,"Digite la cantidad de estudiantes: ");
      
      total = Integer.parseInt(n);
      elegido = (int) (Math.random()*total) + 1;

      JOptionPane.showMessageDialog(null, "El estudiante elegido (según lista) es: " + elegido);


   }
}
