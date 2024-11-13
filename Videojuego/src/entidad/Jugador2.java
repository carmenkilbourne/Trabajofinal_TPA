package entidad;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import pantallaInicio.MovimientoJugador2;
import pantallaInicio.Partida;

public class Jugador2 extends Entity {
	Partida p;
	MovimientoJugador2 movimientojugador2;
	public Jugador2(Partida p, MovimientoJugador2 movimientojugador2) 	{
		this.p = p;
		this.movimientojugador2 = movimientojugador2;
		setVariables();
		getImagenJugador2();
	}
	public void setVariables() {
		x=100;
		y=100;
		desplazamiento = 10;
		direccion = "arriba";
	}
	public void getImagenJugador2() {
		try {
			salto1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/frente.png"));
			derecha1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/derecha.png"));
			izquierda1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/derecha.png"));
		    abajo1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/abajo.png"));


			//completar con mas lados
		}catch(IOException e) {
			e.printStackTrace();			
		}
	}
	public void update() {
		if (movimientojugador2.derecha == true) {
			direccion = "derecha";
			x = x + desplazamiento;
		}
		if (movimientojugador2.izquierda == true) {
			direccion = "izquierda";
			x = x - desplazamiento;
		}
		if (movimientojugador2.arriba == true) {
			direccion = "arriba";
			y = y - desplazamiento;
		}
		if (movimientojugador2.abajo == true) {
			direccion = "abajo";
			y = y + desplazamiento;
		}
	}
	public void draw(Graphics2D g1) {
		BufferedImage image = null;
		switch(direccion) {
		case "arriba":
			image = salto1;
			break;
		case "abajo":
			image = abajo1;
			break;
		case "derecha":
			image = derecha1;
			break;
		case "izquierda":
			image = izquierda1;
			break;
		}
		g1.drawImage(image, x, y,200,200,null);
	}
}
