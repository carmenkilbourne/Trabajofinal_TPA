package pantallas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entidad.GestorInterraccionesJugadores;
import entidad.Jugador1;
import entidad.Jugador2;
import entidad.MovimientoJugador;
import entidad.MovimientoJugador2;
import pantallas.Controlador.CHOICEP1;
import pantallas.Controlador.CHOICEP2;

//cambiar nombre a bucle de particula
public class Partida extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	MovimientoJugador movimientojugador = new MovimientoJugador();
	MovimientoJugador2 movimientoJugador2 = new MovimientoJugador2();
	Thread hiloPartida; // empieza el hilo para el loop
	Jugador1 jugador = new Jugador1(this, movimientojugador);
	Jugador2 jugador2 = new Jugador2(this, movimientoJugador2);
	private int contador = 0;
	private int c = 0;
	private int tiempoRestante = 1;
	public boolean acabada = false;
	public GestorInterraccionesJugadores gestorJugador;	
	int FPS = 60; // 60 FRAMES PER SECOND
	public long tiempo = 0;
	private boolean isRunning;
	private Image fondoPartida;

	public Partida(String path, CHOICEP1 choiceP1, CHOICEP2 choiceP2) { // PARA QUE PONGA DISTINTOS FONDOS SOLO HACE FALTA HACER public Partida(string
		this.setPreferredSize(new Dimension(1280, 720));
		this.setBackground(Color.white);
		this.addKeyListener(movimientojugador);	//escuchador de movimiento del jugador 1
		this.addKeyListener(movimientoJugador2); //escuchador de movimiento del jugador 2
		this.setFocusable(true);
		CargarImagenes fondo = new CargarImagenes(path);
		fondoPartida = fondo.getGrafico();		
	}


	public void empezarPartida() {
		hiloPartida = new Thread(this);
		hiloPartida.start();
		gestorJugador = new GestorInterraccionesJugadores(jugador, jugador2, movimientojugador, movimientoJugador2);
	}
	public void terminarPartida() {
		hiloPartida = null;
	}

	@Override
	public void run() {// Aqui va ha ir nuestro bucle de juego, actualizar parametros del personaje con
						// input de usuario
		// actualizar graficos
		double intervalo = 1000000000 / FPS; // 0.016s pintamos la pantalla
		double intervalosiguiente = System.nanoTime() + intervalo;
		while (hiloPartida != null) {
			tiempo = System.nanoTime();
			gestorJugador = new GestorInterraccionesJugadores(jugador, jugador2, movimientojugador, movimientoJugador2);

			update();
			repaint();
			contador++;

			try {
				double tiempoSleep = (intervalosiguiente - System.nanoTime()) / 1000000;
				if (tiempoSleep < 0)
					tiempoSleep = 0;
				Thread.sleep((long) (tiempoSleep));// t de sleep en milisegundos
				if (contador >= 63) { // 0.016x62.5 = 1 segundo
					contador = 0;
					c++;
				}
				intervalosiguiente += intervalo;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (tiempoRestante == 0) { // Fin de la partida
				terminarPartida();
			}
		}

	}

	public void update() {
		jugador.update();
		jugador2.update();
		gestorJugador.actualizarMovimiento();
		if (gestorJugador.partidaAcabada()) {
			hiloPartida = null;
			Controlador.getInstance().cambiarPantalla("SeleccionCaracteres");

			System.out.println(
					"Partida terminada, tengo que pasar frame a un frame donde ponga Congratulations al ganador y luego volver al inicio");
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // coge de la clase JPanel
		Graphics2D g1 = (Graphics2D) g;
		// Dibujar el fondo
		int panelWidth = this.getWidth();
		int panelHeight = this.getHeight();
		if (fondoPartida != null) {
			g1.drawImage(fondoPartida, 0, 0, panelWidth, panelHeight, null); // CAMBIAR A size DINAMICO
		}
		jugador.draw(g1);
		jugador2.draw(g1);
		g1.setColor(Color.BLACK);
	    g1.setFont(new Font("Arial", Font.BOLD, 30));
	    tiempoRestante = 60-c;	//si es 0 tambien damos por terminada la partida
	    g1.drawString(tiempoRestante + "s", (panelWidth/ 2)-30, 50+30); 
		g1.dispose();
	}

	public int getPanelHeight() {
		return this.getHeight();
	}

	public int getPanelWidth() {
		return this.getWidth();
	}

	public int getTiempoRestante() {
		return c;
	}
	protected static Partida getPartida() {
		return getPartida();
	}
}
