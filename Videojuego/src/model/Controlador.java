package model;

import controlador.MouseInput;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Enums.CHOICEP1;
import model.Enums.CHOICEP2;
import model.Enums.STATE;
import view.CustomPanel;
import view.FondoPantalla;
import view.PantallaInicio;

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
    private PantallaManager pantallaManager;
    /**
     * Número máximo de rondas
     */
    public static final int MAX_RONDAS = 3;
    /**
     * Contador de rondas, inicia en 1
     */
    public static int rondaActual = 1;
    /**
     * número de victorias que ha ganado el jugador 1
     */
    public static int victoriasJugador1 = 0;
    /**
     * número de victorias que ha ganado el jugador 2
     */
    public static int victoriasJugador2 = 0;
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
     * entero con el número de mapa elegido.
     */
    public static int mapa = 0;
    /**
     * Parámetro de anchura del frame.
     */
    public static int FrameWidth = 1280;
    /**
     * Parámetro de altura del frame.
     */
    public static int FrameHeight = 720;

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

        pantallaManager = new PantallaManager(frame);

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
	 * Cambia la pantalla mostrada en el JFrame.
	 *
	 * @param nombrePantalla Nombre de la pantalla a mostrar.
	 */
	private void cargarPantallas() {
		PantallaInicio pantallaInicio = new PantallaInicio();
		mainPanel.add(pantallaInicio.getPanel(), "PantallaInicio");
	}


    @Override
    public void keyTyped(KeyEvent e) {
        // Implementación del método keyTyped
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // Lógica para manejar eventos de teclado
        if (keyCode == KeyEvent.VK_ENTER) {
            // System.out.println("Enter key pressed");
            Enums.setState(STATE.CHARSEL1);
            cambiarPantalla("SeleccionCaracteres");
            // System.out.println("State changed to: " + Enums.getState());
        }
        if (keyCode == KeyEvent.VK_ESCAPE) {
            // System.out.println("Escape key pressed");
            cambiarPantalla("PantallaInicio");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Implementación del método keyReleased
    }

    @Override
    public void mostrarPantallaGanador(String ganador) {
        JFrame pantallaGanador = new JFrame("¡Ganador!");

        pantallaGanador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantallaGanador.setSize(FrameWidth, FrameHeight);
        pantallaGanador.setResizable(false);
        pantallaGanador.setLocationRelativeTo(null);

        // Crear el panel de fondo personalizado
        String path = "/Imagenes/PantallaGanador.jpg"; // Ruta del fondo
        FondoPantalla fondoPantalla = new FondoPantalla(path); // Usamos la clase FondoPantalla para dibujar la imagen de fondo

        // Crear un panel para mostrar el texto del ganador
        JPanel winnerPanel = new JPanel();
        JLabel winnerLabel = new JLabel(ganador);
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 100));
        winnerLabel.setForeground(Color.BLACK);
        winnerPanel.setOpaque(false); // Hacer transparente el panel para que se vea el fondo
        winnerPanel.add(winnerLabel);

        pantallaGanador.setContentPane(fondoPantalla);
        pantallaGanador.add(winnerPanel);
        pantallaGanador.revalidate();
        pantallaGanador.repaint();
        pantallaGanador.setVisible(true);
    }





    
 /**
	 * Método para cambiar entre pantallas
	 * 
	 * @param nombrePantalla nombre de la pantalla que se va cambiar
	 */
	public void cambiarPantalla(String nombrePantalla) {
		// System.out.println("Changing screen to: " + nombrePantalla);
		cardLayout.show(mainPanel, nombrePantalla);
		actualizarFondo(nombrePantalla,mapa);
	}


	/**
	 * Método para actualizar la imagen de fondo dado una ruta de imagen.
	 * 
	 * @param nombrePantalla Nombre de la pantalla a mostrar.
	 */
	public void actualizarFondo(String nombrePantalla, int mapa) {
        pantallaManager.actualizarFondo(nombrePantalla,mapa);
		}
	


    /**
     * Incrementa las victorias del jugador 1
     */
    public static void incrementarVictoriasJugador1() {
        victoriasJugador1++;
    }

    /**
     * Incrementa las victorias del jugador 2
     */
    public static void incrementarVictoriasJugador2() {
        victoriasJugador2++;
    }

    /**
     * Devuelve el ganador del juego.
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
}