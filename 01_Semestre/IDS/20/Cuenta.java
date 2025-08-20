public class Cuenta {
   private String nombre;
   private double saldo = 0;
   private boolean esPremium = false;

   public Cuenta (String dueño) { nombre = dueño; }
   public void verificar() { esPremium = (saldo >= 50000); }
   public void retirar(double cantidad) {
      saldo -= cantidad;
      verificar();
   }
   public void depositar(double cantidad) {
      saldo += cantidad;
      verificar();
   }
   public void verSaldo() { System.out.println(saldo); }
   public void setNombre(String dueño) { nombre = dueño; }
   public void setSaldo(double cantidad) { saldo = cantidad; }
   public void setEsPremiun(boolean es) { esPremium = es; }
   public double getSaldo() { return saldo; }
   public String getNombre() { return nombre; }
   public boolean getEsPremium() { return esPremium; }
}
