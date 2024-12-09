package pantallas;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PantallaGanador {
    private JLayeredPane layeredPane;

	public PantallaGanador() {

		FondoPantalla pantallaInicio = new FondoPantalla("/Imagenes/PantallaInicio.png");
        pantallaInicio.setBounds(0, 0, 1480, 720); // Ajustar tamaño del fondo

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new java.awt.Dimension(1480, 720));
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
