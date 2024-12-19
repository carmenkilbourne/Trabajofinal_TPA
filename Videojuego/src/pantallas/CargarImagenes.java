package pantallas;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Clase que va a cargar un grafico desde un path o direccion y lo va ha dibujar
 * con las medidas.
 * 
 */
public class CargarImagenes extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image grafico; // Imagen que se va a mostrar

	/**
	 * Constructor que carga una imagén.
	 * 
	 * @param path es donde se encuentra la imagén.
	 */
	public CargarImagenes(String path) {
		try {
			grafico = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			System.err.println("No se pudo cargar el grafico: " + e.getMessage());
		}
	}

	/**
	 * Dibuja la imagén para que ocupe toda la pantalla
	 * 
	 * @param g es un Graphics para dibujar la imagén en el Jpanel.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (grafico != null) {
			g.drawImage(grafico, 0, 0, getWidth(), getHeight(), this);
		}
	}

	/**
	 * Retorna la imagen creada en el constructor.
	 * 
	 * @return imagen
	 */
	public Image getGrafico() { // metodo que va a devolver una imagen(grafico)
		return grafico;
	}

}
