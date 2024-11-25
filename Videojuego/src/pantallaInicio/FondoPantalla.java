package pantallaInicio;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FondoPantalla extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image imagen;

    public FondoPantalla(String path) {
    	try {
			imagen = ImageIO.read(getClass().getResourceAsStream(path));
			setBounds(0, 0, 1280, 720);
		}catch(IOException e) {
			e.printStackTrace();			
		}catch (NullPointerException e) {
	        System.out.println("La imagen no se encontró: " + path);
	        e.printStackTrace();
	    }
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}