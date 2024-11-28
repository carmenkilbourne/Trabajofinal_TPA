package pantallaInicio;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


import java.awt.Graphics;
public class PantallaPelea {
    private JPanel panel;

    public PantallaPelea() {
        panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString("¡Comienza la pelea!", 50, 50);
            }
        };
        panel.setLayout(null); // Cambia el layout si es necesario
    }

    public JPanel getPanel() {
        return panel;
    }
}


 /*
   public class PantallaPelea {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Pantalla de Pelea");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        Partida partida = new Partida();
        frame.add(partida);
        partida.empezarPartida();
        frame.pack();
        frame.setVisible(true);

	}

}
*/
 