package entidad;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import pantallas.Partida;

public class Jugador2 extends Jugador implements IJugador {
    Partida p;
    InputsJugadores inputs;
    private int saludMax = 100;
    private int contadorAtaque = 0;
    private int DURACION_ATAQUE = 20;
    private CargarImagenesPersonajeFactory personaje;
    private MovimientoJugador2 movimientoJugador2;

    public Jugador2(Partida p, InputsJugadores inputs) {
        this.p = p;
        this.inputs = inputs;
        setVariables();
        saludActual = saludMax;
        movimientoJugador2 = new MovimientoJugador2(inputs,x,y);
        personaje = new CargarImagenesPersonajeFactory("hada");
        personaje.CargarImagenesHada();
    }

    public void setVariables() {
		direccion = "arriba";
	}

    public void update() {
        int panelWidth = p.getPanelWidth(); 
        int panelHeight = p.getPanelHeight();
        movimientoJugador2.update(panelWidth, panelHeight);
        x = movimientoJugador2.getX();
        y = movimientoJugador2.getY();
        direccion = movimientoJugador2.getDireccion();
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
                if (movimientoJugador2.esDerecha()) {
                    image = contadorAtaque > DURACION_ATAQUE / 2 ? personaje.getImagen("ataque1") : personaje.getImagen("ataque12");
                } else {
                    image = contadorAtaque > DURACION_ATAQUE / 2 ? personaje.getImagen("ataque1i") : personaje.getImagen("ataque2i");
                }
                break;
            case "patada":
                if (movimientoJugador2.esDerecha()) {
                    image = contadorAtaque > DURACION_ATAQUE / 2 ? personaje.getImagen("patada1") : personaje.getImagen("patada2");
                } else {
                    image = contadorAtaque > DURACION_ATAQUE / 2 ? personaje.getImagen("patada1i") : personaje.getImagen("patada2i");
                }
                break;
        }
        g1.drawImage(image, x, y, alturaJugador, anchuraJugador, null);
     // Dibuja la barra de salud encima del jugador
     		int anchoBarra = 500;
     		int alturaBarra = 30;
     		int barraSalud = (int) ((double) saludActual / saludMax * anchoBarra);

     		 g1.setColor(Color.RED);
     		    g1.fillRect(p.getPanelWidth()-anchoBarra-30, 50, anchoBarra, alturaBarra); // Fondo rojo para la barra
     		    g1.setColor(Color.GREEN);
     		    g1.fillRect(p.getPanelWidth()-anchoBarra-30, 50, barraSalud, alturaBarra); // Barra verde 
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
