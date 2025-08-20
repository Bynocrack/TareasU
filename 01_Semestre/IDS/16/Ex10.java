import java.util.Scanner;

public class Ex10 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int d11, d12, d21, d22, pc = 0, yo = 0;
      while (true) {
	 d11 = (int) (Math.random()*5+1);
	 d12 = (int) (Math.random()*5+1);
	 d21 = (int) (Math.random()*5+1);
	 d22 = (int) (Math.random()*5+1);

	 if (d11+d12 > d21+d22) { System.out.println("Ganaste esta ronda!"); yo++; }
	 else { System.out.println("Perdiste esta ronda!"); pc++; }
	 System.out.print("Desea seguir jugando? (s/n) ");
	 if (sc.next().toUpperCase().charAt(0) == 'N') { break; }
      }
      System.out.println("Marcador final: \nPC: " + pc + "\nTu: " + yo);
      if (yo > pc) { System.out.print("Ganaste!!"); }
      else if (yo == pc) { System.out.print("Fue un empate!"); }
      else { System.out.print("Perdiste!!"); }
   }
}
