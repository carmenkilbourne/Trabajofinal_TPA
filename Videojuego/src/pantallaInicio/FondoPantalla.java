package pantallaInicio;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

public class FondoPantalla extends JPanel{
	private Image image;
	// Constructor que carga la imagen usando un path al recurso
	public FondoPantalla(String imagePath) {
		try {
			// Cargamos la imagen desde fichero
			image = ImageIO.read(getClass().getResource(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error loading image from: " + imagePath);
		}
	}
	// Sobrescribimos paintComponent para dibujar la imagen
@Override
protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	if (image != null) {
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
}
