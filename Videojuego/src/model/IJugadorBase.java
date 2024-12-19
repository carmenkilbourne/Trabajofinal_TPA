package model;

/**
 * Interfaz de Jugador que es la clase base que luego se va a extender para crear las clases jugador 1 y 2.
 */
public interface IJugadorBase {

	/**
	 * Metodo para recibir una cantidad de daño dependiendo de si se esta
	 * defendiendo o no.
	 * 
	 * @param cantidadDanio es la cantidad de daño que va a recibir un jugador
	 *                      dependiendo del tipo que sea.
	 */
	void recibirDanio(int cantidadDanio);

	/**
	 * Metodo que devuelve el impacto sobre la vida de otro jugador.
	 * 
	 * @return ataque es la cantidad de daño que provoca el jugador
	 */
	int getAtaque();

	/**
	 * Metodo para quitar vida a otro jugador.
	 * 
	 * @param enemigo para implementar su método recibir daño
	 */
	void atacar(IJugadorBase enemigo);

	/**
	 * Devuelve la cantidad de vida que tiene el jugador en cada momento.
	 * 
	 * @return cantidad de vida que tiene el jugador.
	 */
	int getSaludActual();

	/**
	 * Devuelve la posicion del jugador en el eje X.
	 * 
	 * @return posición en el eje X
	 */
	int getX();

	/**
	 * Metodo que devuelve la posicion en el eje Y del jugador.
	 * 
	 * @return posición en el eje Y
	 */
	int getY();

	/**
	 * Metodo para establecer la salud máxima.
	 * 
	 * @param saludMax es la salud máxima
	 */
	void setSaludMaxima(int saludMax);

	/**
	 * Metodo que devuelve la altura del jugador.
	 * 
	 * @return alturaJugador
	 */
	int getAlturaJugador();

	/**
	 * Método que establece la altura del jugador.
	 * 
	 * @param alturaJugador
	 */
	void setAlturaJugador(int alturaJugador);

	/**
	 * Método que devuelve el ancho del jugador.
	 * 
	 * @return ancho de jugador.
	 */
	int getAnchuraJugador();

	/**
	 * Método que establece la anchura del jugador
	 * 
	 * @param anchuraJugador
	 */
	void setAnchuraJugador(int anchuraJugador);

	/**
	 * Método que devuelve el máximo nivel de vida del jugador.
	 * 
	 * @return salud máxima del jugador.
	 */
	int getSaludMaxima();

	/**
	 * Método que establece si se esta defendiendo.
	 * 
	 * @param defendiendo es boolean que sera true si el jugador se defiende y false
	 *                    si deja de hacerlo.
	 */
	void setDefendiendo(boolean defendiendo);

}