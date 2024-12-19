package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controlador.InputsJugadores;
import model.Controlador;
import model.Cronometro;
import model.GestorInteraccionesJugadores;
import model.Jugador1;
import model.Jugador2;
import model.Controlador.CHOICEP1;
import model.Controlador.CHOICEP2;
import model.Controlador.STATE;

/**
 *  Clase Partida que representa el juego principal, tiene toda la lógica de movimiento, 
 *  gestión entre jugadores,cronometro.
 *  Implementa un patrón de comportamiento Observer ya que tiene un KeyListener.
 *  Implementa un patrón Composite ya que permite componer objetos en estructuras de árbol 
 *  y trabaja con estructuras como si fueran objetos individuales.
 *  
 *  
 */
public class Partida extends JPanel implements Runnable,KeyListener, IPartida {
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
	      
	    }
	/**
	 * Constructor de la clase Partida para instanciar la clase con los parametros
	 * necesarios para jugar una partida.
	 * @param path ruta del fondo de pantalla
	 * @param choiceP1 elección del personaje del Jugador1
	 * @param choiceP2 elección del personaje del Jugador1
	 */
	public Partida(String path, CHOICEP1 choiceP1, CHOICEP2 choiceP2) { 
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

	/**
	 * Método para empezar partida.
	 */
	@Override
	public void empezarPartida() {
		hiloPartida = new Thread(this);
		hiloPartida.start();
		gestorJugador = new GestorInteraccionesJugadores(jugador, jugador2, movimientojugador);
		isRunning = true;
	}

	/**
	 * Método para terminar partida y si es la ultima ronda se declara el ganador y pasa a la  pantalla del ganador.
	 */
	@Override
	public void terminarPartida() {
	    isRunning = false;

	    // Determinar el ganador de la ronda actual
	    if (jugador.getSaludActual() > 0) {
	        //System.out.println("Ganador de la ronda: Jugador 1");
	        Controlador.incrementarVictoriasJugador1();  // Incrementar victorias del jugador 1
	    } else {
	       // System.out.println("Ganador de la ronda: Jugador 2");
	        Controlador.incrementarVictoriasJugador2();  // Incrementar victorias del jugador 2
	    }

	   
	    Controlador.rondaActual++; // Actualizar el estado de las rondas

	    if (Controlador.rondaActual < Controlador.MAX_RONDAS) {
	        
	        reiniciarPartida();// Si no es la tercera ronda, reiniciar la partida para la siguiente ronda
	    } else if (Controlador.rondaActual == Controlador.MAX_RONDAS) {
		    JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		    if (mainFrame != null) {
		        mainFrame.dispose();  // Cierra el JFrame completamente
		    }
	        // Si es la tercera ronda, mostrar el ganador final
	        //System.out.println("Juego terminado. Ganador final: " + getGanadorFinal());
	        Controlador stateControlador = Controlador.getInstance();
	        if (stateControlador != null) {
	            stateControlador.mostrarPantallaGanador(getGanadorFinal());
	        }
	    }
	}


	/**
	 * Metodo para reiniciar la partida donde se reinicia todos los parametros para volver a empezar ronda.
	 */
	private void reiniciarPartida() {
	    // Reiniciar salud de los jugadores
	    jugador.resetSalud();
	    jugador2.resetSalud();
	    // Reiniciar el cronómetro
	    cronometro.reiniciar();
	    // Resetear las posiciones de los jugadores
	    jugador.reiniciarPosicion();
	    jugador2.reiniciarPosicion();
	    // Volver a activar la ejecución del loop
	    isRunning = true;
	    empezarPartida();
	}

	/**
	 * Método que devuelve el ganador de la ronda.
	 * @return un string con el ganador.
	 */
	@Override
	public String getGanador() {
	    // Determina quién ganó más rondas
	    if (jugador.getSaludActual() > 0) {
	        return "Jugador 1";
	    } else {
	        return "Jugador 2";
	    }
	}
	/**
	 *Método run que implementa el bucle del juego, actualiza parametros de los jugadores, cronometro y 
	 *pintar la pantalla.
	 */
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

	/**
	 * Método update que actualiza toda la lógica de los jugadores, las interracciones entre ellos
	 * y ver si los jugadores han perdido toda su vida para terminar partida.
	 */
	@Override
	public void update() {
		jugador.update();
		jugador2.update();
		gestorJugador.actualizarMovimiento();
		if (jugador.getSaludActual() == 0 || jugador2.getSaludActual() == 0) {
			isRunning = false;
			terminarPartida();
		}
		
	}

	/**
	 *Método paintComponent encargado de pintar los elementos gráficos del juego, como el fondo y los jugadores.
	 */
	@Override
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
		cronometro.dibujar(g1,getPanelWidth());
		g1.dispose();

	}
	/**
     * Devuelve la altura del panel de la partida.
     * 
     * @return La altura del panel.
     */
	@Override
	public int getPanelHeight() {
		return this.getHeight();
	}
	/**
     * Devuelve el ancho del panel de la partida.
     * 
     * @return El ancho del panel.
     */
	@Override
	public int getPanelWidth() {
		return this.getWidth();
	}

	/**
	 * Devuelve la instancia de una partida.
	 * @return instancia de la partida.
	 */
	protected static IPartida getPartida() {
		return getPartida();
	}
	  /**
     * Verifica si la partida ha terminado.
     * 
     * @return true si la partida ha terminado, false en caso contrario.
     */
	@Override
	public boolean esPartidaTerminada() {
		return !isRunning;
	}
	/**
	 *No uso keyTyped ya que estamos implementando la interfaz del Key Listener.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 *No uso keyReleased ya que estamos implementando la interfaz del Key Listener.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Devuelve el jugador que ha ganado la ronda.
	 * @return ganador de la ronda.
	 */
	private String getGanadorFinal() {
        if (Controlador.victoriasJugador1 > Controlador.victoriasJugador2) {
            return "Jugador 1";
        } else if (Controlador.victoriasJugador2 > Controlador.victoriasJugador1) {
            return "Jugador 2";
        } else {
            return "¡Es un empate!";
        }
    }

}

