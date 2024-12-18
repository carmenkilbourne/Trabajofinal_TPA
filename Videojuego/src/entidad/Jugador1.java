package entidad;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import pantallas.Partida;

/**
 *Clase que extiende la clase base e implementa la interfaz IJugador 
 *se le va a pasar la partida y va a dibujar y e implementar la logica del movimiento del
 *jugador 
 */
public class Jugador1 extends Jugador implements IJugador {
	Partida partida;
	InputsJugadores inputs;
	private CargarImagenesPersonaje imagenesPersonaje;
	private MovimientoJugador movimientoJugador1;
	private BarraSalud barraSalud;

	/**Constructor de la clase Jugador1 a la que se le pasa lo necesario para incluir logica de
	 * movimiento y cargar la imagen necesaria
	 * @param partida
	 * @param inputs
	 * @param tipoPersonaje
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
		movimientoJugador1 = new MovimientoJugador(inputs, 0, 320,"derecha");
	    movimientoJugador1.setDesplazamiento(stats.getDesplazamiento());

		imagenesPersonaje = new CargarImagenesPersonaje(tipoPersonaje);
		saludActual = saludMax;
		barraSalud = new BarraSalud(saludMax, 10, 50);
	}

	@Override
	public void update() {
		movimientoJugador1.update(partida.getPanelWidth(), partida.getPanelHeight(),true);
		x = movimientoJugador1.getX();
		y = movimientoJugador1.getY();
		direccion = movimientoJugador1.getDireccion();

	}

	@Override
	public void draw(Graphics2D g1) {
		BufferedImage image = null;
		image = imagenesPersonaje.getImagen(direccion);
		g1.drawImage(image, x, y, alturaJugador, anchuraJugador, null);
		barraSalud.dibujar(g1, saludActual);

	}		

	@Override
	public boolean esDerecha() {
		return movimientoJugador1.esDerecha();
	}

	public void setX(int x) {
        movimientoJugador1.setX(x);

	}

	public void setY(int y) {
        movimientoJugador1.setY(y);
	}
}
