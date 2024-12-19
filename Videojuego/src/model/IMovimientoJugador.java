package model;

public interface IMovimientoJugador {

	/**
	 * @param panelWidth  es el ancho del panel.
	 * @param panelHeight es la altura del panel.
	 * @param esJugador1  es un booleano para saber si estoy tratando con el
	 *                    jugador1(true) o 2(false)
	 */
	void update(int panelWidth, int panelHeight, boolean esJugador1);

	/**
	 * Método que retorna la posicion del jugador en el eje X.
	 * 
	 * @return posicion del jugador en el ejeX.
	 */
	int getX();

	/**
	 * Método que retorna la posicion del jugador en el eje Y.
	 * 
	 * @return posicion del jugador en el eje Y.
	 */
	int getY();

	/**
	 * Método que retorna la dirección del jugador .
	 * 
	 * @return dirección del jugador .
	 */
	String getDireccion();

	/**
	 * @return si su ultima posicion ha sido derecha incluso antes de saltar
	 */
	boolean esDerecha();

	/**
	 * Método que establece la posición del jugador en el eje X.
	 * 
	 * @param x
	 */
	void setX(int x);

	/**
	 * Método que establece la posición del jugador en el eje Y.
	 * 
	 * @param y
	 */
	void setY(int y);

	/**
	 * Devuelve el desplazamiento de cada jugador.
	 * 
	 * @return cantidad que se desplaza cada jugador.
	 */
	int getDesplazamiento();

	/**
	 * Método que establece el desplazamiento.
	 * 
	 * @param desplazamiento
	 */
	void setDesplazamiento(int desplazamiento);

}