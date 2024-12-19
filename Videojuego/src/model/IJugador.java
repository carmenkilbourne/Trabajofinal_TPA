package model;

import java.awt.Graphics2D;

/**
 * Interfaz de Jugadores 1 y 2
 */
public interface IJugador {

	/**
	 * Método que actualiza el movimiento del jugador y las imagenes
	 * correspondientes.
	 */
	void update();

	/**
	 * Método para dibujar en la partida el jugador y la barra de salud del jugador.
	 */
	void draw(Graphics2D g1);

	/**
	 * Método que devuelve si su ultima posicion a sido derecha o izquierda para
	 * luego comprobar si se estan mirando ambos jugadores.
	 */
	boolean esDerecha();

	/**
	 * Mueve el jugador a la posicion que le indica en el eje X
	 * 
	 * @param x
	 */
	void setX(int x);

	/**
	 * Método que resetea la salud a la máxima para empezar una nueva ronda.
	 */
	void resetSalud();

	/**
	 * Poner al jugador en la posición inicial.
	 */
	void reiniciarPosicion();
}