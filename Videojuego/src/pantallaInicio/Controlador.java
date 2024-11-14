package pantallaInicio;

import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Controlador implements KeyListener {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private FondoPantalla fondoPantalla;

    public Controlador() {
        frame = new JFrame("Juego");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Inicializar pantallas
        PantallaInicio pantallaInicio = new PantallaInicio();
        SeleccionCaracteres seleccionCaracteres = new SeleccionCaracteres();
        SeleccionMapa seleccionMapa = new SeleccionMapa(this);

        // Añadir pantallas al panel principal
        mainPanel.add(pantallaInicio.getPanel(), "PantallaInicio");
        mainPanel.add(seleccionCaracteres.getPanel(), "SeleccionCaracteres");
        mainPanel.add(seleccionMapa.getPanel(), "SeleccionMapa");

        frame.add(mainPanel);
        frame.addKeyListener(this);
        frame.setVisible(true);

        // Mostrar la pantalla de inicio al iniciar
        cambiarPantalla("PantallaInicio");
    }

    // Método para cambiar entre pantallas
    public void cambiarPantalla(String nombrePantalla) {
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
            cambiarPantalla("SeleccionCaracteres");
        }
        if (keyCode == KeyEvent.VK_ESCAPE) {
            cambiarPantalla("SeleccionMapa");
        }
        // Agregar más lógica aquí
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