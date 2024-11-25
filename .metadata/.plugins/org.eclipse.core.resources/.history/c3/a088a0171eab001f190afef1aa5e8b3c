package pantallaInicio;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class SeleccionCaracteres {
    private JPanel panel;

    public SeleccionCaracteres() {
        panel = new JPanel();
        panel.setLayout(null); // Usar layout nulo para posicionar componentes manualmente
        panel.setPreferredSize(new java.awt.Dimension(1000, 1000));

        // Crear una instancia de FondoPantalla con el path a la imagen
        FondoPantalla seleccionPersonajes = new FondoPantalla("/Imagenes/seleccion_personajes.png");
        seleccionPersonajes.setBounds(0, 0, 1000, 1000); // Ajustar tamaño del fondo

        // Usar un JLayeredPane para superponer el fondo y los elementos
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new java.awt.Dimension(1000, 1000));

        // Agregar los componentes al layeredPane
        layeredPane.add(seleccionPersonajes, Integer.valueOf(0)); // Poner fondo de pantalla en la capa 0
        //layeredPane.add(cuadroTexto, Integer.valueOf(1)); // boton para seleccionar caracter 
        //boton condicional para que se active cuando el otro este presionado para aceptar

        panel.add(layeredPane);
    }

    public JPanel getPanel() {
        return panel;
    }
}