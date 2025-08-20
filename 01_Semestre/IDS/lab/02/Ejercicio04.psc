Algoritmo Ejercicio04
	// Una tienda distribuidora de ropa ha establecido porcentajes de descuento sobre el monto comprado de la siguiente forma:
	
	//    ?           ? Hombres ? Mujeres ?
	//   ? Talla     ? M  ? L  ? M  ? L  ?
	//  ? Nacional  ? 12 ?  6 ? 12 ? 17 ?
	// ? Importado ? 12 ? 15 ?  7 ?  8 ?
	
	// Determinar y mostrar para un comprador, el monto comprado, el importe del descuento y el monto a pagar
	
	// Entradas: 
	// costo inicial -> cBase
	// Talla -> talla
	// Genero -> genero
	// Origen -> importado
	
	// Salidas:
	// monto comprado <- cBase
	// importe del descuento <- descuento
	// monto a pagar <- cFinal
	
	Definir cBase, cFinal, descuento Como Real
	Definir dPorcentaje Como Entero
	Definir talla, genero, importado Como Caracter
	
	Escribir "Digite el precio incial de la prenda:"
	Leer cBase
	Escribir "Digite la talla de la prenda(m/l):"
	Leer talla
	Escribir "Es importado? (s/n):"
	Leer importado
	Escribir "Es para hombre o mujer? (h/m)"
	Leer genero
	
	Si importado <> 's' y importado <> 'n' Entonces
		Escribir importado, "no es válido para importacion, pruebe de nuevo."
	SiNo
		Si genero <> 'h' y genero <> 'm' Entonces
			Escribir genero, "no es válido para el genero, pruebe de nuevo."
		SiNo
			Si talla <> 'm' y talla <> 'l' Entonces
				Escribir talla, "no es válido para la talla, pruebe de nuevo."
			SiNo
				Si talla = 'm' Entonces
					Si importado = 's' y genero = 'm' Entonces
						dPorcentaje = 7
					SiNo
						dPorcentaje = 12
					FinSi
				SiNo
					Si importado = 's' Entonces
						Si genero = 'h' Entonces
							dPorcentaje = 15
						SiNo
							dPorcentaje = 8
						FinSi
					SiNo
						Si genero = 'h' Entonces
							dPorcentaje = 6
						SiNo
							dPorcentaje = 17
						FinSi
					FinSi
				FinSi
				descuento = cBase*dPorcentaje/100
				pFinal = cBase-descuento
				
				Escribir "El monto comprado es ", cBase
				Escribir "El descuento es ", descuento
				Escribir "El monto a pagar es ", pFinal
				
			FinSi
		FinSi
	FinSi
	
	
 	
FinAlgoritmo
