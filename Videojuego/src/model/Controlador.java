package model;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.MouseInput;
import view.CustomPanel;
import view.FondoPantalla;
import view.PantallaInicio;
import view.Partida;

/**
 * Clase Controlador que maneja los distintos estados del Juego. Implementa el
 * patrón Singleton ya que solo tiene una única instancia. Implementa el patrón
 * STATE(estado) ya que maneja los diferentes estados del juego. Implementa el
 * patrón Observer ya que implementa un KeyListener.
 */
public class Controlador implements KeyListener, IControlador {
	private static Controlador instance;
	private JFrame frame;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private FondoPantalla fondoPantalla;
	/**
	 * Número máximo de rondas
	 */
	public static final int MAX_RONDAS = 3;
	/**
	 * Contador de rondas, inicia en 1
	 */
	public static int rondaActual = 0;
	/**
	 * numero de victorias que ha ganado el jugador 1
	 */
	public static int victoriasJugador1 = 0;
	/**
	 * numero de victorias que ha ganado el jugador 2
	 */
	public static int victoriasJugador2 = 0;

	/**
	 * Inicializamos el juego en estado de menu.
	 */
	public static STATE state = STATE.MENU;
	/**
	 * Inicializamos la opción 1 del personaje a nada ya que no hemos elegido
	 * personaje aún.
	 */
	public static CHOICEP1 choiceP1 = CHOICEP1.NOTHING; // tipos de personajes
	/**
	 * Inicializamos la opción 2 del personaje a nada ya que no hemos elegido
	 * personaje aún.
	 */
	public static CHOICEP2 choiceP2 = CHOICEP2.NOTHING2;// tipos de personajes
	/**
	 * entero con el numero de mapa elegido.
	 */
	public static int mapa = 0;
	/**
	 * Parametro de anchura del frame.
	 */
	public static int FrameWidth = 1280;
	/**
	 * Parametro de altura del frame.
	 */
	public static int FrameHeight = 720;

	/**
	 * Estados del juego
	 */
	public static enum STATE {
		MENU
		/** Estado menu */
		, CHARSEL1
		/** Estado seleccion caracter 1 */
		, CHARSEL2
		/** Estado seleccion caracter 2 */
		, CHOOSE
		/** Estado seleccion mapa */
		, GAME
		/** Estado de jugando partida */
		, GANADOR /** Estado de mostrar ganador */
	}

	/**
	 * Selección de personaje para jugador 1.
	 */
	public static enum CHOICEP1 {
		GIGANTE
		/** personaje gigante */
		, HADA
		/** personaje hada */
		, NOTHING /** personaje no escogido */
	}

	/**
	 * Selección de personaje para jugador 1.
	 */
	public static enum CHOICEP2 {
		GIGANTE
		/** personaje gigante */
		, HADA
		/** personaje hada */
		,NOTHING2 /** personaje no escogido */
	}

	/**
	 * Constructor del controlador, inicializa las pantallas, el layout y el JFrame.
	 */
	public Controlador() {
		instance = this;
		frame = new JFrame("Juego");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FrameWidth, FrameHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);

		// Cargar las pantallas
		cargarPantallas();

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

	/**
	 * Método que devuelve la instancia única de Controlador.
	 *
	 * @return Instancia de Controlador.
	 */
	public static Controlador getInstance() {
		return instance;
	}

	/**
	 * Carga las pantallas.
	 *
	 * @param nombrePantalla Nombre de la pantalla a mostrar.
	 */
	private void cargarPantallas() {
		PantallaInicio pantallaInicio = new PantallaInicio();
		mainPanel.add(pantallaInicio.getPanel(), "PantallaInicio");

	}

	/**
	 * Método para cambiar entre pantallas
	 * 
	 * @param nombrePantalla nombre de la pantalla que se va cambiar
	 */
	public void cambiarPantalla(String nombrePantalla) {
		cardLayout.show(mainPanel, nombrePantalla);
		actualizarFondo(nombrePantalla);
	}

	/**
	 * Método para actualizar la imagen de fondo dado una ruta de imagen.
	 * 
	 * @param nombrePantalla Nombre de la pantalla a mostrar.
	 */

