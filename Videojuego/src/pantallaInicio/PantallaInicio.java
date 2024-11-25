package pantallaInicio;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PantallaInicio {
    private JPanel panel;

    public PantallaInicio() {
        panel = new JPanel();
        panel.setLayout(null); 
        panel.setPreferredSize(new Dimension(1280, 720));

        // Fondo de pantalla
        FondoPantalla pantallaInicio = new FondoPantalla("/Imagenes/pi.png");
        pantallaInicio.setBounds(0, 0, 1280, 720);

        // Texto de inicio
        JLabel textoInicio = new JLabel("Press Enter to Start",JLabel.CENTER);
        textoInicio.setFont(new Font("Verdana", Font.PLAIN, 30));
        textoInicio.setSize(400, 100); // Establecemos un tamaño fijo para el JLabel
        textoInicio.setLocation(
            (1000 - textoInicio.getWidth()) / 2, // Centrado horizontalmente
            (1000 - textoInicio.getHeight()) / 2 // Centrado verticalmente
        );
        System.out.println(textoInicio.getWidth());

        // Agregar elementos al panel usando un JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1280, 720);
        layeredPane.add(pantallaInicio, Integer.valueOf(0)); // Fondo en la capa 0
        layeredPane.add(textoInicio, Integer.valueOf(1));    // Texto en la capa 1

        panel.add(layeredPane);
    }

    public JPanel getPanel() {
        return panel;
    }
}
