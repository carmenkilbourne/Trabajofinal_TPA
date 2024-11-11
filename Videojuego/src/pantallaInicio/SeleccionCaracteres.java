package pantallaInicio;


import javax.swing.JFrame;
import javax.swing.JLayeredPane;

//fondo
	//imagenes de personajes
	//selector con raton
	//un selector para cada personaje uno despues de otro
public class SeleccionCaracteres {
	
    public static void main(String[] args) {
    	JFrame frame = new JFrame("Seleccion de caracteres");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000); // Tamaño del frame
        frame.setLocationRelativeTo(null);	//Poner en medio de la pantalla
        frame.setResizable(false);
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
        frame.add(layeredPane);
        // Añadir el layeredPane al frame
        frame.setVisible(true);
    }
}
 