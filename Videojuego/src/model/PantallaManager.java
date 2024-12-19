package model;

import javax.swing.JFrame;
import view.FondoPantalla;
import view.Partida;

public class PantallaManager {
    private JFrame frame;
    private FondoPantalla fondoPantalla;

    public PantallaManager(JFrame frame) {
        this.frame = frame;
    }

    public void actualizarFondo(String nombrePantalla, int mapa) {
        System.out.println("actualizarFondo llamado con nombrePantalla: " + nombrePantalla + ", mapa: " + mapa);
        String path = "";
        switch (nombrePantalla) {
            case "PantallaInicio":
                System.out.println("Caso PantallaInicio");
                path = "/Imagenes/PantallaInicio.png";
                fondoPantalla = new FondoPantalla(path);
                frame.setContentPane(fondoPantalla);
                frame.revalidate();
                frame.setResizable(true);
                break;
            case "SeleccionCaracteres":
                System.out.println("Caso SeleccionCaracteres");
                path = "/Imagenes/Fondos/seleccion_personajes.png";
                fondoPantalla = new FondoPantalla(path);
                frame.setContentPane(fondoPantalla);
                frame.revalidate();
                frame.setResizable(true);
                break;
            case "SeleccionMapa":
                System.out.println("Caso SeleccionMapa");
                path = "/Imagenes/Fondos/seleccion_mapa.png";
                fondoPantalla = new FondoPantalla(path);
                frame.setContentPane(fondoPantalla);
                frame.revalidate();
                frame.setResizable(true);
                break;
            case "PantallaPelea":
                System.out.println("Caso PantallaPelea");
                switch (mapa) {
                    case 1:
                        System.out.println("Mapa 1 seleccionado: Montana");
                        path = "/Imagenes/Mapas/Montana.jpg";
                        break;
                    case 2:
                        System.out.println("Mapa 2 seleccionado: Jungla");
                        path = "/Imagenes/Mapas/Jungla.jpg";
                        break;
                    case 3:
                        System.out.println("Mapa 3 seleccionado: BoxingRing");
                        path = "/Imagenes/Mapas/BoxingRing.png";
                        break;
                    case 4:
                        System.out.println("Mapa 4 seleccionado: Candyland");
                        path = "/Imagenes/Mapas/Candyland.jpg";
                        break;
                    default:
                        System.out.println("Mapa escogido incorrectamente");
                        return;
                }
                frame.setVisible(false);
                frame = new JFrame("Pantalla de Pelea");
                System.out.println("Mapa: " + mapa);
                frame.setSize(1280, 720);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                Partida partida = new Partida(path, Controlador.choiceP1, Controlador.choiceP2);
                frame.add(partida);
                partida.empezarPartida();
                if (partida.esPartidaTerminada()) {
                    System.out.println("Partida terminada, volviendo a PantallaInicio");
                    actualizarFondo("PantallaInicio", 0);
                }
                frame.pack();
                frame.setVisible(true);
                frame.setResizable(true);
                break;
            default:
                System.out.println("Pantalla escogida incorrectamente: " + nombrePantalla);
                break;
        }
    }
}