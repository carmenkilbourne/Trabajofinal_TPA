package model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import controlador.InputsJugadores;
import view.BarraSalud;
import view.CargarImagenesPersonaje;
import view.IPartida;

/**
 * Clase que extiende la clase base e implementa la interfaz IJugador. Se le va
 * a pasar la partida y va a dibujar y e implementar la logica del movimiento
 * del jugador 2. Implementa el patrón de comportamiento de Strategy ya que el
 * movimiento se controla mediante un objeto llamado Movimiento de jugador.
 * 
 */
public class Jugador2 extends Jugador implements IJugador {
	IPartida p;
	InputsJugadores inputs;
	private CargarImagenesPersonaje personaje;
	private IMovimientoJugador movimientoJugador2;
	private BarraSalud barraSalud;

	/**
	 * Constructor de la clase Jugador2 a la que se le pasa lo necesario para
	 * incluir logica de movimiento y cargar la imagen necesaria
	 * 
	 * @param IPartida       es la partida que tiene mi bucle de partida.
	 * @param inputs        son los inputs del jugador.
	 * @param tipoPersonaje es el tipo de jugador seleccionado.
	 */
	public Jugador2(IPartida p, InputsJugadores inputs, String tipo) {
		this.p = p;
		this.inputs = inputs;
		ParametrosJugadores stats = ParametrosJugadoresFactory.getStats(tipo);
		this.saludMax = stats.getSaludMax();
		this.ataque = stats.getAtaque();
		this.alturaJugador = stats.getAlturaJugador();
		this.anchuraJugador = stats.getAnchuraJugador();
		saludActual = saludMax;
		movimientoJugador2 = new MovimientoJugador(inputs, 1080, 320, "izquierda");
		movimientoJugador2.setDesplazamiento(stats.getDesplazamiento());

		personaje = new CargarImagenesPersonaje(tipo);
		saludActual = saludMax;
		barraSalud = new BarraSalud(saludMax, 1280 - 500 - 30, 50);
	}

	/**
	 * Método que actualiza el movimiento del jugador y las imagenes
	 * correspondientes.
	 */
	public void update() {
		movimientoJugador2.update(p.getPanelWidth(), p.getPanelHeight(), false);
		x = movimientoJugador2.getX();
		y = movimientoJugador2.getY();
		direccion = movimientoJugador2.getDireccion();

	}

	/**
	 * Método para dibujar en la partida el jugador y la barra de salud del jugador.
	 */
	public void draw(Graphics2D g1) {
		BufferedImage image = null;
		image = personaje.getImagen(direccion);
		g1.drawImage(image, x, y, alturaJugador, anchuraJugador, null);
		barraSalud.dibujar(g1, saludActual);

	}

	/**
	 * Método que devuelve si su ultima posicion a sido derecha o izquierda para
	 * luego comprobar si se estan mirando ambos jugadores.
	 */
	public boolean esDerecha() {
		return movimientoJugador2.esDerecha();
	}

	/**
	 * Mueve el jugador a la posicion que le indica en el eje X
	 * 
	 * @param x
	 */
	public void setX(int x) {
		movimientoJugador2.setX(x);
	}

	/**
	 * Método que resetea la salud a la máxima para empezar una nueva ronda.
	 */
	public void resetSalud() {
	    this.saludActual = this.getSaludMaxima(); // Reinicia la salud al máximo		
	}

	/**
	 * Poner al jugador en la posición inicial.
	 */
	public void reiniciarPosicion() {
		movimientoJugador2.setX(1080);
		movimientoJugador2.setY(320);
	}
}