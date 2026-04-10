const cadena = '{"nombre":"Pedro","edad":20}';
const obj = JSON.parse(cadena);
obj.edad = 25;
const actualizado = JSON.stringify(obj);
console.log(actualizado);
