const cadena = '{"nombre":"Juan","edad":30}';
const obj = JSON.parse(cadena);
document.querySelector("#mostrar").textContent = obj.nombre;
