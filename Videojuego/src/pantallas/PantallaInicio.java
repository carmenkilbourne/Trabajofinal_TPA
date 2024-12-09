package pantallas;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PantallaInicio {
    private JLayeredPane layeredPane;
    public static int FrameWidth = 1000;
	public static int FrameHeight = 1000;

    public PantallaInicio() {
        FondoPantalla pantallaInicio = new FondoPantalla("/Imagenes/PantallaInicio.png");
        pantallaInicio.setBounds(0, 0, FrameWidth, FrameHeight); // Ajustar tamaño del fondo

        //CuadroTexto cuadroTexto = new CuadroTexto("To start click");
        //cuadroTexto.setBounds(350, 350, 800, 800); // Ajustar tamaño y posición del cuadro de texto
        //cuadroTexto.setOpaque(false); // Hacer transparente el fondo del CuadroTexto

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new java.awt.Dimension(1000, 1000));
        layeredPane.add(pantallaInicio, Integer.valueOf(0)); // Poner fondo de pantalla en la capa 0
        //layeredPane.add(cuadroTexto, Integer.valueOf(1)); // Poner boton de start en la capa 1
    }

    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(layeredPane);
        return panel;
    }
}