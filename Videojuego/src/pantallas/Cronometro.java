package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
public class Cronometro {
    private int tiempoRestante =1;
    private int tiempoInicial;
    private int panelWidth;
    private int tiempo = 0;
    
    public Cronometro(int tiempoInicial, int panelWidth) {
        this.tiempoInicial = tiempoInicial;
        this.panelWidth = panelWidth;
    }

    public void actualizar() {
        if (tiempoRestante > 0) {
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
        int posY = (720 + 30) / 2;  // Coordenada Y centrada (baseline)
        g1.drawString(tiempoRestante + "s",posX,50);
    }

    public boolean esTiempoAgotado() {
        return tiempoRestante <= 0;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }
}
