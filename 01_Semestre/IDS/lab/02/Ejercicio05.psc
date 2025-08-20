Algoritmo Ejercicio05
	// Realice un programa que calcule el monto a pagara por el servicio de estacionamiento. La tarifa por una hora es diferente por moto, auto y camioneta. La primera hora de estacionamiento se cobra por una hora normal.
	// Si el transporte es guardado en el estacionamiento por mas de una hora, dichas horas sufren un descuento del 15% respecto al pago por hora normal.
	
	// Entradas:
	// precio por hora -> pHora
	// numero de horas -> horas
	
	// Salidas:
	// monto a pagar -> precio
	Definir pHora, horas, precio Como Real
	
	Escribir "Digite el precio por hora para su vehiculo:"
	Leer pHora
	Escribir "Digite la cantidad de horas que estuvo estacionado:"
	Leer horas
	
	precio = horas*pHora
	
	Si horas > 1 Entonces
		precio = precio-(horas-1)*pHora*0.15
	FinSi
	
	Escribir "El monto a pagar es ", precio
	
FinAlgoritmo
