import java.util.*;
public class TresEnRaya {
   public static void mostrarTablero( String [] elTablero){
      System.out.println(elTablero[7]+ " | " + elTablero[8]+ " | "+ elTablero[9]);
      System.out.println("____________");
      System.out.println(elTablero[4]+ " | " + elTablero[5]+ " | "+ elTablero[6]);
      System.out.println("____________");
      System.out.println(elTablero[1]+ " | " + elTablero[2]+ " | "+ elTablero[3]);
   }
   public static String ingreseLetra(){
      String miLetra;
      Scanner sc = new Scanner(System.in);
      System.out.println("Ingrese su letra X o 0");
      miLetra = sc.next();
      while ( ! ( miLetra.equals("X") || miLetra.equals("O") ) ){
	 System.out.println();
	 System.out.println("Ingrese su letra X o 0");
	 miLetra = sc.next();
      }
      return miLetra;
   }
   public static boolean esJugadaGanadora( String [] elTablero, String laLetra){
      boolean gano= false;
      gano = ( elTablero[1].equals(laLetra) && elTablero[2].equals(laLetra) &&
      elTablero[3].equals(laLetra) ) ||
      ( elTablero[4].equals(laLetra) &&
      elTablero[5].equals(laLetra) && elTablero[6].equals(laLetra) ) ||
      ( elTablero[7].equals(laLetra) &&
      elTablero[8].equals(laLetra) && elTablero[9].equals(laLetra) ) ||
      ( elTablero[1].equals(laLetra) &&
      elTablero[4].equals(laLetra) && elTablero[7].equals(laLetra) ) ||
      ( elTablero[2].equals(laLetra) &&
      elTablero[5].equals(laLetra) && elTablero[8].equals(laLetra) ) ||
      ( elTablero[3].equals(laLetra) &&
      elTablero[6].equals(laLetra) && elTablero[9].equals(laLetra) ) ||
      ( elTablero[3].equals(laLetra) &&
      elTablero[5].equals(laLetra) && elTablero[7].equals(laLetra) ) ||
      ( elTablero[1].equals(laLetra) &&
      elTablero[5].equals(laLetra) && elTablero[9].equals(laLetra) ) ;
      return gano;
   }
   public static int ingreseJugada(){
      int jugada;
      Scanner sc = new Scanner(System.in);
      System.out.println("Ingrese jugada 1-9");
      jugada = sc.nextInt();
      while ( jugada> 9 || jugada <1 ) {
	 System.out.println("Ingrese jugada:");
	 jugada = sc.nextInt();
      }
      return jugada;
   }
   public static String[] copiarTablero(String[] tablero) {
      String[] tab = {"", "", "", "", "", "", "", "", "", ""};
      for (int i = 1; i < 10; i++) {
	 tab[i] = tablero[i];
      }
      return tab;
   }
   public static void main(String [] args){
      String miLetra;
      int jugada;
      String [] tablero = {"","","","","","","","","",""};
      miLetra = ingreseLetra();
      String PcLetra;
      if(miLetra.equals("X"))
	 PcLetra = "O";
      else
	 PcLetra = "X";
      int contador = 1;
      while(contador <= 9){
	 mostrarTablero(tablero);
	 System.out.println("\n");
	 jugada = ingreseJugada();
	 while (!tablero[jugada].equals("")){
	    jugada = ingreseJugada();
	 }
	 tablero[jugada] = miLetra;
	 if (esJugadaGanadora(tablero, miLetra)){
	    System.out.println("GANO USTED");
	    break;
	 }
	 contador++;
	 int jugadaElegida = 0;
	 for (int i = 2; i < 10; i += 2) {
	    if (tablero[i].equals("")) {
	       jugadaElegida = i;
	       break;
	    }
	 }
	 for (int i = 1; i < 20; i += 6) {
	    if (tablero[i%10].equals("")) {
	       jugadaElegida = i%10;
	       break;
	    }
	 }
	 if (tablero[5].equals("")) {
	    jugadaElegida = 5;
	 }
	 String [] tableroDePrueba = copiarTablero(tablero);
	 for (int i = 1; i < 10; i++) {
	    if (tableroDePrueba[i].equals("")) {
	       tableroDePrueba[i] = miLetra;
	       if (esJugadaGanadora(tableroDePrueba, miLetra)) {
		  jugadaElegida = i;
		  break;
	       }
	       tableroDePrueba = copiarTablero(tablero);
	    }
	 }
	 tableroDePrueba = copiarTablero(tablero);
	 for (int i = 1; i < 10; i++) {
	    if (tableroDePrueba[i].equals("")) {
	       tableroDePrueba[i] = PcLetra;
	       if (esJugadaGanadora(tableroDePrueba, PcLetra)) {
		  jugadaElegida = i;
		  break;
	       }
	       tableroDePrueba = copiarTablero(tablero);
	    }
	 }
	 tablero[jugadaElegida] = PcLetra;
	 if (esJugadaGanadora(tablero, PcLetra)) {
	    System.out.println("GANO EL COMPUTADOR");
	    break;
	 }
	 contador++;
      }
      mostrarTablero(tablero);
      System.out.println("TERMINAMOS!!!!");
   }
}
