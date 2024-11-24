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
	private int saludMax = 100;//salud inicial del jugador
	private int saludActual = saludMax;
	private int ataque = 10; // Valor de ataque del jugador
	private boolean defendiendo = false;//para saber si se esta defendiendo
	private boolean atacando = false; // Indica si el jugador está atacando.
	private int contadorAtaque = 0; // Controla la duración de la animación del ataque.
	private  int DURACION_ATAQUE = 20; // Duración en frames del ataque.
	private boolean esDerecha = false; //si es false es derecha si es true es izquierda
	
	public Jugador(Partida p,MovimientoJugador movimientojugador) 	{
		this.p = p;
		this.movimientojugador = movimientojugador;
		setVariables();
		getImagenJugador();
	}
	public void setVariables() {
		x=0;
		y=320;
		desplazamiento = 10;
		direccion = "arriba";
	}
	public void getImagenJugador() {
		try {
			salto = ImageIO.read(getClass().getResourceAsStream("/Imagenes/frente.png"));
			derecha = ImageIO.read(getClass().getResourceAsStream("/Imagenes/derecha.png"));
			izquierda = ImageIO.read(getClass().getResourceAsStream("/Imagenes/izquierda.png"));
		    abajo1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/abajo.png"));
		    ataque1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/impactoMano1.png"));
		    ataque12 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/pow2.png"));
		    patada1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/patada1.png"));
		    patada2 =ImageIO.read(getClass().getResourceAsStream("/Imagenes/patadapow.png"));
			//completar con mas lados
		}catch(IOException e) {
			e.printStackTrace();			
		}
	}
	public void update() {
		if (movimientojugador.derecha == true) {
			direccion = "derecha";
			x = x + desplazamiento;
			if(x>1280-200) {	//limite de frame 1280-200
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
			y = y - 100;
			if (y<120) {
				y=120;
			}
		}
		if (movimientojugador.abajo == true) {
			direccion = "abajo";
			y = y + desplazamiento;
			if (y>320) {
				y=320;
			}
		}
		//if (movimientojugador.atacar == true) {
			//direccion = "atacar";
		//}
		 if (movimientojugador.atacar && !atacando) {
		        atacando = true; // Inicia el ataque.
		        contadorAtaque = DURACION_ATAQUE; // Resetea el contador de frames.
		        direccion = "atacar"; // Cambia a la dirección de ataque.
		    }

		    // Manejar el estado de ataque
		    if (atacando) {
		        contadorAtaque--; // Reduce el tiempo del ataque.
		        if (contadorAtaque <= 0) {
		            atacando = false; // Termina el ataque.
		            direccion = "derecha"; // Cambia a una dirección por defecto.
		        }
		    }
		    if (movimientojugador.patada && !atacando) {
		        atacando = true; // Inicia el ataque.
		        contadorAtaque = DURACION_ATAQUE; // Resetea el contador de frames.
		        direccion = "patada"; // Cambia a la dirección de ataque.
		    }

		    // Manejar el estado de ataque
		    if (atacando) {
		        contadorAtaque--; // Reduce el tiempo del ataque.
		        if (contadorAtaque <= 0) {
		            atacando = false; // Termina el ataque.
		            direccion = "derecha"; // Cambia a una dirección por defecto.
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
		case "atacar":
		    if (contadorAtaque > DURACION_ATAQUE / 2) {
		        image = ataque1; // Primer frame del ataque.
		    } else {
		        image = ataque12; // Segundo frame del ataque (impacto).
		    }
			break;
		case "patada":
		    if (contadorAtaque > DURACION_ATAQUE / 2) {
		        image = patada1; // Primer frame del ataque.
		    } else {
		        image = patada2; // Segundo frame del ataque (impacto).
		    }
			break;
		}
		g1.drawImage(image, x, y,alturaJugador,anchuraJugador,null);	//jugador tiene unas medidas de 200x200 pxl
		// Dibuja la barra de salud encima del jugador
		int anchoBarra = 500;
	    int alturaBarra = 30;
	    int barraSalud = (int) ((double) saludActual / saludMax * anchoBarra);

	    g1.setColor(Color.RED);
	    g1.fillRect(10, 50, anchoBarra, alturaBarra); // Fondo rojo para la barra
	    g1.setColor(Color.GREEN);
	    g1.fillRect(10, 50, barraSalud, alturaBarra); // Barra verde 
	}
    public void recibirDanio(int cantidad) {
    	if (defendiendo) {
            cantidad = 0; // reduce el daño a la mitad si está defendiendo
        }
    	saludActual -= cantidad;
        if (saludActual < 0) saludActual = 0;
        System.out.println("Jugador1  ha recibido daño, vida restante: " + saludActual);
        //pasar a un frame con la opcion de si es 1 poner jugador 1 ha ganado 
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
   
}
