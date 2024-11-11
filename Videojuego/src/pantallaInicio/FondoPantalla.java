package pantallaInicio;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class FondoPantalla extends JPanel {
    private Image imagen;

    public FondoPantalla(String path) {
        imagen = Toolkit.getDefaultToolkit().createImage(getClass().getResource(path));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}