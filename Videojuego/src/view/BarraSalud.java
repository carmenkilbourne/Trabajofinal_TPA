package view;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase diseñada para representar y dibujar una barra de salud en la pantalla,
 * indicando la cantidad de vida actual de un jugador.
 * 
 */
public class BarraSalud implements IBarraSalud {
	private int x, y;
	private int saludMax;

	/**
	 * Constructor de la clase BarraSalud. Instanciar la clase con los parametros
	 * necesarios para dibujar la barra de salud
	 * en pantalla.
	 * 
	 * @param saludMax es la cantidad máxima de salud que representa la barra
	 * @param x        es la posición horizontal en la que se dibuja la barra
	 * @param y        es la posición vertical en la que se dibuja la barra
	 */

	public BarraSalud(int saludMax, int x, int y) {
		this.x = x;
		this.y = y;
		this.saludMax = saludMax;
	}

	/**
	 * Metodo usado para dibujar la barra de salud pero con la salud actual para
	 * cuando el Jugador recibe daño y necesita verse reflejado.
	 * 
	 * @param g           es un Graphics2D(objeto) para dibujar en pantalla
	 * @param saludActual es la salud (cantidad de vida) que tiene el jugador
	 */

	public void dibujar(Graphics2D g, int saludActual) {
		int barraSalud = (int) ((double) saludActual / saludMax * 500);

		// Dibujar la barra de fondo (roja)
		g.setColor(Color.RED);
		g.fillRect(x, y, 500, 20);

		// Dibujar la barra de salud actual (verde)
		g.setColor(Color.GREEN);
		g.fillRect(x, y, barraSalud, 20);
	}
}
