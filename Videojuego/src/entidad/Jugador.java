package entidad;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import pantallaInicio.MovimientoJugador;
import pantallaInicio.Partida;

public class Jugador extends Entity {
	Partida p;
	MovimientoJugador movimientojugador;
	private int saludMax = 100;
	private int saludActual = saludMax;
	private int ataque = 10; // Valor de ataque del jugador
	private boolean defendiendo = false;

	public Jugador(Partida p,MovimientoJugador movimientojugador) 	{
		this.p = p;
		this.movimientojugador = movimientojugador;
		setVariables();
		getImagenJugador();
	}
	public void setVariables() {
		x=100;
		y=100;
		desplazamiento = 10;
		direccion = "arriba";
	}
	public void getImagenJugador() {
		try {
			salto1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/frente.png"));
			derecha1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/derecha.png"));
			izquierda1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/izquierda.png"));
		    abajo1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/abajo.png"));


			//completar con mas lados
		}catch(IOException e) {
			e.printStackTrace();			
		}
	}
	public void update() {
		if (movimientojugador.derecha == true) {
			direccion = "derecha";
			x = x + desplazamiento;
			if(x>1280-200) {	//limite de fram 1280-200
				x=1280-200;
			}
		}
		if (movimientojugador.izquierda == true) {
			direccion = "izquierda";
			x = x - desplazamiento;
			if(x<0) {
				x=0;
			}
		}
		if (movimientojugador.arriba == true) {
			direccion = "arriba";
			y = y - desplazamiento;
		}
		if (movimientojugador.abajo == true) {
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
		// Dibuja la barra de salud encima del jugador
		int anchoBarra = 100;
	    int alturaBarra = 10;
	    int barraSalud = (int) ((double) saludActual / saludMax * anchoBarra);

	    g1.setColor(Color.RED);
	    g1.fillRect(x, y - 15, anchoBarra, alturaBarra); // Fondo rojo para la barra
	    g1.setColor(Color.GREEN);
	    g1.fillRect(x, y - 15, barraSalud, alturaBarra); // Barra verde proporcional a la salud actual
	}
    public void recibirDanio(int cantidad) {
    	if (defendiendo) {
            cantidad = 0; // reduce el daño a la mitad si está defendiendo
        }
    	saludActual -= cantidad;
        if (saludActual < 0) saludActual = 0;
        System.out.println("Jugador1  ha recibido daño, vida restante: " + saludActual);
    }

    public int getAtaque() {
        return ataque;
    }

    public int getSaludActual() {
        return saludActual;
    }
    public void setDefendiendo(boolean defendiendo) {
        this.defendiendo = defendiendo;
    }
    public boolean estaEnRango(Jugador defensor, int rango) {
        int distanciaX = Math.abs(this.x - defensor.x);
        int distanciaY = Math.abs(this.y - defensor.y);
        double distancia = Math.sqrt(distanciaX * distanciaX + distanciaY * distanciaY);
        return distancia <= rango;
    }
    public void atacar(Jugador defensor) {
        if (estaEnRango(defensor, 50)) { // Usa 50 como distancia de ejemplo
            defensor.recibirDanio(this.ataque);
            System.out.println("Ataque realizado! Vida del defensor: " + defensor.getSaludActual());
        } else {
            System.out.println("El defensor está fuera de rango.");
        }
    }

}
