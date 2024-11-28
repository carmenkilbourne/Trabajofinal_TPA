package pantallaInicio;

import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controlador implements KeyListener {
	private static Controlador instance;
	private JFrame frame;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private FondoPantalla fondoPantalla;

	public static STATE state = STATE.MENU;
	public static CHOICEP1 choiceP1 = CHOICEP1.NOTHING;
	public static CHOICEP2 choiceP2 = CHOICEP2.NOTHING2;
	public static int mapa = 0;
	public static int FrameWidth = 1000;
	public static int FrameHeight = 1000;

	public Controlador() {
		instance = this;
		frame = new JFrame("Juego");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FrameWidth, FrameHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);

		// Inicializar pantallas
		PantallaInicio pantallaInicio = new PantallaInicio();

		// Añadir pantallas al panel principal
		mainPanel.add(pantallaInicio.getPanel(), "PantallaInicio");

		frame.add(mainPanel);
		frame.addKeyListener(this);

		// Agregar MouseInput como MouseListener
		MouseInput mouseInput = new MouseInput(frame);
		frame.addMouseListener(mouseInput);

		// Crear y agregar el CustomPanel
		CustomPanel customPanel = new CustomPanel(mouseInput);
		customPanel.setBounds(0, 0, FrameWidth, FrameHeight); // Asegúrate de que el tamaño y la posición sean adecuados
		frame.add(customPanel);

		frame.setVisible(true);

		// Mostrar la pantalla de inicio al iniciar
		cambiarPantalla("PantallaInicio");
	}

	public static Controlador getInstance() {
		return instance;
	}

	// Estados del juego
	public static enum STATE {
		MENU, CHARSEL1, CHARSEL2, CHOOSE, GAME
	}

	// Selección de personajes
	public static enum CHOICEP1 {
		GIGANTE1, HADA1, NOTHING
	}

	public static enum CHOICEP2 {
		GIGANTE2, HADA2, NOTHING2
	}

	// Método para cambiar entre pantallas
	public void cambiarPantalla(String nombrePantalla) {
		System.out.println("Changing screen to: " + nombrePantalla);
		cardLayout.show(mainPanel, nombrePantalla);
		actualizarFondo(nombrePantalla);
	}

	// Método para actualizar la imagen de fondo
	private void actualizarFondo(String nombrePantalla) {
		String path = "";
		switch (nombrePantalla) {
		case "PantallaInicio":
			path = "/Imagenes/PantallaInicio.png";
			break;
		case "SeleccionCaracteres":
			path = "/Imagenes/seleccion_personajes.png";
			break;
		case "SeleccionMapa":
			path = "/Imagenes/seleccion_mapa.png";
			break;
		case "Game":
			switch (mapa) {
			case 1:
				path = "/Imagenes/mapa1.png";
				break;
			case 2:
				path = "/Imagenes/mapa2.png";
				break;
			case 3:
				path = "/Imagenes/mapa3.png";
				break;
			case 4:
				path = "/Imagenes/mapa4.png";
				break;
			}
			break;
		// Agregar más casos según sea necesario
		}
		fondoPantalla = new FondoPantalla(path);
		frame.setContentPane(fondoPantalla);
		frame.revalidate();
		frame.setResizable(true);
	}

	// Manejar eventos de teclado
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		// Lógica para manejar eventos de teclado
		if (keyCode == KeyEvent.VK_ENTER) {
			System.out.println("Enter key pressed");
			state = STATE.CHARSEL1;
			cambiarPantalla("SeleccionCaracteres");
			System.out.println("State changed to: " + state);
		}
		if (keyCode == KeyEvent.VK_ESCAPE) {
			System.out.println("Escape key pressed");
			cambiarPantalla("SeleccionMapa");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Implementar si es necesario
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Implementar si es necesario
	}

	public static void main(String[] args) {
		new Controlador();
	}
}