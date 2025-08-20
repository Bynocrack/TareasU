import java.util.Scanner;

public class Ex01 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int precio, sAncho, sAlto, iAncho, iAlto, fAncho, fAlto;
      
      System.out.print("Digite el precio por metro cuadrado: ");
      precio = sc.nextInt();
      System.out.print("Digite el inicio en altura: ");
      iAlto = sc.nextInt();
      System.out.print("Digite el fin en altura: ");
      fAlto = sc.nextInt();
      System.out.print("Digite el tamaño del salto en altura: ");
      sAlto = sc.nextInt();
      System.out.print("Digite el inicio en ancho: ");
      iAncho = sc.nextInt();
      System.out.print("Digite el fin en ancho: ");
      fAncho = sc.nextInt();
      System.out.print("Digite el tamaño del salto en ancho: ");
      sAncho = sc.nextInt();

      for (int i = iAncho; i <= fAncho; i += sAncho) {
	 System.out.print("\t" + i);
      }
      for (int i = iAlto; i <= fAlto; i += sAlto) {
	 System.out.print("\n" + i);
	 for (int j = iAncho; j <= fAncho; j += sAncho) {
	    System.out.print("\t" + (j*i*precio));
	 }
      }
   }
}
