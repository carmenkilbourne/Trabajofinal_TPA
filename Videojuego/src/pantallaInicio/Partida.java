package pantallaInicio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entidad.Jugador;
//cambiar nombre a bucle de particula
public class Partida extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	MovimientoJugador movimientojugador = new MovimientoJugador();
	Thread hiloPartida; // empieza el hilo para el loop
	// posicion inicial judaor(rectangulo)
	Jugador jugador = new Jugador(this,movimientojugador);
	int posX = 0;
	int posY = 620;	//720-100
	int desplazamiento = 20;

	int FPS = 60; // 60 FRAMES PER SECOND
	
	public Partida() {
		this.setPreferredSize(new Dimension(1280, 720));
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
		jugador.update();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // coge de la clase JPanel
		Graphics2D g1 = (Graphics2D) g;
		jugador.draw(g1);
		g1.dispose();
	}

}
