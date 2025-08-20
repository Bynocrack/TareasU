public class Jugador {
   private String nombre;
   private int numeroCamiseta;
   private String posicion;

   //constructor
   public Jugador(){ nombre="anónimo"; }
   public void setNombre(String nom){ nombre = nom; }
   public String getNombre(){ return nombre; }
   public void setNumeroCamiseta(int numero){ numeroCamiseta = numero; }
   public int getNumeroCamiseta(){ return numeroCamiseta; }
   public void setPosicion(String pos){ posicion = pos; }
   public String getPosicion(){ return posicion; }
   public String toString() {
      return "Nombre: " + this.nombre + " | Número: " + this.numeroCamiseta;
   }
}
