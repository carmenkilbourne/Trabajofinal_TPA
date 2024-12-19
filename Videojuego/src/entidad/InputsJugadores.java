package entidad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Clase InputsJugadores que recoge los inputs(teclas presionadas) de los
 * jugadores implementa el KeyListener y asigna a los jugadores una acción
 * vinculada a la tecla presionada. Esta clase sigue el patrón de diseño
 * Observer debido al KeyListener y se queda esperando a recibir inputs del
 * exterior.
 */
public class InputsJugadores implements KeyListener {

	/**
	 * Enum de Accion donde se recogen las accion posibles realizadas por un
	 * jugador.
	 */
	public enum Accion {
		DERECHA, IZQUIERDA, ARRIBA, ABAJO, ATAQUE, DEFENSA, PATADA, NINGUNO
	}

	/**
	 * Inicializacion de ambos jugadores a ninguna por no estar realizando ninguna
	 * accion.
	 * 
	 */
	private Accion accionJugador1 = Accion.NINGUNO;
	private Accion accionJugador2 = Accion.NINGUNO;

	/**
	 * Funcion que recoge los imputs de los usuarios y los asigna a su determinada
	 * accion
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		switch (code) {
		// Controles del Jugador 1
		case KeyEvent.VK_A -> accionJugador1 = Accion.IZQUIERDA;
		case KeyEvent.VK_D -> accionJugador1 = Accion.DERECHA;
		case KeyEvent.VK_W -> accionJugador1 = Accion.ARRIBA;
		case KeyEvent.VK_S -> accionJugador1 = Accion.ABAJO;
		case KeyEvent.VK_Q -> accionJugador1 = Accion.ATAQUE;
		case KeyEvent.VK_E -> accionJugador1 = Accion.DEFENSA;
		case KeyEvent.VK_Z -> accionJugador1 = Accion.PATADA;

		// Controles del Jugador 2
		case KeyEvent.VK_J -> accionJugador2 = Accion.IZQUIERDA;
		case KeyEvent.VK_L -> accionJugador2 = Accion.DERECHA;
		case KeyEvent.VK_I -> accionJugador2 = Accion.ARRIBA;
		case KeyEvent.VK_K -> accionJugador2 = Accion.ABAJO;
		case KeyEvent.VK_O -> accionJugador2 = Accion.ATAQUE;
		case KeyEvent.VK_U -> accionJugador2 = Accion.DEFENSA;
		case KeyEvent.VK_M -> accionJugador2 = Accion.PATADA;
		}
	}

	/**
	 * Metodo para que cuando no se este realizando ninguna accion cuando se deja de
	 * presionar el personaje vuelva a un estado de no estar realizando ninguna
	 * accion
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		switch (code) {
		// Controles del Jugador 1
		case KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_Q, KeyEvent.VK_E, KeyEvent.VK_Z ->
			accionJugador1 = Accion.NINGUNO;

		// Controles del Jugador 2
		case KeyEvent.VK_J, KeyEvent.VK_L, KeyEvent.VK_I, KeyEvent.VK_K, KeyEvent.VK_O, KeyEvent.VK_U, KeyEvent.VK_M ->
			accionJugador2 = Accion.NINGUNO;
		}
	}

	/**
	 * El metodo getAccionJugador1 devuelve la última acción realizada por el
	 * jugador 1.
	 * 
	 * @return la última acción del jugador 1
	 */

	public Accion getAccionJugador1() {
		return accionJugador1;
	}

	/**
	 * El metodo getAccionJugador2 devuelve la última acción realizada por el
	 * jugador 2.
	 * 
	 * @return la última acción del jugador 2
	 */
	public Accion getAccionJugador2() {
		return accionJugador2;
	}

	/**
	 * Metodo keyTyped no usado pero se tiene que poner ya que es parte del
	 * KeyListener
	 */

	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * Metodo para resetear el jugador 1 como jugador que no esta realizando ninguna
	 * acción.
	 */
	public void resetAccionJugador1() {
		// Restablece la acción del jugador 1 a un estado predeterminado, como 'NINGUNA'
		this.accionJugador1 = Accion.NINGUNO;
	}

	/**
	 * Metodo para resetear el jugador 2 como jugador que no esta realizando ninguna
	 * acción
	 */
	public void resetAccionJugador2() {
		// Restablece la acción del jugador 2 a un estado predeterminado, como 'NINGUNA'
		this.accionJugador2 = Accion.NINGUNO;
	}
}
