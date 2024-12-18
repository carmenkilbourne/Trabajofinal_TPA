package pantallas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import entidad.GestorInteraccionesJugadores;
import entidad.InputsJugadores;
import entidad.Jugador1;
import entidad.Jugador2;
import pantallas.Controlador.CHOICEP1;
import pantallas.Controlador.CHOICEP2;
import pantallas.Controlador.STATE;

//cambiar nombre a bucle de particula
public class Partida extends JPanel implements Runnable,KeyListener {
	private static final long serialVersionUID = 1L;
	InputsJugadores movimientojugador = new InputsJugadores();
	//InputsJugadores movimientoJugador2 = new InputsJugadores();
	Thread hiloPartida; // empieza el hilo para el loop
	Jugador1 jugador;
	Jugador2 jugador2;
	private int contador = 0;
	public GestorInteraccionesJugadores gestorJugador;
	int FPS = 60; // 60 FRAMES PER SECOND
	public long tiempo = 0;
	private boolean isRunning;
	private Image fondoPartida;
	private Cronometro cronometro;
	  @Override
	    public void keyPressed(KeyEvent e) {
	        int keyCode = e.getKeyCode();
	        if (keyCode == KeyEvent.VK_ESCAPE) {
	            System.out.println("Escape key pressed");
	            Controlador controlador = new Controlador();
	    		controlador.cambiarPantalla("PantallaInicio");
	        }
	    }
	public Partida(String path, CHOICEP1 choiceP1, CHOICEP2 choiceP2) { // PARA QUE PONGA DISTINTOS FONDOS SOLO HACE
																		// FALTA HACER public Partida(string
		this.setPreferredSize(new Dimension(1280, 720));
		this.setBackground(Color.white);
		this.addKeyListener(movimientojugador); // escuchador de movimiento del jugador 1
		this.addKeyListener(movimientojugador); // escuchador de movimiento del jugador 2
		this.setFocusable(true);
		jugador2 = new Jugador2(this, movimientojugador, choiceP2.name().toLowerCase());
		jugador = new Jugador1(this, movimientojugador, choiceP1.name().toLowerCase());
		CargarImagenes fondo = new CargarImagenes(path);
		fondoPartida = fondo.getGrafico();
		cronometro = new Cronometro(60);
		isRunning = true;
	}

	public void empezarPartida() {
		hiloPartida = new Thread(this);
		hiloPartida.start();
		gestorJugador = new GestorInteraccionesJugadores(jugador, jugador2, movimientojugador);
		isRunning = true;
	}
	public void pausarPartida() {
		//parar el contador 
		//
	}
	public void terminarPartida() {
		hiloPartida = null;
		isRunning = false;
		// Hay que tener en el controlador una clase que a parte de cambiar pantalla
		// haga algo como dibujarla de nuevo??'
		Controlador controlador = new Controlador();
		controlador.cambiarPantalla("PantallaInicio");
	}

	@Override
	public void run() {// Aqui va ha ir nuestro bucle de juego, actualizar parametros del personaje con
						// input de usuario
		// actualizar graficos
		double intervalo = 1000000000 / FPS; // 0.016s pintamos la pantalla
		double intervalosiguiente = System.nanoTime() + intervalo;
		while (hiloPartida != null) {
			tiempo = System.nanoTime();
			gestorJugador = new GestorInteraccionesJugadores(jugador, jugador2, movimientojugador);

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
					cronometro.update();
				}
				intervalosiguiente += intervalo;
				if (cronometro.esTiempoAgotado()) {
					isRunning = false;
					terminarPartida();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void update() {
		jugador.update();
		jugador2.update();
		gestorJugador.actualizarMovimiento();
		if (jugador.getSaludActual() == 0 || jugador2.getSaludActual() == 0) {
			isRunning = false;
			terminarPartida();

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
		cronometro.dibujar(g1);
		g1.dispose();

	}

	public int getPanelHeight() {
		return this.getHeight();
	}

	public int getPanelWidth() {
		return this.getWidth();
	}

	protected static Partida getPartida() {
		return getPartida();
	}

	public boolean esPartidaTerminada() {// si tengo en el controlador algo que escucha hasta que este parametro sea
											// false
		return !isRunning;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
