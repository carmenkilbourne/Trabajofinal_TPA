package model;

/**
 * Clase para devolver los parametros de cada jugador dependiendo del personaje
 * elegido.
 * 
 */
public class ParametrosJugadores {
	int saludMax;
	int ataque;
	int alturaJugador;
	int desplazamiento;
	int anchuraJugador;

	/**
	 * Constructor de la clase ParametroJugadores que instancia la clase mediante
	 * injección de dependencias
	 * 
	 * @param saludMax salud máxima del jugador
	 * @param ataque   cantidad de daño que provoca su golpe
	 */
	public ParametrosJugadores(int saludMax, int ataque, int alturaJugador, int anchuraJugador, int desplazamiento) {
		this.saludMax = saludMax;
		this.ataque = ataque;
		this.alturaJugador = alturaJugador;
		this.anchuraJugador = anchuraJugador;
		this.desplazamiento = desplazamiento;
	}

	/**
	 * Método que devuelve el máximo nivel de vida del jugador.
	 * 
	 * @return salud máxima del jugador.
	 */
	public int getSaludMax() {
		return saludMax;
	}

	/**
	 * Metodo que devuelve el impacto sobre la vida de otro jugador.
	 * 
	 * @return ataque es la cantidad de daño que provoca el jugador
	 */
	public int getAtaque() {
		return ataque;
	}

	public int getAnchuraJugador() {
		return anchuraJugador;
	}

	/**
	 * Metodo que devuelve la altura del jugador.
	 * 
	 * @return alturaJugador
	 */
	public int getAlturaJugador() {
		return alturaJugador;
	}

	/**
	 * Método que devuelve el ancho del jugador.
	 * 
	 * @return ancho de jugador.
	 */
	public int getDesplazamiento() {
		return desplazamiento;
	}
}