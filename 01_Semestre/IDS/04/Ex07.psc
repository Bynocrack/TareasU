Algoritmo Ex07
	Definir nOriginal, nFinal Como Real
	Definir nEntero, residuo Como entero
	
	Escribir "Digite un número con 4 decimales:"
	Leer nOriginal
	
	nEntero = nOriginal*10000 + 5
	residuo = nEntero%10
	nFinal = (nEntero-residuo)/10000
	
	Escribir "El número redondeado a tres decimales es ", nFinal
FinAlgoritmo
