package entidad;

import java.awt.Graphics2D;

public interface IJugador {

	void update();

	void draw(Graphics2D g1);

	int getSaludActual();

	int getSaludMaxima();

	void setDefendiendo(boolean defendiendo);

	boolean esDerecha();

}