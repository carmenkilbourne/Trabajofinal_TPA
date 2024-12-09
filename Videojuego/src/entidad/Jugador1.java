package entidad;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import pantallas.Partida;

public class Jugador1  extends Entity implements IJugador{
	Partida p;
	MovimientoJugador movimientojugador;
	private int saludMax = 100;// salud inicial del jugador
	private int saludActual = saludMax;
	private int ataque = 10; // Valor de ataque del jugador
	private boolean defendiendo = false;// para saber si se esta defendiendo
	private boolean atacando = false; // Indica si el jugador está atacando.
	private int contadorAtaque = 0; // Controla la duración de la animación del ataque.
	private int DURACION_ATAQUE = 20; // Duración en frames del ataque.
	private boolean esDerecha = false; // si es false es derecha si es true es izquierda
	private boolean saltando = false; // Indica si el jugador está saltando.
	private int velocidadSalto = 10; // Velocidad de subida.
	private int maxAlturaSalto = 100; // Altura máxima que alcanza el salto.
	private int tiempoSalto = 0; // Tiempo que el jugador lleva saltando.
	private CargarImagenesPersonajeFactory personaje;

	public Jugador1(Partida p, MovimientoJugador movimientojugador) {
		this.p = p;
		this.movimientojugador = movimientojugador;
	     personaje = new CargarImagenesPersonajeFactory("ogro");
	     setVariables();
	     personaje.CargarImagenesOgro();
	}

	public void setVariables() {
		x = 0;
		y = 320;
		desplazamiento = 10;//10 pxl como va a ser variable el marco vamos a hacer que cambie	
		direccion = "arriba";
	}



	public void update() {
		int panelHeigh = p.getPanelHeight();
		int panelWidth = p.getPanelWidth();
		if (movimientojugador.derecha == true) {
			direccion = "derecha";
			esDerecha = true;
			x = x + desplazamiento;
			if (x > panelWidth - 200) { // limite de frame 1280-200
				x = panelWidth - 200;
			}
		}
		if (movimientojugador.izquierda == true) {
			direccion = "izquierda";
			esDerecha = false;

			x = x - desplazamiento;
			if (x < 0) {
				x = 0;
			}
		}
		if (movimientojugador.arriba && !saltando) {
			saltando = true;
			tiempoSalto = 0;
		}

		if (saltando) {
			if (tiempoSalto < maxAlturaSalto) {
				y -= velocidadSalto;
				if (y < 120) {
					y = 120;
				}
				tiempoSalto += velocidadSalto;
			} else {
				saltando = false;
			}
		}

		if (y < 320 && !saltando) {
			y += velocidadSalto;
			if (y > 320) {
				y = 320;
			}

		}

		if (movimientojugador.abajo == true) {
			direccion = "abajo";
			y = y + desplazamiento;
			if (y > 320) {
				y = 320;
			}
		}
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
				if (esDerecha) {
					direccion = "derecha"; // Cambia a una dirección por defecto.
				} else {
					direccion = "izquierda";
				}

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
				if (esDerecha) {
					direccion = "derecha";
				} else {
					direccion = "izquierda";
				}
			}
		}
	}

	public void draw(Graphics2D g1) {
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
		g1.fillRect(10, 50, anchoBarra, alturaBarra); // Fondo rojo para la barra
		g1.setColor(Color.GREEN);
		g1.fillRect(10, 50, barraSalud, alturaBarra); // Barra verde
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
	  public void recibirDanio(int cantidad) {
	    	if (defendiendo) {
	            cantidad = 0; // reduce el daño a la mitad si está defendiendo
	        }
	    	saludActual -= cantidad;
	        if (saludActual < 0) saludActual = 0;
	        System.out.println("Jugador1 ha recibido daño, vida restante: " + saludActual);
	    }
	  public boolean esDerecha() {
		  return esDerecha;
	  }

}
