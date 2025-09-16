public class Producto {
   // Declaramos las variables
   private String codigo;
   private String nombre;
   private int stock = 0;

   // Constructor de la clase
   public Producto (String cod, String nom) {
      this.codigo = cod;
      this.nombre = nom;
   }

   // Los metodos mutadores
   public void setStock (int n) { this.stock = n; }
   public void setNombre (String nom) { this.nombre = nom; }
   public void setCodigo (String cod) {this.codigo = cod; }

   // Los metodos accesores
   public int getStock () { return this.stock; }
   public String getNombre () { return this.nombre; }
   public String getCodigo () { return this.codigo; }

   // Metedos adicionales para tener control del stock
   public void agregarStock (int n) { this.stock += n; }
   public void retirarStock (int n) { this.stock -= n; }

   // Modificamos la funcion toString()
   @Override
   public String toString() {
      return "Codigo: " + this.codigo + "\tNombre: " + this.nombre + "  \tStock: " + this.stock;
   }
}
