package pantallaInicio;

import javax.swing.JFrame;

public class FondoPantalla {

	public static void main(String[] args) {
		// Crear el marco de la ventana
				JFrame frame = new JFrame("Pantalla de Inicio");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1000, 500);	//tamano de frame
				// Crear una instancia de ImagePanel con el path a la imagen path
				ImagePanel imagePanel = new ImagePanel("/Imagenes/pixil-frame-0.png");
				// Añadir el panel al marco
				frame.add(imagePanel);
				// Hacer visible la ventana
				frame.setVisible(true);

	}

}
