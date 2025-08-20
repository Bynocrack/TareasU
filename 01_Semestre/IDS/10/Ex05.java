import java.util.Scanner;

public class Ex05 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      int lab, teoria;
      double promedio;
      
      System.out.print("Digite su nota de laboratorio: ");
      lab = sc.nextInt();
      System.out.print("Digite su nota de teoría: ");
      teoria = sc.nextInt();

      if (teoria > 10 && lab > 10) {
	 promedio = teoria*0.75 + lab*0.25;
	 System.out.print("Su promedio final es: " + promedio);
      } else {
	 System.out.print("Su nota es desaprobatoria, su nota final es: ");
	 if (teoria > lab) {
	    System.out.print(lab);
	 } else {
	    System.out.print(teoria);
	 }
      }
   }
}
