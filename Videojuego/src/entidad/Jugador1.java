package entidad;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import pantallas.Partida;

public class Jugador1 extends Jugador implements IJugador {
	Partida p;
	InputsJugadores inputs;
	private CargarImagenesPersonaje personaje;
	private MovimientoJugador movimientoJugador1;
	private BarraSalud barraSalud;

	public Jugador1(Partida p, InputsJugadores inputs, String tipo) {
		this.p = p;
		this.inputs = inputs;
		   // Obtener estadísticas desde el factory
	    ParametrosJugadores stats = ParametrosJugadoresFactory.getStats(tipo);
	    this.saludMax = stats.getSaludMax();
	    this.ataque = stats.getAtaque();
	    this.alturaJugador = stats.getAlturaJugador();
	    this.anchuraJugador = stats.getAnchuraJugador();
	    saludActual = saludMax;
		movimientoJugador1 = new MovimientoJugador(inputs, 0, 320,"derecha");
	    movimientoJugador1.setDesplazamiento(stats.getDesplazamiento());

		personaje = new CargarImagenesPersonaje(tipo);
		saludActual = saludMax;
		barraSalud = new BarraSalud(saludMax, 10, 50);
	}

	@Override
	public void update() {
		movimientoJugador1.update(p.getPanelWidth(), p.getPanelHeight(),true);
		x = movimientoJugador1.getX();
		y = movimientoJugador1.getY();
		direccion = movimientoJugador1.getDireccion();

	}

	@Override
	public void draw(Graphics2D g1) {
		BufferedImage image = null;
		image = personaje.getImagen(direccion);
		g1.drawImage(image, x, y, alturaJugador, anchuraJugador, null);
		barraSalud.dibujar(g1, saludActual);

	}

	@Override
	public int getSaludMaxima() {
		return saludMax;
	}

	@Override
	public void setDefendiendo(boolean defendiendo) {
		this.defendiendo = defendiendo;
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
