package pantallaInicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CuadroTextoMapa extends JPanel {
    
    private static final long serialVersionUID = 1L;
    private JLabel etiqueta;
    private JButton botonMapa1;
    private JButton botonMapa2;
    private JButton botonMapa3;

    public CuadroTextoMapa(String texto) {
        // Usar layout nulo para definir posiciones manualmente
        setLayout(null);

        // Crear el label y definir su posición
        etiqueta = new JLabel(texto);
        etiqueta.setBounds(100, 50, 300, 30); // (x, y, width, height)
        add(etiqueta);

        // Crear los botones para los mapas
        botonMapa1 = new JButton("Mapa 1");
        botonMapa1.setBounds(50, 100, 200, 50); // (x, y, width, height)
        add(botonMapa1);

        botonMapa2 = new JButton("Mapa 2");
        botonMapa2.setBounds(300, 100, 200, 50); // (x, y, width, height)
        add(botonMapa2);

        botonMapa3 = new JButton("Mapa 3");
        botonMapa3.setBounds(550, 100, 200, 50); // (x, y, width, height)
        add(botonMapa3);

        // Añadir ActionListeners a los botones
        botonMapa1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText("Has seleccionado Mapa 1");
            }
        });

        botonMapa2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText("Has seleccionado Mapa 2");
            }
        });

        botonMapa3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText("Has seleccionado Mapa 3");
            }
        });
    }

    public JButton getBotonMapa1() {
        return botonMapa1;
    }

    public JButton getBotonMapa2() {
        return botonMapa2;
    }

    public JButton getBotonMapa3() {
        return botonMapa3;
    }

    public void actualizarEtiqueta(String texto) {
        etiqueta.setText(texto);
    }
}