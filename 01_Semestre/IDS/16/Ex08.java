import java.util.Scanner;

public class Ex08 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int nota1, nota2, nota3, nota4, nota5, menor;

      System.out.print("Digite la primera nota: ");
      nota1 = sc.nextInt();
      System.out.print("Digite la segunda nota: ");
      nota2 = sc.nextInt();
      System.out.print("Digite la tercera nota: ");
      nota3 = sc.nextInt();
      System.out.print("Digite la cuarta nota: ");
      nota4 = sc.nextInt();
      System.out.print("Digite la quinta nota: ");
      nota5 = sc.nextInt();

      menor = menor5(nota1, nota2, nota3, nota4, nota5);

      System.out.print("La menor de las 5 es: " + menor);
   }
   public static int menor5 (int a, int b, int c, int d, int e) { return menor3(menor3(a, b, c), d, e); }
   public static int menor3 (int a, int b, int c) {
      if (b < c) {
	 if (a < b) { return a; }
	 return b;
      }
      if (c < a) { return c; }
      return a;
   }
}
