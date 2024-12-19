package view;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Pantalla inicial del Juego se encarga de dibujar el fondo de pantalla.
 */
public class PantallaInicio {
    private JLayeredPane layeredPane;
    public static int FrameWidth = 1000;
	public static int FrameHeight = 1000;

    /**
     * Constructor que dibuja el fondo de pantalla en un layered pane.
     */
    public PantallaInicio() {
        FondoPantalla pantallaInicio = new FondoPantalla("/Imagenes/PantallaInicio.png");
        pantallaInicio.setBounds(0, 0, FrameWidth, FrameHeight); // Ajustar tamaño del fondo

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new java.awt.Dimension(1000, 1000));
        layeredPane.add(pantallaInicio, Integer.valueOf(0)); // Poner fondo de pantalla en la capa 0
    }

    /**
     * Método para dibujar ene el panel la pantalla de inicio.
     * @return panel de pantalla de inicio
     */
    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(layeredPane);
        return panel;
    }
}