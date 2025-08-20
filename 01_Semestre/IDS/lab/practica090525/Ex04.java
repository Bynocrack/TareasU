import java.util.Scanner;

public class Ex04{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		char talla, genero, origen;
		float pBase, descuento, pFinal;
		int pDescuento;

		pDescuento = 0;

		System.out.print("Digite su talla (M/L): ");
		talla = Character.toUpperCase(sc.next().charAt(0));
		System.out.print("Digite su género (hombre/mujer // h/m): ");
		genero = Character.toUpperCase(sc.next().charAt(0));
		System.out.print("Es importado? (s/n): ");
		origen = Character.toUpperCase(sc.next().charAt(0));
		System.out.print("Digite el costo original: ");
		pBase = sc.nextFloat();

		if (talla == 'M') {
			if (origen == 'S' && genero == 'M') {
				pDescuento = 7;
			} else {
				pDescuento = 12;
			}
		} if (talla == 'L') {
			if (origen == 'S') {
				if (genero == 'H') {
					pDescuento = 15;
				} if (genero == 'M') {
					pDescuento = 8;
				}
			} if (origen == 'N') {
				if (genero == 'H') {
					pDescuento = 6;
				} if (genero == 'M') {
					pDescuento = 17;
				}	
			}
		} if ((talla != 'L' && talla != 'M' ) || (origen != 'S' && origen != 'N') || (genero != 'M' && genero != 'H')) {
			System.out.println("Alguno de los datos ingresado es incorrecto!!");
			System.out.print("Fijese bien en las opciones.");
			pDescuento = 0;
		}

		descuento = pBase*pDescuento/100;
		pFinal = pBase - descuento;

		System.out.println("El monto comprado es: " + pBase);
		System.out.println("El descuento es: " + descuento);
		System.out.println("El monto a pagar es: " + pFinal);
	}
}
