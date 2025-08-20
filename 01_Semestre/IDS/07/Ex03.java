import javax.swing.*;

public class Ex03 {
   public static void main (String[] args) {
      String nombre, ap1, ap2, mono;

      nombre = JOptionPane.showInputDialog(null, "Digite su nombre");
      ap1 = JOptionPane.showInputDialog(null, "Digite su primer apellido");
      ap2 = JOptionPane.showInputDialog(null, "Digite su segundo apellido");

      mono = nombre.substring(0, 1) + ap1.substring(0, 1) + ap2.substring(0, 1);

      JOptionPane.showMessageDialog(null, "El monograma resultante es " + mono);
   }
}
