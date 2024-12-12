package entidad;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import pantallas.Partida;

public class Jugador1 extends Jugador implements IJugador {
    Partida p;
    InputsJugadores inputs;
    private int saludMax = 100;
    private int contadorAtaque = 0;
    private int DURACION_ATAQUE = 20;
    private CargarImagenesPersonajeFactory personaje;
    private MovimientoJugador movimientoJugador1;

    public Jugador1(Partida p, InputsJugadores inputs) {
        this.p = p;
        this.inputs = inputs;
        movimientoJugador1 = new MovimientoJugador(inputs,x,y);
        personaje = new CargarImagenesPersonajeFactory("ogro");
        setVariables();
        saludActual = saludMax;
        personaje.CargarImagenesOgro();
    }

    public void setVariables() {
        direccion = "arriba";
    }

    public void update() {
        int panelWidth = p.getPanelWidth(); 
        int panelHeight = p.getPanelHeight();
        movimientoJugador1.update(panelWidth, panelHeight);
        x = movimientoJugador1.getX();
        y = movimientoJugador1.getY();
        direccion = movimientoJugador1.getDireccion();
    }

    public void draw(Graphics2D g1) {
        BufferedImage image = null;
        switch (direccion) {
            case "arriba":
                image = personaje.getImagen("salto");
                break;
            case "abajo":
                image = personaje.getImagen("abajo1");
                break;
            case "derecha":
                image = personaje.getImagen("derecha");
                break;
            case "izquierda":
                image = personaje.getImagen("izquierda");
                break;
            case "atacar":
                if (movimientoJugador1.esDerecha()) {
                    image = contadorAtaque > DURACION_ATAQUE / 2 ? personaje.getImagen("ataque1") : personaje.getImagen("ataque12");
                } else {
                    image = contadorAtaque > DURACION_ATAQUE / 2 ? personaje.getImagen("ataque1i") : personaje.getImagen("ataque2i");
                }
                break;
            case "patada":
                if (movimientoJugador1.esDerecha()) {
                    image = contadorAtaque > DURACION_ATAQUE / 2 ? personaje.getImagen("patada1") : personaje.getImagen("patada2");
                } else {
                    image = contadorAtaque > DURACION_ATAQUE / 2 ? personaje.getImagen("patada1i") : personaje.getImagen("patada2i");
                }
                break;
        }
        g1.drawImage(image, x, y, alturaJugador, anchuraJugador, null);
        int barraSalud = (int) ((double) saludActual / saludMax * 500);
        g1.setColor(Color.RED);
        g1.fillRect(10, 50, 500, 20);
        g1.setColor(Color.GREEN);
        g1.fillRect(10, 50, barraSalud, 20);
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
