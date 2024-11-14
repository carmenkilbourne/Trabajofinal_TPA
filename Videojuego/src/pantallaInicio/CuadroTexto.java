package pantallaInicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CuadroTexto extends JPanel {
    
	private static final long serialVersionUID = 1L;
	private JLabel etiqueta;
    private JButton boton;

    public CuadroTexto(String texto) {
        // Usar layout nulo para definir posiciones manualmente
        setLayout(null);

        // Crear el label y definir su posición
        etiqueta = new JLabel(texto);
        etiqueta.setBounds(100, 50, 300, 300); // (x, y, width, height)
        add(etiqueta);

        // Crear el botón y definir su posición
        boton = new JButton(texto);
        boton.setBounds(50, 80, 200, 50); // (x, y, width, height)
        add(boton);

        // Añadir un ActionListener al botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	etiqueta.setText("Pasar al siguiente frame");
            }
        });
    }
}