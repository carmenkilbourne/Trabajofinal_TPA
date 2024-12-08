package pantallas;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


import java.awt.Graphics;
public class PantallaPelea {
    private JPanel panel;
    private JLayeredPane layeredPane;


    public PantallaPelea(String path) {
    	 layeredPane = new JLayeredPane();
    	 layeredPane.setPreferredSize(new java.awt.Dimension(1280, 720));
         //Partida partida = new Partida(path);
         //layeredPane.add(partida, Integer.valueOf(0));
    }

    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(layeredPane);
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
 