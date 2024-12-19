package view;

import java.awt.Graphics;
import javax.swing.JPanel;

import controlador.MouseInput;

/**
 * Clase que añade un mouse listener a un panel.
 */
public class CustomPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MouseInput mouseInput;

    /**
     * Añade al panel el mouse input
     * @param mouseInput
     */
    public CustomPanel(MouseInput mouseInput) {
        this.mouseInput = mouseInput;
        addMouseListener(mouseInput);
    }

    /**
     *Pinta el componente en pantalla
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        mouseInput.render(g);
    }
}