public class Hora {
    private int hora;
    private int minuto;
    private int segundo;
    public Hora(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }
    public void setUnaHora(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }
    public void setHora(int h) { if (h >= 0 && h <= 23) { hora = h; } }
    public void setMinuto(int m) { if (m >= 0 && m <= 59) { minuto = m; } }
    public void setSegundo(int s) { if (s >= 0 && s <= 59) { segundo = s; } }
    public int getHora() { return hora; }
    public int getMinuto() { return minuto; }
    public int getSegundo() { return segundo; }
    public void aumentarSegundo() {
        segundo++;
        if (segundo >= 60) {
            segundo = 0;
            aumentarMinuto();
        }
    }
    public void aumentarMinuto() {
        minuto++;
        if (minuto >= 60) {
            minuto = 0;
            aumentarHora();
        }
    }
    public void aumentarHora() {
        hora++;
        if (hora >= 24) {
            hora = 0;
        }
    }
    public void mostrarHora() { System.out.println(hora + ":" + minuto + ":" + segundo); }
}

