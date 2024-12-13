package entidad;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import pantallas.Partida;

public class Jugador1 extends Jugador implements IJugador {
	Partida p;
	InputsJugadores inputs;
	private int saludMax = 100;
	private CargarImagenesPersonajeFactory personaje;
	private MovimientoJugador movimientoJugador1;
	private BarraSalud barraSalud;

	public Jugador1(Partida p, InputsJugadores inputs, String tipo) {
		this.p = p;
		this.inputs = inputs;
		movimientoJugador1 = new MovimientoJugador(inputs, 0, 320);
		personaje = new CargarImagenesPersonajeFactory(tipo);
		saludActual = saludMax;
		barraSalud = new BarraSalud(saludMax, 10, 50);
	}

	public void update() {
		movimientoJugador1.update(p.getPanelWidth(), p.getPanelHeight());
		x = movimientoJugador1.getX();
		y = movimientoJugador1.getY();
		direccion = movimientoJugador1.getDireccion();

	}

	public void draw(Graphics2D g1) {
		BufferedImage image = null;
		image = personaje.getImagen(direccion);
		g1.drawImage(image, x, y, alturaJugador, anchuraJugador, null);
		barraSalud.dibujar(g1, saludActual);

	}

	@Override
	public int getSaludActual() {
		return saludActual;
	}

	public int getSaludMaxima() {
		return saludMax;
	}

	public void setDefendiendo(boolean defendiendo) {
		this.defendiendo = defendiendo;
	}

}
