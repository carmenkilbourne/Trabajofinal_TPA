package pantallaInicio;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class SeleccionMapa {
    private JPanel panel;

    public SeleccionMapa(Controlador controlador) {
        panel = new JPanel();
        panel.setLayout(null); // Usar layout nulo para posicionar componentes manualmente
        panel.setPreferredSize(new java.awt.Dimension(1000, 1000));

        // Crear una instancia de FondoPantalla con el path a la imagen
        FondoPantalla seleccionMapas = new FondoPantalla("/Imagenes/seleccion_mapas.png");
        seleccionMapas.setBounds(0, 0, 1000, 1000); // Ajustar tamaño del fondo

        // Crear una instancia de CuadroTextoMapa
   
        // Usar un JLayeredPane para superponer el fondo y los elementos
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new java.awt.Dimension(1000, 1000));

        // Agregar los componentes al layeredPane
        layeredPane.add(seleccionMapas, Integer.valueOf(0)); // Poner fondo de pantalla en la capa 0
        

        panel.add(layeredPane);
    }

    public JPanel getPanel() {
        return panel;
    }


}