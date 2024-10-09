package pantallaInicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CuadroTexto extends JPanel {
    private JLabel label;
    private JButton button;

    public CuadroTexto(String texto) {
        // Usar layout nulo para definir posiciones manualmente
        setLayout(null);

        // Crear el label y definir su posición
        label = new JLabel(texto);
        label.setBounds(50, 30, 300, 300); // (x, y, width, height)
        add(label);

        // Crear el botón y definir su posición
        button = new JButton(texto);
        button.setBounds(50, 80, 200, 50); // (x, y, width, height)
        add(button);

        // Añadir un ActionListener al botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Pasar al siguiente frame");
            }
        });
    }
}
