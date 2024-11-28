package pantallaInicio;

import java.awt.Graphics;
import javax.swing.JPanel;

public class CustomPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MouseInput mouseInput;

    public CustomPanel(MouseInput mouseInput) {
        this.mouseInput = mouseInput;
        addMouseListener(mouseInput);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        mouseInput.render(g);
    }
}