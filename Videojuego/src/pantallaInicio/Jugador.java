package pantallaInicio;

import java.awt.Graphics2D;

public interface Jugador {
	int getAtaque();	//obtiene la fuerza del ataque
	int getSaludActual();	//obtiene el nivel de vida
	void update();
	void getImagenJugador();
	void draw(Graphics2D g1); 
	void setDefendiendo(boolean defendiendo);
	void recibirDanio(int cantidad);
}
