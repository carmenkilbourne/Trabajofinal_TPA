package pantallaInicio;
import javax.swing.JFrame;

public class PantallaPelea {

	public static void main(String[] args) {
       
		JFrame frame = new JFrame("Pantalla de Pelea");
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1280, 720); // Tamaño del frame
        frame.setLocationRelativeTo(null);//centro de pantalla
        //frame.setResizable(false);
        Partida partida = new Partida();
        frame.add(partida);
        partida.empezarPartida();
        frame.pack();
        frame.setVisible(true);

	}

}
