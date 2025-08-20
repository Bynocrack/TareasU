public class Estadio {
   private String nombreEstadio;
   private String ciudad;

   public Estadio() { this.ciudad = "Arequipa"; }
   public Estadio(String nombre) {
      this.ciudad = "Arequipa";
      this.nombreEstadio = nombre;
   }
   public void setCiudad(String nombre) { this.ciudad = nombre; }
   public void setNombreEstadio(String nombre) { this.nombreEstadio = nombre; }
   public String getCiudad() { return this.ciudad; }
   public String getNombreEstadio() { return this.nombreEstadio; }
}
