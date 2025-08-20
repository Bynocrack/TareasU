Algoritmo Ejercicio02
	// Determinar el importe neto a pagar por un alumno de un instituto cuya cuota tiene un porcentaje de descuento que se establece en la siguiente tabla y está en función
	// al tipo y categoria del colegio
	
	// CATEGORIA    ?  A ?  B ?  C ?
	// NACIONAL    ? 50 ? 40 ? 30 ?
	// PARTICULAR ? 25 ? 29 ? 15 ?
	
	// Entradas:
	// pago base -> pBase
	// categoria -> categoria
	// colegio -> colegio
	
	// Salidas:
	// pago final <- pFinal
	
	Definir pBase, pFinal Como Real
	Definir descuento Como Entero
	Definir categoria, colegio Como Caracter
	Definir dCorrectos Como Logico
	
	dCorrectos = Verdadero
	
	Escribir "Digite su tipo de colegio (Particular/Nacional):"
	Leer colegio
	Escribir "Digite su categoria (A/B/C):"
	Leer categoria
	Escribir "Digite su pago base:"
	Leer pBase
	
	Si categoria = "A" Entonces
		descuento = 50
	SiNo
		Si categoria = "B" Entonces
			descuento = 40
		SiNo
			Si categoria = "C" Entonces
				descuento = 30
			SiNo
				Escribir 'Ha digitado mal la categoria. ', categoria, ' no es válido, porfavor lea bien las instrucciones'
				dCorrectos = Falso
			FinSi
		FinSi
	FinSi
	
	Si colegio = 'Particular' Entonces
		descuento = descuento/2
	SiNo
		Si colegio <> 'Nacional' Entonces
			Escribir 'Ha digitado mal el tipo de colegio. ', colegio, ' no es válido, porfavor lea bien las instrucciones'
			dCorrectos = Falso
		FinSi
	FinSi
	
	Si colegio = 'Particular' y categoria = 'B' Entonces
		descuento = 29
	FinSi
	
	Si dCorrectos Entonces
		pFinal = pBase*(1-descuento/100)
		
		Escribir 'El pago correspondiente a la categoria ', categoria, ' y al tipo de colegio ', colegio, ' con un pago base de ', pBase, ' es de ', pFinal
	FinSi
FinAlgoritmo
