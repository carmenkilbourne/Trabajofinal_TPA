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
import view.PantallaGanador;
import view.PantallaInicio;
import view.Partida;

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
    public static int FrameWidth = 1280;
    public static int FrameHeight = 720;

    // Estados del juego
    public static enum STATE {
        MENU, CHARSEL1, CHARSEL2, CHOOSE, GAME, GANADOR
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
        //System.out.println("Changing screen to: " + nombrePantalla);
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
            //System.out.println("Enter key pressed");
            state = STATE.CHARSEL1;
            cambiarPantalla("SeleccionCaracteres");
            //System.out.println("State changed to: " + state);
        }
        if (keyCode == KeyEvent.VK_ESCAPE) {
           // System.out.println("Escape key pressed");
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
    public static void incrementarVictoriasJugador1() {
        victoriasJugador1++;
    }

    public static void incrementarVictoriasJugador2() {
        victoriasJugador2++;
    }
    public static final int MAX_RONDAS = 3; // Número máximo de rondas
    public static int rondaActual = 0; // Contador de rondas, inicia en 1
    public static int victoriasJugador1 = 0;
    public static int victoriasJugador2 = 0;
    public static String getGanadorFinal() {
        if (victoriasJugador1 > victoriasJugador2) {
            return "Jugador 1";
        } else if (victoriasJugador2 > victoriasJugador1) {
            return "Jugador 2";
        } else {
            return "Empate";
        }
    }
    public void mostrarPantallaGanador(String ganador) {
         JFrame pantallaGanador = new JFrame("¡Ganador!");
         
         pantallaGanador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         pantallaGanador.setSize(FrameWidth, FrameHeight);
         pantallaGanador.setResizable(false);
         pantallaGanador.setLocationRelativeTo(null);

         // Crear el panel de fondo personalizado
         String path = "/Imagenes/PantallaGanador.jpg"; // Ruta del fondo
         FondoPantalla fondoPantalla = new FondoPantalla(path);  // Usamos la clase FondoPantalla para dibujar la imagen de fondo
         
         // Crear un panel para mostrar el texto del ganador
         JPanel winnerPanel = new JPanel();
         JLabel winnerLabel = new JLabel(ganador);
         winnerLabel.setFont(new Font("Arial", Font.BOLD, 100));  // Cambia "Arial" por cualquier fuente que prefieras, 50 es el tamaño
         winnerLabel.setForeground(Color.BLACK);  // Establecer el color del texto a amarillo
         winnerPanel.setOpaque(false);  // Hacer transparente el panel para que se vea el fondo
         winnerPanel.add(winnerLabel);

         // Añadir los dos paneles: fondo + texto
         pantallaGanador.setContentPane(fondoPantalla);  // Establece el panel de fondo como el contenedor principal
         pantallaGanador.add(winnerPanel);  // Añadir el panel con el texto encima del fondo
         pantallaGanador.revalidate();
         pantallaGanador.repaint();

         // Hacer visible la ventana
         pantallaGanador.setVisible(true);
     }

}