	public void actualizarFondo(String nombrePantalla) {
		String path = "";
		switch (nombrePantalla) {
		case "PantallaInicio":
			path = "/Imagenes/PantallaInicio.png";
			fondoPantalla = new FondoPantalla(path);
			frame.setContentPane(fondoPantalla);
			frame.revalidate();
			frame.setResizable(true);
			break;
		case "SeleccionCaracteres":
			path = "/Imagenes/Fondos/seleccion_personajes.png";
			fondoPantalla = new FondoPantalla(path);
			frame.setContentPane(fondoPantalla);
			frame.revalidate();
			frame.setResizable(true);
			break;
		case "SeleccionMapa":
			path = "/Imagenes/Fondos/seleccion_mapa.png"; // cambiar a imagen que muestre los cuatro mapas
			fondoPantalla = new FondoPantalla(path);
			frame.setContentPane(fondoPantalla);
			frame.revalidate();
			frame.setResizable(true);
			break;
		case "Game":
			switch (mapa) {
			case 1:
				path = "/Imagenes/Mapas/Montana.jpg";
				break;
			case 2:
				path = "/Imagenes/Mapas/Jungla.jpg";
				break;
			case 3:
				path = "/Imagenes/Mapas/BoxingRing.png";
				break;
			case 4:
				path = "/Imagenes/Mapas/Candyland.jpg";
				break;
			default:
				System.out.println("Mapa escogido incorrectamente");
				break;
			}
			frame.setVisible(false);
			frame = new JFrame("Pantalla de Pelea");
			frame.setSize(1280, 720);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			Partida partida = new Partida(path, Controlador.choiceP1, Controlador.choiceP2);
			frame.add(partida);
			partida.empezarPartida();
			if (partida.esPartidaTerminada()) {
				cambiarPantalla("PantallaInicio");
			}
			frame.pack();
			frame.setVisible(true);
			frame.setResizable(true);
			break;
		}
	}

	/**
	 * Manejar eventos de teclado pasanso de pantalla inicial a seleccion de
	 * caracteres.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		/*Esc para pasar  de pantalla inicial a Seleccion de caracteres*/
		if (keyCode == KeyEvent.VK_ENTER) {
			// System.out.println("Enter key pressed");
			state = STATE.CHARSEL1;
			cambiarPantalla("SeleccionCaracteres");
			// System.out.println("State changed to: " + state);
		}
		if (keyCode == KeyEvent.VK_ESCAPE) {
			// System.out.println("Escape key pressed");
			cambiarPantalla("PantallaInicio");
		}
	}

	/**
	 * Método del KeyListener no implementado
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * Método del KeyListener no implementado
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * incrementa las victorias del jugador 1
	 */
	public static void incrementarVictoriasJugador1() {
		victoriasJugador1++;
	}

	/**
	 * incrementa las victorias del jugador 2
	 */
	public static void incrementarVictoriasJugador2() {
		victoriasJugador2++;
	}

	/**
	 * Devuelve el gandador del juego.
	 * 
	 * @return ganador del juego
	 */
	public static String getGanadorFinal() {
		if (victoriasJugador1 > victoriasJugador2) {
			return "Jugador 1";
		} else if (victoriasJugador2 > victoriasJugador1) {
			return "Jugador 2";
		} else {
			return "Empate";
		}
	}

	/**
	 * Metodo que muestra la pantalla del jugador
	 * 
	 * @param ganador es el nombre del jugador ganador, Jugador1 o Jugador2
	 */
	public void mostrarPantallaGanador() {
		JFrame pantallaGanador = new JFrame("¡Ganador!");

		pantallaGanador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantallaGanador.setSize(FrameWidth, FrameHeight);
		pantallaGanador.setResizable(false);
		pantallaGanador.setLocationRelativeTo(null);

		// Crear el panel de fondo personalizado
		String path = "/Imagenes/PantallaGanador.jpg"; // Ruta del fondo
		FondoPantalla fondoPantalla = new FondoPantalla(path); // Usamos la clase FondoPantalla para dibujar la imagen
																// de fondo

		// Crear un panel para mostrar el texto del ganador
		JPanel winnerPanel = new JPanel();
		JLabel winnerLabel = new JLabel(getGanadorFinal());
		winnerLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
		winnerLabel.setForeground(Color.BLACK);
		winnerPanel.setOpaque(false); // Hacer transparente el panel para que se vea el fondo
		winnerPanel.add(winnerLabel);

		pantallaGanador.setContentPane(fondoPantalla);
		pantallaGanador.add(winnerPanel);
		pantallaGanador.revalidate();
		pantallaGanador.repaint();
		pantallaGanador.setVisible(true);
	}

}
