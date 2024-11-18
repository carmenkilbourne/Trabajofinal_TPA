package pantallaInicio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import entidad.Jugador;
import entidad.Jugador2;
//cambiar nombre a bucle de particula
public class Partida extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	MovimientoJugador movimientojugador = new MovimientoJugador();
    MovimientoJugador2 movimientoJugador2 = new MovimientoJugador2();
	Thread hiloPartida; // empieza el hilo para el loop
	Jugador jugador = new Jugador(this,movimientojugador);
    Jugador2 jugador2 = new Jugador2(this, movimientoJugador2);
    private Image fondoPartida;
	int FPS = 60; // 60 FRAMES PER SECOND
    public int areaefectividad = 160; //distancia entre jugadores para que el daño sea efectivo
    
	public Partida() {
		this.setPreferredSize(new Dimension(1280, 720));
		this.setBackground(Color.white);
		this.addKeyListener(movimientojugador);
        this.addKeyListener(movimientoJugador2); 
		this.setFocusable(true);
		// this.setDoubleBuffered(true);\
		 try {
			 fondoPartida = ImageIO.read(getClass().getResourceAsStream("/Imagenes/fondo2.jpg"));
	        } catch (IOException e) {
	            System.err.println("No se pudo cargar el fondo: " + e.getMessage());
	        }
	}

	public void empezarPartida() {
		hiloPartida = new Thread(this);
		hiloPartida.start();
	}

	@Override
	public void run() {// Aqui va ha ir nuestro bucle de juego, actualizar parametros del personaje con input de usuario
		// actualizar graficos
		double intervalo = 1000000000 / FPS; // 0.016s pintamos la pantalla
		double intervalosiguiente = System.nanoTime() + intervalo;

		while (hiloPartida != null) {
			long tiempo = System.nanoTime();
			update();
			repaint();

			try {
				double tiempoSleep = (intervalosiguiente - System.nanoTime()) / 1000000;
				if (tiempoSleep < 0)
					tiempoSleep = 0;
				Thread.sleep((long) (tiempoSleep));// t de sleep en milisegundos
				intervalosiguiente += intervalo;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void update() {
		jugador.update();
		jugador2.update();
		//System.out.println(jugador.getY());
		if(esEfectivo()) {
		 if (movimientojugador.atacar) {
		        jugador.atacar(jugador2);
		        movimientojugador.atacar = false; // reiniciar el ataque para evitar múltiples ataques continuos
		    }
		    // Condición para que el jugador 2 ataque al jugador 1
		    if (movimientoJugador2.atacar) {
		        jugador2.atacar(jugador);
		        movimientoJugador2.atacar = false;
		    }
		 	}
		    jugador.setDefendiendo(movimientojugador.defensa);
		    jugador2.setDefendiendo(movimientoJugador2.defensa);
		    if(jugador.getSaludActual() == 0 || jugador2.getSaludActual() == 0 ) {
		    	System.out.println("Partida terminada, tengo que pasar frame a un frame donde ponga Congratulations al ganador y luego volver al inicio");
		    }
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // coge de la clase JPanel
		Graphics2D g1 = (Graphics2D) g;
		 // Dibujar el fondo
        if (fondoPartida != null) {
            g1.drawImage(fondoPartida, 0, 0, 1280, 720, null);
        }
		jugador.draw(g1);
		jugador2.draw(g1);
		g1.dispose();
	}
	 public boolean esEfectivo() {
		 areaefectividad = Math.abs(jugador.getX()-jugador2.getX());
		 if (areaefectividad <= 160) {
			 return true;
		 }
		 return false;
	 }

}
