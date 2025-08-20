import java.util.*;

import java.util.*;
public class Ex06 {
   public static void mostrarTablero(String[][] elTablero){
      System.out.println(elTablero[2][0]+ " | " + elTablero[2][1]+ " | "+ elTablero[2][2]);
      System.out.println("____________");
      System.out.println(elTablero[1][0]+ " | " + elTablero[1][1]+ " | "+ elTablero[1][2]);
      System.out.println("____________");
      System.out.println(elTablero[0][0]+ " | " + elTablero[0][1]+ " | "+ elTablero[0][2]);
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
   public static boolean esJugadaGanadora(String[][] elTablero, String laLetra){
      boolean gano = false;
      for (int i = 0; i < 3; i++) {
	 int conteoh = 0;
	 int conteov = 0;
	 for (int j = 0; j < 3; j++) {
	    if (elTablero[i][j].equals(laLetra)) { conteoh++; }
	    if (elTablero[j][i].equals(laLetra)) { conteov++; }
	 }
	 if (conteoh == 3 || conteov == 3) { gano = true; }
      }
      gano = gano || (elTablero[1][1].equals(laLetra) && ((elTablero[0][0].equals(laLetra) &&
		  elTablero[2][2].equals(laLetra)) || (elTablero[2][0].equals(laLetra) &&
		  elTablero[0][2].equals(laLetra))));
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
   public static void main(String [] args){
      String miLetra;
      int jugada;
      String[][] tablero = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
      miLetra = ingreseLetra();
      int contador = 1;
      mostrarTablero(tablero);
      while(contador <= 9){
	 System.out.println("\n");
	 jugada = ingreseJugada()-1;
	 while (!tablero[jugada/3][jugada%3].equals(" ")){
	    jugada = ingreseJugada();
	 }
	 tablero[jugada/3][jugada%3] = miLetra;
	 mostrarTablero(tablero);
	 if (esJugadaGanadora(tablero, miLetra)){
	    System.out.println("GANO " + miLetra);
	    break;
	 }
	 if(miLetra.equals("X"))
	    miLetra = "O";
	 else
	    miLetra = "X";
	 contador++;
      }
      System.out.println("TERMINAMOS!!!!");
   }
}
