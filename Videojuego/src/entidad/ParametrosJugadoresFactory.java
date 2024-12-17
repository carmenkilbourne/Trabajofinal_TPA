package entidad;

public class ParametrosJugadoresFactory {
    public static ParametrosJugadores getStats(String tipo) {
        switch (tipo.toLowerCase()) {
            case "hada":
                return new ParametrosJugadores(80, 15,200,200); // Vida y ataque del hada
            case "gigante":
                return new ParametrosJugadores(150, 8,200,200); // Vida y ataque del gigante
            default:
                return new ParametrosJugadores(100, 10,200,200); // Valores por defecto
        }
    }
}