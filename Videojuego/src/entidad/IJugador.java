package entidad;

import java.awt.Graphics2D;

public interface IJugador {
	int getAtaque();	//obtiene la fuerza del ataque
	int getSaludActual();	//obtiene el nivel de vida
	void update();
	void draw(Graphics2D g1); 
	void setDefendiendo(boolean defendiendo);
	void recibirDanio(int cantidad);
}
