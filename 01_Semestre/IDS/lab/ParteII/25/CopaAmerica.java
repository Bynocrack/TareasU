import java.util.*;

public class CopaAmerica {
   public static void main(String[] args) {
      Estadio estadio1 = new Estadio();
      Estadio estadio2 = new Estadio("Estadio monumental de la UNSA");

      ArrayList<Jugador> equipo = new ArrayList<Jugador>();
      for (int i = 0; i < 11; i++) {
	 equipo.add(new Jugador());
	 equipo.get(i).setNumeroCamiseta(i*3+1);
      }
      equipo.get(0).setNombre("Juan");
      equipo.get(1).setNombre("Pepito");
      equipo.get(2).setNombre("Brayan");
      equipo.get(3).setNombre("Percy");
      equipo.get(4).setNombre("Ronald");
      equipo.get(5).setNombre("Leo");
      equipo.get(6).setNombre("Roy");
      equipo.get(7).setNombre("Randal");
      equipo.get(8).setNombre("Osmeyer");
      equipo.get(9).setNombre("David");
      equipo.get(10).setNombre("Edson");
      for (int i = 0; i < 11; i++) { System.out.println(i+1 + ". " + equipo.get(i)); }
   }
}
