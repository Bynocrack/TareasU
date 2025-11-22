const input = document.querySelector("#nombre");
const btn = document.querySelector("#btn");
btn.addEventListener("click", () => {
  const obj = { nombre: input.value };
  const json = JSON.stringify(obj);
  console.log(json);
});
