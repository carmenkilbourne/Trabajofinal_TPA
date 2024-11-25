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

    public Controlador() {
        frame = new JFrame("Juego");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        CuadroTexto cuadroTexto = new CuadroTexto("Press Enter to Start");
        cuadroTexto.setBounds(50, 50, 500, 50); // Ajusta el tamaño
        cuadroTexto.setOpaque(false);

        PantallaInicio pantallaInicial = new PantallaInicio();
        SeleccionCaracteres seleccionCaracteres = new SeleccionCaracteres();

        mainPanel.add(pantallaInicial.getPanel(), "PantallaInicio");
        mainPanel.add(cuadroTexto);
        
        mainPanel.add(seleccionCaracteres.getPanel(), "SeleccionCaracteres");

        frame.add(mainPanel);
        frame.addKeyListener(this);
        frame.setVisible(true);
    }

    // Método para cambiar entre pantallas
    public void cambiarPantalla(String nombrePantalla) {
        cardLayout.show(mainPanel, nombrePantalla);
    }

    // Manejar eventos de teclado
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // Lógica para manejar eventos de teclado
        if (keyCode == KeyEvent.VK_ENTER) {
            cambiarPantalla("SeleccionCaracteres");
        }
        // Agregar más lógica aquí
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No implementado
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No implementado
    }

    public static void main(String[] args) {
        new Controlador();
    }
}