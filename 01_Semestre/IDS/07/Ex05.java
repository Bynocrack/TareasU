import javax.swing.*;

public class Ex05 {
   public static void main (String[] args) {
      String nCompleto, mono;
      int indice;
      nCompleto = JOptionPane.showInputDialog(null, "Digite su nombre completo (nombre ap1 ap2)");

      indice = nCompleto.indexOf(' ');
      mono = nCompleto.substring(0, 1) + nCompleto.substring(indice+1, indice+2);
      indice = indice + 1 + nCompleto.substring(indice+1, nCompleto.length()).indexOf(' ');
      mono = mono + nCompleto.substring(indice+1, indice+2);

      JOptionPane.showMessageDialog(null, "El monograma resultante es " + mono);
   }
}
