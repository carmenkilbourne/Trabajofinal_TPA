package pantallaInicio;

import java.awt.Color;

import javax.swing.JFrame;

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
