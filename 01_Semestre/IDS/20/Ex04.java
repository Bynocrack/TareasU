public class Ex04 {
    public static void main(String[] args) {
        Hora h = new Hora(3, 15, 25);

        System.out.print("Hora inicial: ");
        h.mostrarHora();

        h.setUnaHora(23, 59, 58);
        System.out.print("Hora modificada: ");
        h.mostrarHora();

        h.aumentarSegundo();  
        h.mostrarHora();

        h.aumentarSegundo();  
        h.mostrarHora();

        h.aumentarHora();    
        h.mostrarHora();
    }
}

