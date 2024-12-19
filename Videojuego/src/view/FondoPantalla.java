package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 * Clase FondoPantalla devuelve una imagen a partir de la ruta de la imagén.
 */
public class FondoPantalla extends JPanel {
	private static final long serialVersionUID = 1L;
	/**Imagen que se va a cargar
	 */
	private Image imagen;

    /**
     * Constuctor de FondoPantalla crea imagen a partir de la ruta de la imagén.
     * @param path ruta de la imagén.
     */
    public FondoPantalla(String path) {
        imagen = Toolkit.getDefaultToolkit().createImage(getClass().getResource(path));
    }

    /**
     *Pinta la imagén en el  lienzo (JPanel)
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}