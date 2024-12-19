package entidad;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import interfaces.IJugador;
import pantallas.Partida;

/**
 * Clase que extiende la clase base e implementa la interfaz IJugador. Se le va
 * a pasar la partida y va a dibujar y e implementar la logica del movimiento
 * del jugador 1. Implementa el patrón de comportamiento de Strategy ya que el
 * movimiento se controla mediante un objeto llamado Movimiento de jugador.
 * 
 */
public class Jugador1 extends Jugador implements IJugador {
	Partida partida;
	InputsJugadores inputs;
	private CargarImagenesPersonaje imagenesPersonaje;
	private MovimientoJugador movimientoJugador1;
	private BarraSalud barraSalud;

	/**
	 * Constructor de la clase Jugador1 a la que se le pasa lo necesario para
	 * incluir logica de movimiento y cargar la imagen necesaria
	 * 
	 * @param partida       es la partida que tiene mi bucle de partida.
	 * @param inputs        son los inputs del jugador.
	 * @param tipoPersonaje es el tipo de jugador seleccionado.
	 */
	public Jugador1(Partida partida, InputsJugadores inputs, String tipoPersonaje) {
		this.partida = partida;
		this.inputs = inputs;
		// Obtener estadísticas desde el factory
		ParametrosJugadores stats = ParametrosJugadoresFactory.getStats(tipoPersonaje);
		this.saludMax = stats.getSaludMax();
		this.ataque = stats.getAtaque();
		this.alturaJugador = stats.getAlturaJugador();
		this.anchuraJugador = stats.getAnchuraJugador();
		saludActual = saludMax;
		movimientoJugador1 = new MovimientoJugador(inputs, 0, 320, "derecha");
		movimientoJugador1.setDesplazamiento(stats.getDesplazamiento());

		imagenesPersonaje = new CargarImagenesPersonaje(tipoPersonaje);
		saludActual = saludMax;
		barraSalud = new BarraSalud(saludMax, 10, 50);
	}

	/**
	 * Método que actualiza el movimiento del jugador y las imagenes
	 * correspondientes.
	 */
	@Override
	public void update() {
		movimientoJugador1.update(partida.getPanelWidth(), partida.getPanelHeight(), true);
		x = movimientoJugador1.getX();
		y = movimientoJugador1.getY();
		direccion = movimientoJugador1.getDireccion();

	}

	/**
	 * Método para dibujar en la partida el jugador y la barra de salud del jugador.
	 */
	@Override
	public void draw(Graphics2D g1) {
		BufferedImage image = null;
		image = imagenesPersonaje.getImagen(direccion);
		g1.drawImage(image, x, y, alturaJugador, anchuraJugador, null);
		barraSalud.dibujar(g1, saludActual);

	}

	/**
	 * Método que devuelve si su ultima posicion a sido derecha o izquierda para
	 * luego comprobar si se estan mirando ambos jugadores.
	 */
	@Override
	public boolean esDerecha() {
		return movimientoJugador1.esDerecha();
	}

	/**
	 * Mueve el jugador a la posicion que le indica en el eje X
	 * 
	 * @param x
	 */
	@Override
	public void setX(int x) {
		movimientoJugador1.setX(x);

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
		movimientoJugador1.setX(0);
		movimientoJugador1.setY(320);
	}

}
