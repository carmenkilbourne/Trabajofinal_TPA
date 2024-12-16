package entidad;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase diseñada con el solo proposito de dibujar barras de salud en pantalla mostrando 
 * la cantidad de vida restante del jugador
 */
public class BarraSalud {
	private int x, y, ancho, alto;
	private int saludMax;

	/**Constructor de la clase BarraSalud usada para instanciar la clase con los parametros necesarios 
	 * para dibujar la barra de salud en pantalla
	 * @param saludMax
	 * @param x
	 * @param y
	 */
	public BarraSalud(int saludMax, int x, int y) {
		this.x = x;
		this.y = y;
		this.saludMax = saludMax;
	}

	/**
	 * Metodo usado para dibujar la barra de salud pero con la salud actual para cuando el 
	 * Jugador recibe daño y necesita verse reflejado
	 * @param g
	 * @param saludActual
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
