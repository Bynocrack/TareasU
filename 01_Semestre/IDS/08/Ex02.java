import javax.swing.*;

public class Ex02 {
   public static void main (String[] args) {
      int nBoletos, pBoleto, elegido;
      nBoletos = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de boletos vendidos"));
      pBoleto = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el número del primer boleto"));
      elegido = (int) (Math.random()*nBoletos) + pBoleto;

      JOptionPane.showMessageDialog(null, "El boleto ganador es " + elegido);
   }
}
