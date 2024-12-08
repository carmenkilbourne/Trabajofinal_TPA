package pantallas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class MouseInput implements MouseListener {
    private JFrame frame;

    // Ajustar el botón a las coordenadas y tamaño especificados
    public Rectangle backButton = new Rectangle(34, 67, 25, 14); // X=34, Y=67, W=25, H=14

    public MouseInput(JFrame frame) {
        this.frame = frame;
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(backButton);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        System.out.println("Mouse pressed at: (" + mx + ", " + my + ")");

            if (Controlador.state == Controlador.STATE.CHARSEL1) {
            System.out.println("Current state: CHARSEL1");
            if (mx < frame.getWidth() / 2) {
                System.out.println("Left side clicked: Gigante selected");
                Controlador.choiceP1 = Controlador.CHOICEP1.GIGANTE1;
            } else {
                System.out.println("Right side clicked: Hada selected");
                Controlador.choiceP1 = Controlador.CHOICEP1.HADA1;
            }
            // Cambiar a selección de personaje 2
            Controlador.state = Controlador.STATE.CHARSEL2;
            Controlador controlador = Controlador.getInstance();
            if (controlador != null) {
                controlador.cambiarPantalla("SeleccionCaracteres");
                System.out.println("State changed to: CHARSEL2");
            } else {
                System.out.println("Controlador instance is null");
            }
        } else if (Controlador.state == Controlador.STATE.CHARSEL2) {
            System.out.println("Current state: CHARSEL2");
            if (mx < frame.getWidth() / 2) {
                System.out.println("Left side clicked: Gigante selected");
                Controlador.choiceP2 = Controlador.CHOICEP2.GIGANTE2;
            } else {
                System.out.println("Right side clicked: Hada selected");
                Controlador.choiceP2 = Controlador.CHOICEP2.HADA2;
            }
            // Cambiar a la selección de mapa
            Controlador.state = Controlador.STATE.CHOOSE;
            Controlador controlador = Controlador.getInstance();
            if (controlador != null) {
                controlador.cambiarPantalla("SeleccionMapa");
                System.out.println("State changed to: CHOOSE");
            } else {
                System.out.println("Controlador instance is null");
            }
        } else if (Controlador.state == Controlador.STATE.CHOOSE) {
            System.out.println("Current state: CHOOSE");
            int width = frame.getWidth();
            int height = frame.getHeight();
            if (mx < width / 2 && my < height / 2) {
                System.out.println("Top-left quadrant clicked: Map 1 selected");
                Controlador.mapa = 1;
            } else if (mx >= width / 2 && my < height / 2) {
                System.out.println("Top-right quadrant clicked: Map 2 selected");
                Controlador.mapa = 2;
            } else if (mx < width / 2 && my >= height / 2) {
                System.out.println("Bottom-left quadrant clicked: Map 3 selected");
                Controlador.mapa = 3;
            } else if (mx >= width / 2 && my >= height / 2) {
                System.out.println("Bottom-right quadrant clicked: Map 4 selected");
                Controlador.mapa = 4;
            }
            // Cambiar al estado del juego
            Controlador.state = Controlador.STATE.GAME;
            Controlador controlador = Controlador.getInstance();
            if (controlador != null) {
                controlador.cambiarPantalla("Game");
                System.out.println("State changed to: GAME");
            } else {
                System.out.println("Controlador instance is null");
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}