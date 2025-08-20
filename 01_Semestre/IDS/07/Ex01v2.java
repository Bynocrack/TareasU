import javax.swing.*;

public class Ex01v2 {
   public static void main (String[] args) {
      String nombre, mono;
      nombre = JOptionPane.showInputDialog(null, "Digite su nombre.");

      mono = nombre.substring(0,1) + nombre.substring(nombre.length()-1, nombre.length());
      mono = mono + nombre.indexOf('a');

      JOptionPane.showMessageDialog(null, "El monograma de su nombre es " + mono);
   }
}
