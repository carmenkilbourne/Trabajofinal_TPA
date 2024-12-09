package entidad;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import pantallas.CargarImagenes;

/*
 * Clase CargarImagenesPersonaje
 * Funcion: carga imagenes de un determinado Personaje
 * Devolver un array de imagenes en la direccion del personaje*/
public class CargarImagenesPersonaje {
	private String personaje; // tipo de personaje
	private String direccion; // a que direccion apunta mi personaje
	Image imagen[]; // graficos para cada direccion
	public BufferedImage salto, derecha, izquierda, abajo1, ataque1, ataque12, pow, patada1, patada2, patada1i,
			patada2i, ataque1i, ataque2i;

	public CargarImagenesPersonaje(String tipo) {
		if(tipo == "ogro") {
			CargarImagenesOgro();
		}
		
	}

	public void CargarImagenesOgro() {
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
			e.printStackTrace();
		}
	}

	public BufferedImage getImagenOgro(String direccion) {
		if (direccion == "salto") {
			return salto;
		} else if (direccion == "derecha") {
			return derecha;
		} else if (direccion == "derecha") {
			return derecha;
		} else if (direccion == "izquierda") {
			return izquierda;
		} else if (direccion == "abajo1") {
			return abajo1;
		} else if (direccion == "ataque1") {
			return ataque1;
		} else if (direccion == "ataque12") {
			return ataque12;
		} else if (direccion == "patada1") {
			return patada1;
		} else if (direccion == "ataque12") {
			return ataque12;
		} else if (direccion == "patada1") {
			return patada1;
		}else if (direccion == "patada2") {
			return patada2;
		}else if (direccion == "patada1i") {
			return patada1i;
		}else if (direccion == "patada2i") {
			return patada2i;
		}else if (direccion == "ataque1i") {
			return ataque1i;
		}else if (direccion == "ataque2i") {
			return ataque2i;
		}
		return abajo1;
	}
}
