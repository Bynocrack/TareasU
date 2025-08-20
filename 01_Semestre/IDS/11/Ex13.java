import java.util.Scanner;

public class Ex13 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double a, b, c, sRaiz, discriminante;

      System.out.print("Vamos a resolver ecuaciones cuadráticas usando la formula general, consideramos que cualquier ecuación");
      System.out.println(" cuadrática tiene la forma ax²+bx+c");
      System.out.print("Digite el valor de a: ");
      a = sc.nextDouble();
      System.out.print("Digite el valor de b: ");
      b = sc.nextDouble();
      System.out.print("Digite el valor de c: ");
      c = sc.nextDouble();

      discriminante = b*b-4*a*c;
      sRaiz = -b/2*a;
      if (discriminante < 0){
	 System.out.println("Las soluciónes de esta ecuacion pertenecen a los complejos.");
	 discriminante = Math.sqrt(-discriminante)/2*a;
	 System.out.print("Las soluciónes son: " + sRaiz + "+" + discriminante + "i y " + sRaiz + "-" + discriminante + "i");
      } else {
	 System.out.println("Las soluciónes de esta ecuación pertenecen a los reales.");
	 discriminante = Math.sqrt(discriminante)/2*a;
	 System.out.print("Las soluciónes son: " + (sRaiz+discriminante) + " y " + (sRaiz-discriminante));
      }
   }
}
