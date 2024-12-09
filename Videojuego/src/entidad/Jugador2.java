package entidad;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import pantallas.Partida;

public class Jugador2 extends Entity implements IJugador{
	Partida p;
	MovimientoJugador2 movimientojugador2;
	private int saludMax = 100;
	private int saludActual = saludMax;
	private int ataque = 10; // Valor de ataque del jugador
	private boolean defendiendo = false;
	private boolean atacando = false; // Indica si el jugador está atacando.
	private int contadorAtaque = 0; // Controla la duración de la animación del ataque.
	private  int DURACION_ATAQUE = 20; // Duración en frames del ataque.
	private boolean esDerecha = false; //si es false es derecha si es true es izquierda
	public BufferedImage salto,derecha,izquierda,abajo1,ataque1,ataque12,pow,patada1,patada2,patada1i,patada2i,ataque1i,ataque2i;
	private CargarImagenesPersonajeFactory personaje;

	public Jugador2(Partida p, MovimientoJugador2 movimientojugador2) 	{
		this.p = p;
		this.movimientojugador2 = movimientojugador2;
		setVariables();
		//getImagenJugador();
		 personaje = new CargarImagenesPersonajeFactory("hada");
	     setVariables();
	     personaje.CargarImagenesHada();
	}
	public void setVariables() {
		x=1080;
		y=320;
		desplazamiento = 10;
		direccion = "arriba";
	}
	public void getImagenJugador() {	//posibilidad de poner en entity ya que es comun a ambos jugadores
		try {
			salto = ImageIO.read(getClass().getResourceAsStream("/Imagenes/frente.png"));
			derecha = ImageIO.read(getClass().getResourceAsStream("/Imagenes/derecha.png"));
			izquierda = ImageIO.read(getClass().getResourceAsStream("/Imagenes/izquierda.png"));
		    abajo1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/abajo.png"));
		    ataque1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/impactoMano1.png"));
		    ataque12 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/pow2.png"));
		    patada1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/patada1.png"));
		    patada2 =ImageIO.read(getClass().getResourceAsStream("/Imagenes/patadapow.png"));
		    patada1i = ImageIO.read(getClass().getResourceAsStream("/Imagenes/patadaIzquierda.png"));
		    patada2i =ImageIO.read(getClass().getResourceAsStream("/Imagenes/patadapowi.png"));
		    ataque1i = ImageIO.read(getClass().getResourceAsStream("/Imagenes/MovMano1i.png"));
		    ataque2i = ImageIO.read(getClass().getResourceAsStream("/Imagenes/pow2i.png"));
			//completar con mas lados
		}catch(IOException e) {
			e.printStackTrace();			
		}
	}
	public void update() {
		int panelHeigh = p.getPanelHeight();
		int panelWidth = p.getPanelWidth();
		if (movimientojugador2.derecha == true) {
			direccion = "derecha";
			esDerecha = true;
			x = x + desplazamiento;
			if(x>panelWidth-200) {	//limite de fram 1280-200
				x=panelWidth-200;
			}
		}
		if (movimientojugador2.izquierda == true) {
			direccion = "izquierda";
			esDerecha = false;
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
		if (movimientojugador2.atacar && !atacando) {
	        atacando = true; // Inicia el ataque.
	        contadorAtaque = DURACION_ATAQUE; // Resetea el contador de frames.
	        direccion = "atacar"; // Cambia a la dirección de ataque.
	    }

	    // Manejar el estado de ataque
	    if (atacando) {
	        contadorAtaque--; // Reduce el tiempo del ataque.
	        if (contadorAtaque <= 0) {
	            atacando = false; // Termina el ataque.
	            if(esDerecha) {
	            direccion = "derecha"; // Cambia a una dirección por defecto.
	            }
	            else {
	            	direccion = "izquierda";
	            }
	            
	        }
	    }
	    if (movimientojugador2.patada && !atacando) {
	        atacando = true; // Inicia el ataque.
	        contadorAtaque = DURACION_ATAQUE; // Resetea el contador de frames.
	        direccion = "patada"; // Cambia a la dirección de ataque.
	    }

	    // Manejar el estado de ataque
	    if (atacando) {
	        contadorAtaque--; // Reduce el tiempo del ataque.
	        if (contadorAtaque <= 0) {
	            atacando = false; // Termina el ataque.
	            if(esDerecha) {direccion = "derecha"; }
	            else {direccion = "izquierda"; }
	        }
	    }
	}
	public void draw(Graphics2D g1) {
		int panelHeigh = p.getPanelHeight();
		int panelWidth = p.getPanelWidth();
		BufferedImage image = null;
		//image =personaje.getImagen(direccion);
		//image = null;
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
			if (esDerecha) {
				if (contadorAtaque > DURACION_ATAQUE / 2) {
					image = personaje.getImagen("ataque1"); // Primer frame del ataque.
				} else {
					image = personaje.getImagen("ataque12"); // Segundo frame del ataque (impacto).
				}
			} else {
				if (contadorAtaque > DURACION_ATAQUE / 2) {
					image = personaje.getImagen("ataque1i"); // Primer frame del ataque.
				} else {
					image = personaje.getImagen("ataque2i"); // Segundo frame del ataque (impacto).
				}
			}
			break;
		case "patada":
			if (esDerecha) {
				if (contadorAtaque > DURACION_ATAQUE / 2) {
					image = personaje.getImagen("patada1"); // Primer frame del ataque.
				} else {
					image = personaje.getImagen("patada2"); // Segundo frame del ataque (impacto).
				}
			} else {
				if (contadorAtaque > DURACION_ATAQUE / 2) {
					image = personaje.getImagen("patada1i"); // Primer frame del ataque.
				} else {
					image = personaje.getImagen("patada2i"); // Segundo frame del ataque (impacto).
				}
			}
			break;
		}
		g1.drawImage(image, x, y, alturaJugador, anchuraJugador, null); // jugador tiene unas medidas de 200x200 pxl
		// Dibuja la barra de salud encima del jugador
		int anchoBarra = 500;
		int alturaBarra = 30;
		int barraSalud = (int) ((double) saludActual / saludMax * anchoBarra);

		 g1.setColor(Color.RED);
		    g1.fillRect(panelWidth-anchoBarra-30, 50, anchoBarra, alturaBarra); // Fondo rojo para la barra
		    g1.setColor(Color.GREEN);
		    g1.fillRect(panelWidth-anchoBarra-30, 50, barraSalud, alturaBarra); // Barra verde 
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
    public boolean esDerecha() {
		  return esDerecha;
	  }
}
