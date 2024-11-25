package pantallaInicio;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
/*
 * poner un enum con los 2 personajes posibles 
 * */
public class SeleccionCaracteres {
    private JPanel panel;
    public enum Personaje {
        OGRO,
        HADA
    }
    Personaje personajeElegido;

    public SeleccionCaracteres() {
        panel = new JPanel();
        panel.setLayout(null); // Posicionamiento manual
        panel.setPreferredSize(new Dimension(1280, 720));

        // Fondo de pantalla
        FondoPantalla pantallaInicio = new FondoPantalla("/Imagenes/SeleccionPersonajes.png");
        pantallaInicio.setBounds(0, 0, 1280, 720);

        // Botón para iniciar
        JButton boton1 = new JButton("Ogro");
        boton1.setBounds(450, 520, 100, 30);
        JButton boton2 = new JButton("Hada");
        boton2.setBounds(500, 400, 100, 30);

        // Agregar ActionListener al botón (Ejemplo: Cambiar de pantalla)
        boton1.addActionListener(e -> {
            System.out.println("Ogro"); // Aquí puedes conectar con el controlador
             personajeElegido = Personaje.OGRO;
            
        });
        boton2.addActionListener(e -> {
            System.out.println("Hada"); // Aquí puedes conectar con el controlador
             personajeElegido = Personaje.HADA;

        });
        // Agregar elementos al panel usando un JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1280, 720);
        layeredPane.add(pantallaInicio, Integer.valueOf(0)); // Fondo en la capa 0
        layeredPane.add(boton1, Integer.valueOf(1));    
        layeredPane.add(boton2, Integer.valueOf(1));    


        panel.add(layeredPane);
    }

    public JPanel getPanel() {
        return panel;
    }
    public Personaje personajeSeleccionado() {
    	return personajeElegido;
    }
}