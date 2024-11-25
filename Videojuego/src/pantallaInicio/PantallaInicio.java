package pantallaInicio;

import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PantallaInicio {
    private JPanel panel;

    public PantallaInicio() {
        panel = new JPanel();
        panel.setLayout(null); // Posicionamiento manual
        panel.setPreferredSize(new Dimension(1000, 1000));

        // Fondo de pantalla
        FondoPantalla pantallaInicio = new FondoPantalla("/Imagenes/PantallaInicio.png");
        pantallaInicio.setBounds(0, 0, 1000, 1000);

        // Texto de inicio
        JLabel textoInicio = new JLabel("Press Enter to Start");
        textoInicio.setBounds(400, 450, 200, 50); // Centrado en la pantalla

        // Agregar elementos al panel usando un JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1000, 1000);
        layeredPane.add(pantallaInicio, Integer.valueOf(0)); // Fondo en la capa 0
        layeredPane.add(textoInicio, Integer.valueOf(1));    // Texto en la capa 1

        panel.add(layeredPane);
    }

    public JPanel getPanel() {
        return panel;
    }
}