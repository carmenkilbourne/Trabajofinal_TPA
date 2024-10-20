package pantallaInicio;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class PantallaInicio {
    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Pantalla de Inicio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000); // Tamaño del frame
        frame.setLocationRelativeTo(null);	//Poner en medio de la pantalla
        
        FondoPantalla pantallaInicio = new FondoPantalla("/Imagenes/PantallaInicio.png");
        pantallaInicio.setBounds(0, 0, 1000, 1000); // Ajustar tamaño del fondo

        CuadroTexto cuadroTexto = new CuadroTexto("To start click");
        cuadroTexto.setBounds(350, 350, 800, 800); // Ajustar tamaño y posición del cuadro de texto
        cuadroTexto.setOpaque(false); // Hacer transparente el fondo del CuadroTexto

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new java.awt.Dimension(1000, 1000));
        layeredPane.add(pantallaInicio, Integer.valueOf(0)); // Poner fondo de pantalla en la capa 0
        layeredPane.add(cuadroTexto, Integer.valueOf(1)); // Poner boton de start  en la capa 1
      
        frame.add(layeredPane);
        frame.setVisible(true);
    }
}
