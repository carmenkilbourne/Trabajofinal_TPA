package entidad;

public class ParametrosJugadoresFactory {
    public static ParametrosJugadores getStats(String tipo) {
        switch (tipo.toLowerCase()) {
            case "hada":
                return new ParametrosJugadores(80, 15); // Vida y ataque del hada
            case "gigante":
                return new ParametrosJugadores(150, 8); // Vida y ataque del gigante
            default:
                return new ParametrosJugadores(100, 10); // Valores por defecto
        }
    }
}