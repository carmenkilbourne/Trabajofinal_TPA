package pantallas;

import entidad.Jugador1;
import entidad.Jugador2;
/*Clase encargada de dibujar a ambos jugadores en la pantalla*/
public class PantallaPartida implements IPantalla{
	  private final Jugador1 jugador1;
	  private final Jugador2 jugador2;


  public PantallaPartida(Jugador1 jugador1,Jugador2 jugador2) {
  	 this.jugador1 = jugador1;
  	 this.jugador2 = jugador2;
  }
  @Override
  public void update() {
     
  }
	@Override
	public void render() {	//metodo en el que voy a coger parametros pasados de los jugadores
		
	}
  
}