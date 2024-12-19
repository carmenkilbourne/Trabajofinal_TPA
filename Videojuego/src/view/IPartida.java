package view;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 * Interfaz de la clase Partida.
 */
public interface IPartida {

	void keyPressed(KeyEvent e);

	/**
	 * Método para empezar partida.
	 */
	void empezarPartida();

	/**
	 * Método para terminar partida y si es la ultima ronda se declara el ganador y pasa a la  pantalla del ganador.
	 */
	void terminarPartida();

	/**
	 * Método que devuelve el ganador de la ronda.
	 * @return un string con el ganador.
	 */
	String getGanador();

	/**
	 *Método run que implementa el bucle del juego, actualiza parametros de los jugadores, cronometro y 
	 *pintar la pantalla.
	 */
	void run();

	/**
	 * Método update que actualiza toda la lógica de los jugadores, las interracciones entre ellos
	 * y ver si los jugadores han perdido toda su vida para terminar partida.
	 */
	void update();

	/**
	 *Método paintComponent encargado de pintar los elementos gráficos del juego, como el fondo y los jugadores.
	 */
	void paintComponent(Graphics g);

	/**
	 * Devuelve la altura del panel de la partida.
	 * 
	 * @return La altura del panel.
	 */
	int getPanelHeight();

	/**
	 * Devuelve el ancho del panel de la partida.
	 * 
	 * @return El ancho del panel.
	 */
	int getPanelWidth();

	/**
	 * Verifica si la partida ha terminado.
	 * 
	 * @return true si la partida ha terminado, false en caso contrario.
	 */
	boolean esPartidaTerminada();

	/**
	 *No uso keyTyped ya que estamos implementando la interfaz del Key Listener.
	 */
	void keyTyped(KeyEvent e);

	/**
	 *No uso keyReleased ya que estamos implementando la interfaz del Key Listener.
	 */
	void keyReleased(KeyEvent e);

}