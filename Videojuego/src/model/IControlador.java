package model;

import java.awt.event.KeyEvent;

/**
 * Interfaz de la clase Controlador.
 */
public interface IControlador {

	/**
	 * Método para cambiar entre pantallas
	 *  @param nombrePantalla nombre de la pantalla que se va cambiar
	 */
	void cambiarPantalla(String nombrePantalla);

	/**
	 * Método para actualizar la imagen de fondo dado una ruta de imagen.
	 * 
	 * @param nombrePantalla Nombre de la pantalla a mostrar.
	 */
	void actualizarFondo(String nombrePantalla);

	/**
	 * Manejar eventos de teclado pasanso de pantalla inicial a seleccion de
	 * caracteres.
	 * @param e es el evento escuchado por teclado
	 */
	void keyPressed(KeyEvent e);

	/**
	 * Método del KeyListener no implementado
	 * @param e es el evento escuchado por teclado
	 */
	void keyTyped(KeyEvent e);

	/**
	 * Método del KeyListener no implementado
	 * @param e es el evento escuchado por teclado
	 */
	void keyReleased(KeyEvent e);

	/**
	 * Metodo que muestra la pantalla del jugador
	 * 
	 * @param ganador es el nombre del jugador ganador, Jugador1 o Jugador2
	 */
	void mostrarPantallaGanador(String ganador);

}