Algoritmo Ejercicio03
	// Determinar la cantidad de dinero que recibirá un trabajador por concepto de las horas extras trabajadas en una empresa, sabiendo que cuando las horas de trabajo exceden de 40,
	// el resto se consideran horas extras y que estas se pagan el doble de una hora normal cuando no exceden de 8; si las horas extras exceden de 8, se pagan las primeras 8 al doble de lo que se pagan 
	// las horas normales y el resto al triple
	
	// Entradas:
	// horas trabajadas -> horas
	// pago por hora -> pHora
	
	// Salidas:
	// pago extra -> extra
	
	Definir extra, pHora, horas Como Real
	
	Escribir "Digite la cantidad de horas que trabajo esta semana:"
	Leer horas
	Escribir "Digite su pago por hora:"
	Leer pHora
	
	extra = 0
	
	Si horas > 40 Entonces
		horas = horas - 40
		extra = 2*horas*pHora
		
		Si horas > 8 Entonces
			horas = horas - 8
			extra = extra + horas*pHora
		FinSi
	FinSi
	
	Escribir "La cantidad extra de dinero que recibirá es ", extra
FinAlgoritmo
