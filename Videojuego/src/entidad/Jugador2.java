package entidad;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import pantallaInicio.MovimientoJugador2;
import pantallaInicio.Partida;

public class Jugador2 extends Entity {
	Partida p;
	MovimientoJugador2 movimientojugador2;
	private int saludMax = 100;
	private int saludActual = saludMax;
	private int ataque = 10; // Valor de ataque del jugador
	private boolean defendiendo = false;

	public Jugador2(Partida p, MovimientoJugador2 movimientojugador2) 	{
		this.p = p;
		this.movimientojugador2 = movimientojugador2;
		setVariables();
		getImagenJugador2();
	}
	public void setVariables() {
		x=1080;
		y=320;
		desplazamiento = 10;
		direccion = "arriba";
	}
	public void getImagenJugador2() {
		try {
			salto = ImageIO.read(getClass().getResourceAsStream("/Imagenes/frente.png"));
			derecha = ImageIO.read(getClass().getResourceAsStream("/Imagenes/derecha.png"));
			izquierda = ImageIO.read(getClass().getResourceAsStream("/Imagenes/izquierda.png"));
		    abajo1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/abajo.png"));
		    ataque1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/impactoMano1.png"));
		    ataque12 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/impactoMano2.png"));
		    

			//completar con mas lados
		}catch(IOException e) {
			e.printStackTrace();			
		}
	}
	public void update() {
		if (movimientojugador2.derecha == true) {
			direccion = "derecha";
			x = x + desplazamiento;
			if(x>1280-200) {	//limite de fram 1280-200
				x=1280-200;
			}
		}
		if (movimientojugador2.izquierda == true) {
			direccion = "izquierda";
			x = x - desplazamiento;
			if(x<0) {
				x=0;
			}
		}
		if (movimientojugador2.arriba == true) {
			direccion = "arriba";
			y = y - 100;
			if (y<120) {
				y=120;
			}
		}
		if (movimientojugador2.abajo == true) {
			direccion = "abajo";
			y = y + desplazamiento;
			if (y>320) {
				y=320;
			}
		}
	}
	public void draw(Graphics2D g1) {
		BufferedImage image = null;
		switch(direccion) {
		case "arriba":
			image = salto;
			break;
		case "abajo":
			image = abajo1;
			break;
		case "derecha":
			image = derecha;
			break;
		case "izquierda":
			image = izquierda;
			break;
		}
		g1.drawImage(image, x, y,200,200,null);
		// Dibuja la barra de salud encima del jugador
		int anchoBarra = 500;
	    int alturaBarra = 30;
	    int barraSalud = (int) ((double) saludActual / saludMax * anchoBarra);

	    g1.setColor(Color.RED);
	    g1.fillRect(1280-anchoBarra-30, 50, anchoBarra, alturaBarra); // Fondo rojo para la barra
	    g1.setColor(Color.GREEN);
	    g1.fillRect(1280-anchoBarra-30, 50, barraSalud, alturaBarra); // Barra verde 
	}
    public void recibirDanio(int cantidad) {
    	if (defendiendo) {
            cantidad = 0; // reduce el daño a la mitad si está defendiendo
        }
    	saludActual -= cantidad;
        if (saludActual < 0) saludActual = 0;
        System.out.println("Jugador2 ha recibido daño, vida restante: " + saludActual);
    }
    public void setDefendiendo(boolean defendiendo) {
        this.defendiendo = defendiendo;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getSaludActual() {
        return saludActual;
    }

}
