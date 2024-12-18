package entidad;

public class ParametrosJugadoresFactory {
    public static ParametrosJugadores getStats(String tipo) {
        switch (tipo.toLowerCase()) {
            case "hada":
                return new ParametrosJugadores(300, 10,200,200,10); // Vida y ataque del hada
            case "gigante":
                return new ParametrosJugadores(300, 20,200,200,5); // Vida y ataque del gigante
            default:
                return new ParametrosJugadores(100, 10,200,200,10); // Valores por defecto
        }
    }
}