public class Alumno {
   private String apellido;
   private String nombre;
   private double promedio;
   
   public void setApellido(String info) { apellido = info; }
   public void setNombre(String info) { nombre = info; }
   public void setPromedio(double info) { promedio = info; }
   public String getApellido() { return apellido; }
   public String getNombre() { return nombre; }
   public double getPromedio() { return promedio; }
   public String toString() { return apellido + ", " + nombre + " = " + promedio; }
}
