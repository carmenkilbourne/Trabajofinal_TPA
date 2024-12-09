package pantallas;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CargarImagenes extends JPanel{
	/**
	 * Clase que va a cargar un grafico desde un path o direccion  y lo va ha dibujar con las medidas 
	 */
	private static final long serialVersionUID = 1L;
	private Image grafico;	//Imagen que se va a mostrar
	public CargarImagenes(String path){
		try {
			grafico = ImageIO.read(getClass().getResourceAsStream(path)); 
		} catch (IOException e) {
			System.err.println("No se pudo cargar el grafico: " + e.getMessage());
		}
	}
	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        if (grafico != null) {
	            g.drawImage(grafico, 0, 0, getWidth(), getHeight(), this);
	        }
	    }
	 public Image getGrafico() {	//metodo que va a devolver una imagen(grafico)
		 return grafico;
	}

}
