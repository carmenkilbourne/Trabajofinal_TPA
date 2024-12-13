package entidad;

import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.Color;
import java.awt.Graphics2D;

public class BarraSalud {
    private int x, y, ancho, alto;
    private int saludMax;

    public BarraSalud( int saludMax,int x, int y) {
    	this.x = x;
    	this.y = y;
  
        this.saludMax = saludMax;
    }

    public void dibujar(Graphics2D g, int saludActual) {
        int barraSalud = (int) ((double) saludActual / saludMax * 500);
        
        // Dibujar la barra de fondo (roja)
        g.setColor(Color.RED);
        g.fillRect(x, y, 500, 20);
        
        // Dibujar la barra de salud actual (verde)
        g.setColor(Color.GREEN);
        g.fillRect(x, y, barraSalud, 20);
    }
}
