sBase = float(input("Digite su sueldo base: "))
venta1 = float(input("Digite el valor de su primera venta: "))
venta2 = float(input("Digite el valor de su segunda venta: "))

comisiones = (venta1 + venta2)*0.15
sFinal = sBase + comisiones

print("Su ganancia en comisiones es de", comisiones)
print("Su ganancia total es de", sFinal)
