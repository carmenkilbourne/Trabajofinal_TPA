package entidad;

import java.awt.Image;

import pantallas.Controlador;

public class GestorInterraccionesJugadores {
    private Jugador1 jugador1;
    private Jugador2 jugador2;
    MovimientoJugador movimientojugador = new MovimientoJugador();
    MovimientoJugador2 movimientoJugador2 = new MovimientoJugador2();
    private int areaEfectividad = 160;
    private int areaEfectividady = 160;


    public GestorInterraccionesJugadores(Jugador1 jugador1, Jugador2 jugador2,MovimientoJugador movimientojugador,MovimientoJugador2 movimientoJugador2 ) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.movimientojugador = movimientojugador;
        this.movimientoJugador2 = movimientoJugador2;
    }

    public void actualizarMovimiento() {
		if (esEfectivo()) {
			if (movimientojugador.atacar) {
				jugador1.atacar(jugador2);
				movimientojugador.atacar = false; // reiniciar el ataque para evitar múltiples ataques continuos
			}
			// Condición para que el jugador 2 ataque al jugador 1
			//if (movimientoJugador2.atacar) {
				//jugador2.atacar(jugador1);
				//movimientoJugador2.atacar = false;
			//}
			if (movimientojugador.patada) {
				jugador1.atacar(jugador2);
				movimientojugador.patada = false; // reiniciar el ataque para evitar múltiples ataques continuos
			}
			//if (movimientoJugador2.patada) {
				//jugador1.atacar(jugador1);
				//movimientoJugador2.patada = false; // reiniciar el ataque para evitar múltiples ataques continuos
			//}
		}
		jugador1.setDefendiendo(movimientojugador.defensa);
		jugador2.setDefendiendo(movimientoJugador2.defensa);
		partidaAcabada();
    }

    public boolean esEfectivo() {
    	areaEfectividad = Math.abs(jugador1.getX()-jugador2.getX());
    	areaEfectividady = Math.abs(jugador1.getY()-jugador2.getY());
		 if (areaEfectividad <= 160 && areaEfectividady == 0) {

			 //comprobar la direccion
			 if ((jugador1.esDerecha() && jugador1.getX() < jugador2.getX() || 
			         !jugador1.esDerecha() && jugador1.getX() > jugador2.getX()) && 
			        (jugador2.esDerecha() && jugador2.getX() < jugador1.getX() || 
			         !jugador2.esDerecha() && jugador2.getX() > jugador1.getX())) 
			 return true;
		 }
		 //1 esta hacia la derecha y el jugador 2 tiene que estar a la derecha del jugador
		 //

		 return false;
	 }

    public boolean partidaAcabada() {	//metodo que devuelve true si la partida ha acabado
        return jugador1.getSaludActual() == 0 || jugador2.getSaludActual() == 0;
    }
}

