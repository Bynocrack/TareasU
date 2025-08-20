Algoritmo Ejercicio10
	Definir nOriginal, nRedondeado Como Real
	Definir exceso como Entero
	
	Escribir "Digite un numero con tres decimales:"
	Leer nOriginal
	
	exceso = (nOriginal*1000)%10
	
	Si exceso >= 5 Entonces
		nRedondeado = nOriginal - exceso/1000 + 0.01
	SiNo
		nRedondeado = nOriginal - exceso/1000
	FinSi

	Escribir "El número redondeado a dos cifras es ", nRedondeado
FinAlgoritmo
