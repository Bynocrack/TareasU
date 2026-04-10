const visor = document.querySelectorAll("div")[0];
const minis = document.querySelectorAll("img");

visor.style.width = "300px";
visor.style.height = "300px";
visor.style.border = "1px solid black";
visor.style.backgroundSize = "cover";

minis.forEach((m) => {
  m.style.width = "80px";
  m.style.cursor = "pointer";
  m.addEventListener("click", () => {
    visor.style.backgroundImage = `url(${m.src})`;
  });
});
