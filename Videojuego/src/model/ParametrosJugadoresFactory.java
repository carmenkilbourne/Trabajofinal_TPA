package model;

/**
 * Clase ParametrosJugadoresFactory que implemeta el patron de Factory Method+
 * donde crea objetos con determinados parametros
 */
public class ParametrosJugadoresFactory {
	/**
	 * Método que devuelve las stats de cada personaje.
	 * 
	 * @param tipoPersonaje seleccionado.
	 * @return un ParametrosJugadores con las stats del personaje seleccionado.
	 */
	public static ParametrosJugadores getStats(String tipoPersonaje) {
		switch (tipoPersonaje.toLowerCase()) {
		case "hada":
			return new ParametrosJugadores(300, 10, 200, 200, 10); // Vida y ataque del hada
		case "gigante":
			return new ParametrosJugadores(300, 20, 200, 200, 5); // Vida y ataque del gigante
		default:
			return new ParametrosJugadores(100, 10, 200, 200, 10); // Valores por defecto
		}
	}
}