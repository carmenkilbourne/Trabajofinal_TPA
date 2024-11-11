package pantallaInicio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
//cambiar nombre a bucle de particula
public class Partida extends JPanel implements Runnable {
	MovimientoJugador movimientojugador = new MovimientoJugador();
	Thread hiloPartida; // empieza el hilo para el loop
	// posicion inicial judaor(rectangulo)
	int posX = 0;
	int posY = 900;
	int desplazamiento = 20;

	int FPS = 60; // 60 FRAMES PER SECOND

	public Partida() {
		this.setPreferredSize(new Dimension(1000, 1000));
		this.setBackground(Color.white);
		this.addKeyListener(movimientojugador);
		this.setFocusable(true);
		// this.setDoubleBuffered(true);
	}

	public void empezarPartida() {
		hiloPartida = new Thread(this);
		hiloPartida.start();
	}

	@Override
	public void run() {
		// Aqui va ha ir nuestro bucle de juego
		// actualizar parametros del personaje con input de usuario
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
		if (movimientojugador.derecha == true) {
			posX = posX + desplazamiento;
		}
		if (movimientojugador.izquierda == true) {
			posX = posX - desplazamiento;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // coge de la clase JPanel
		Graphics2D g1 = (Graphics2D) g;
		g1.setColor(Color.black);
		g1.fillRect(posX, posY, 100, 100);
		g1.dispose();
	}

}
