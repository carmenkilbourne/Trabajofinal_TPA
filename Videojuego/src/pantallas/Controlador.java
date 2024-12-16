package pantallas;

import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controlador implements KeyListener, IControlador {
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

    // Estados del juego
    public static enum STATE {
        MENU, CHARSEL1, CHARSEL2, CHOOSE, GAME
    }

    // Selección de personajes
    public static enum CHOICEP1 {
        GIGANTE, HADA, NOTHING
    }

    public static enum CHOICEP2 {
        GIGANTE, HADA, NOTHING2
    }

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

    public static Controlador getInstance() {
        return instance;
    }

    // Método para cargar las pantallas
    private void cargarPantallas() {
        PantallaInicio pantallaInicio = new PantallaInicio();
        PantallaGanador pantallaGanador = new PantallaGanador();
        // Aquí puedes agregar más pantallas según sea necesario

        mainPanel.add(pantallaInicio.getPanel(), "PantallaInicio");
        mainPanel.add(pantallaGanador.getPanel(), "PantallaGanador");
        // mainPanel.add(pantallaPelea.getPanel(), "PantallaPelea");
    }

    // Método para cambiar entre pantallas
    public void cambiarPantalla(String nombrePantalla) {
        System.out.println("Changing screen to: " + nombrePantalla);
        cardLayout.show(mainPanel, nombrePantalla);
        actualizarFondo(nombrePantalla);
    }

    // Método para actualizar la imagen de fondo
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
                // Controlador.choiceP1 Controlador.choiceP2
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
            cambiarPantalla("PantallaInicio");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }
}
