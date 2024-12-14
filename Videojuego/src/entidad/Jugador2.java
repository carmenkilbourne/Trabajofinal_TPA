package entidad;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import pantallas.Partida;

public class Jugador2 extends Jugador implements IJugador {
	Partida p;
	InputsJugadores inputs;
	private int saludMax = 100;
	private CargarImagenesPersonajeFactory personaje;
	private MovimientoJugador2 movimientoJugador2;
	private BarraSalud barraSalud;

	public Jugador2(Partida p, InputsJugadores inputs, String tipo) {
		this.p = p;
		this.inputs = inputs;
		movimientoJugador2 = new MovimientoJugador2(inputs, 1080, 320);
		personaje = new CargarImagenesPersonajeFactory(tipo);
		saludActual = saludMax;
		barraSalud = new BarraSalud(saludMax, 1280-500-30, 50);
	}

	public void update() {
		movimientoJugador2.update(p.getPanelWidth(), p.getPanelHeight());
		x = movimientoJugador2.getX();
		y = movimientoJugador2.getY();
		direccion = movimientoJugador2.getDireccion();

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

	public boolean esDerecha() {
		return movimientoJugador2.esDerecha();
	}
	public void setX(int x) {
        movimientoJugador2.setX(x);
	}
	public void setY(int y) {
        movimientoJugador2.setY(y);
	}
}