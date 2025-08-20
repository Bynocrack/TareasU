import java.util.*;

public class Ex01 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      ArrayList<String> adn = new ArrayList<String>();
      System.out.print("Ingrese la cadena de ADN: ");
      String cadena = sc.next();
      for (int i = 0; i < cadena.length(); i++) {
	 adn.add(""+cadena.charAt(i));
      }
      System.out.print("Digite la cantidad de mutaciones que desea realizar: ");
      int n = sc.nextInt();
      for (int i = 1; i <= n; i++) {
	 System.out.print("\nHablando de la " + i + " mutación:\nDigite el tipo de mutacion: ");
	 String tipo = sc.next().toLowerCase();
	 System.out.print("Digite el inicio de la mutación: ");
	 int ini = sc.nextInt();
	 System.out.print("Digite el fin de la mutación: ");
	 int fin = sc.nextInt();
	 if (tipo.equals("amp")) { adn = amp(adn, ini, fin); }
	 else if (tipo.equals("del")) { adn = del(adn, ini, fin); }
	 else if (tipo.equals("inv")) { adn = inv(adn, ini, fin); }
	 else {
	    System.out.print("Tipo de mutación no válida, pruebe de nuevo");
	    i--;
	 }
	 for (String gen : adn) { System.out.print(gen); }
      }
   }
   public static ArrayList<String> amp (ArrayList<String> adn, int ini, int fin) {
      for (int i = fin; i >= ini; i--) { adn.add(fin+1, adn.get(i)); }
      return adn;
   }
   public static ArrayList<String> del (ArrayList<String> adn, int ini, int fin) {
      for (int i = fin; i >= ini; i--) { adn.remove(i); }
      return adn;
   }
   public static ArrayList<String> inv (ArrayList<String> adn, int ini, int fin) {
      for (int i = ini; i <= fin; i++) { adn.add(fin+1, adn.get(i)); }
      for (int i = fin; i >= ini; i--) { adn.remove(i); }
      return adn;
   }
}
