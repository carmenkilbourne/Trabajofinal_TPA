package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
public class Cronometro {
    private int tiempoRestante =1;
    private int tiempoInicial;
    private int tiempo = 0;
    private boolean isRunning = false;
    public Cronometro(int tiempoInicial) {
        this.tiempoInicial = tiempoInicial;
        isRunning=true;
    }

    public void actualizar() {
        if (tiempoRestante > 0 && isRunning == true) {
            tiempoRestante--;
        }
    }
    public void update() {
    	tiempo ++;
    }

    public void dibujar(Graphics2D g1) {
        g1.setColor(Color.BLACK);
        g1.setFont(new Font("Arial", Font.BOLD, 30));
        tiempoRestante = tiempoInicial-tiempo;
        int posX = (1280 - 50) / 2; // Coordenada X centrada
        int posY = (720 + 30) / 2;  // Coordenada Y centrada 
        g1.drawString(tiempoRestante + "s",posX,50);
    }

    public boolean esTiempoAgotado() {
        return tiempoRestante <= 0;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }
    void pararContador() {
    	isRunning = false;
    }
}
