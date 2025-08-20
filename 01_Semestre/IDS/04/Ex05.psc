Algoritmo Ex05
	Definir m1, m2, m5, total, aux Como Entero
	
	Escribir "Digite una cantidad de soles:"
	Leer total
	
	aux = total%5
	m5 = (total-aux)/5
	total = aux
	aux = total%2
	m2 = (total-aux)/2
	m1 = aux
	
	Escribir "Ese dinero se puede representar como:"
	Escribir " - ", m5, " monedas de 5 soles"
	Escribir " - ", m2, " monedas de 2 soles y "
	Escribir " - ", m1, " monedas de 1 sol."
FinAlgoritmo
