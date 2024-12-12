package entidad;

import java.awt.Color;
import java.awt.Graphics2D;

public class BarraSalud {
	public BarraSalud(int saludMax,int saludActual,Graphics2D g1) {
	  int barraSalud = (int) ((double) saludActual / saludMax * 500);
      g1.setColor(Color.RED);
      g1.fillRect(10, 50, 500, 20);
      g1.setColor(Color.GREEN);
      g1.fillRect(10, 50, barraSalud, 20);
	}
}
