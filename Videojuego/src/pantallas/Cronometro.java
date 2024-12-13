package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Cronometro {
	private int tiempoRestante = 1;
	private int panelWidth;

	public Cronometro(int tiempoRestante, int panelWidth) {
		this.panelWidth = panelWidth;
		this.tiempoRestante = tiempoRestante;
	}
	public void dibujar(Graphics2D g1) {
		g1.setColor(Color.BLACK);
	    g1.setFont(new Font("Arial", Font.BOLD, 30));
	    int tiempo = 60-tiempoRestante;	//si es 0 tambien damos por terminada la partida
	    g1.drawString(tiempo + "s", (panelWidth/ 2)-30, 50+30); 
	}
}