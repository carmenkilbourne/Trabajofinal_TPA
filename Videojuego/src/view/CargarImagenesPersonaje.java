package view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * Clase CargarImagenesPersonajeFactory que carga todas las imagenes del personaje elegido por los Personajes y 
 * luego devuelve la imagen correspondiente a la direccion seleccionada. 
 * Implementa el patrón de diseño de Factory method.
 */
public class CargarImagenesPersonaje {
	/**
	 * Imagenes de cada direccion que puede tomar un personaje.
	 */
	private BufferedImage salto, derecha, izquierda, abajo1, ataque1, ataque12, patada1, patada2, patada1i, patada2i,
			ataque1i, ataque2i;

	/**
	 * Constructor que carga las imagenes correspondientes a el personaje elegido.
	 * 
	 * @param tipoPersonaje es el tipo de personaje que el jugador a elegido
	 * @throws IllegalArgumentException si el tipo de personaje es distinto a los
	 *                                  permitidos
	 */

	public CargarImagenesPersonaje(String tipoPersonaje) {
		switch (tipoPersonaje.toLowerCase()) {
		case "gigante":
			CargarImagenesGigante();
			break;
		case "hada":
			CargarImagenesHada();
			break;
		default:
			throw new IllegalArgumentException("Tipo de personaje no soportado: " + tipoPersonaje);
		}
	}

	/**
	 * Metodo que devuelve una imagen correspondiente a la direccion solicitada.
	 * 
	 * @param direccion es la direccion en la que se mueve el personaje
	 * @return la imagen asociada a la direccion pedida
	 */

	public BufferedImage getImagen(String direccion) {
		switch (direccion.toLowerCase()) {
		case "salto":
			return salto;
		case "derecha":
			return derecha;
		case "izquierda":
			return izquierda;
		case "abajo1":
			return abajo1;
		case "ataque1":
			return ataque1;
		case "ataque12":
			return ataque12;
		case "patada1":
			return patada1;
		case "patada2":
			return patada2;
		case "patada1i":
			return patada1i;
		case "patada2i":
			return patada2i;
		case "ataque1i":
			return ataque1i;
		case "ataque2i":
			return ataque2i;
		default:
			throw new IllegalArgumentException("Dirección de imagen no encontrada: " + direccion);
		}
	}

	/**
	 * Metodo que carga las imagenes del personaje tipo gigante.
	 */
	public void CargarImagenesGigante() {
		try {
			salto = ImageIO.read(getClass().getResourceAsStream("/Imagenes/frente.png"));
			derecha = ImageIO.read(getClass().getResourceAsStream("/Imagenes/derecha.png"));
			izquierda = ImageIO.read(getClass().getResourceAsStream("/Imagenes/izquierda.png"));
			abajo1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/abajo.png"));
			ataque1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/impactoMano1.png"));
			ataque12 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/pow2.png"));
			patada1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/patada1.png"));
			patada2 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/patadapow.png"));
			patada1i = ImageIO.read(getClass().getResourceAsStream("/Imagenes/patadaIzquierda.png"));
			patada2i = ImageIO.read(getClass().getResourceAsStream("/Imagenes/patadapowi.png"));
			ataque1i = ImageIO.read(getClass().getResourceAsStream("/Imagenes/MovMano1i.png"));
			ataque2i = ImageIO.read(getClass().getResourceAsStream("/Imagenes/pow2i.png"));
		} catch (IOException e) {
			System.err.println("Error cargando imágenes: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que carga las imagenes del personaje tipo hada.
	 */
	public void CargarImagenesHada() {
		try {
			salto = ImageIO.read(getClass().getResourceAsStream("/Imagenes/Hada/frente.png"));
			derecha = ImageIO.read(getClass().getResourceAsStream("/Imagenes/Hada/derecha.png"));
			izquierda = ImageIO.read(getClass().getResourceAsStream("/Imagenes/Hada/izquierda.png"));
			abajo1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/Hada/abajo.png"));
			ataque1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/Hada/punetazoDrcha.png"));
			ataque12 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/Hada/punetazoDrchaPow.png"));
			patada1 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/Hada/patadaDrcha.png"));
			patada2 = ImageIO.read(getClass().getResourceAsStream("/Imagenes/Hada/punetazoDrchaPow.png"));
			patada1i = ImageIO.read(getClass().getResourceAsStream("/Imagenes/Hada/patadaIzq.png"));
			patada2i = ImageIO.read(getClass().getResourceAsStream("/Imagenes/Hada/patadaIzqPow.png"));
			ataque1i = ImageIO.read(getClass().getResourceAsStream("/Imagenes/Hada/punetazoIzq.png"));
			ataque2i = ImageIO.read(getClass().getResourceAsStream("/Imagenes/Hada/punetazoIzqPow.png"));
		} catch (IOException e) {
			System.err.println("Error cargando imágenes: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
