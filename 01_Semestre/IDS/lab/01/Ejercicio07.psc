Algoritmo Ejercicio07
	Definir nHombres, nMujeres Como Enteros
	Definir pHombres, pMujeres como reales
	
	Escribir "Digite el número de hombres:"
	Leer nHombres
	Escribir "Digite el número de mujeres:"
	leer nMujeres
	
	pHombres = nHombres*100/(nHombres+nMujeres)
	pMujeres = 100-pHombres
	
	Escribir "El porcentaje de hombres es de ", pHombres, "% y el de mujeres es de ", pMujeres, "%"
FinAlgoritmo
