package pantallaInicio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Partida extends JPanel implements Runnable{
	MovimientoJugador movimientojugador = new MovimientoJugador();
	Thread hiloPartida;	//empieza el hilo para el loop
	//posicion inicial judaor(rectangulo)
	int posX = 100;
	int posY = 100;
	int desplazamiento = 500;	
	
	public Partida() {
		this.setPreferredSize(new Dimension(1000,1000));
		this.setBackground(Color.white);
		this.addKeyListener(movimientojugador);
		this.setFocusable(true);
		//this.setDoubleBuffered(true);
	}
	
	public void empezarPartida() {
		hiloPartida.start();
	}
	
	@Override
	public void run() {
		//Aqui va ha ir nuestro bucle de juego
		//actualizar parametros del personaje con input de usuario
		//actualizar graficos
		while(hiloPartida != null) {
			//System.out.println("Bucle de juego activo");
			update();
			repaint();
		}
		
	}
	public void update() {
		if(movimientojugador.derecha == true) {
			posX = posX + desplazamiento;
		}
		if(movimientojugador.izquierda == true) {
			posX = posX-desplazamiento;
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	//coge de la clase JPanel
		Graphics2D g1 = (Graphics2D)g; 
		g1.setColor(Color.black);
		g1.fillRect(posX,posY,100,100);
		g1.dispose();
	}

}
