package entidad;

import java.awt.Image;

import pantallas.Controlador;

public class GestorInterraccionesJugadores {
    private Jugador1 jugador1;
    private Jugador2 jugador2;
    InputsJugadores inputsJugador1 = new InputsJugadores();
    InputsJugadores movimientoJugador2 = new InputsJugadores();
    private int areaEfectividad = 160;
    private int areaEfectividady = 160;


    public GestorInterraccionesJugadores(Jugador1 jugador1, Jugador2 jugador2,InputsJugadores inputsJugador1,InputsJugadores movimientoJugador2 ) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.inputsJugador1 = inputsJugador1;
        this.movimientoJugador2 = movimientoJugador2;
    }

    public void actualizarMovimiento() {
        if (esEfectivo()) {
            // Jugador 1 realiza ataques y patadas
            if (inputsJugador1.getAccionJugador1() == InputsJugadores.Accion.ATAQUE) {
                jugador1.atacar(jugador2);
                inputsJugador1.getAccionJugador1(); // Resetear acción para evitar múltiples ataques continuos
            }
            if (inputsJugador1.getAccionJugador1() == InputsJugadores.Accion.PATADA) {
                jugador1.atacar(jugador2);
                inputsJugador1.getAccionJugador1(); // Resetear acción para evitar múltiples ataques continuos
            }

          //if (movimientoJugador2.patada) {
			//jugador1.atacar(jugador1);
			//movimientoJugador2.patada = false; // reiniciar el ataque para evitar múltiples ataques continuos
		//}
          //if (movimientoJugador2.atacar) {
			//jugador2.atacar(jugador1);
			//movimientoJugador2.atacar = false;
		//}
        }
        
        // Establecer estado de defensa de los jugadores
        jugador1.setDefendiendo(inputsJugador1.getAccionJugador1() == InputsJugadores.Accion.DEFENSA);
        //jugador2.setDefendiendo(inputsJugador2.getCurrentActionPlayer2() == InputsJugadores.Accion.DEFENSA);
        
        // Verificar si la partida ha terminado
        partidaAcabada();
    }


    public boolean esEfectivo() {
    	areaEfectividad = Math.abs(jugador1.getX()-jugador2.getX());
    	areaEfectividady = Math.abs(jugador1.getY()-jugador2.getY());
		 if (areaEfectividad <= 160 && areaEfectividady == 0) {

			 //comprobar la direccion
			// if ((jugador1.esDerecha() && jugador1.getX() < jugador2.getX() || 
			     //    !jugador1.esDerecha() && jugador1.getX() > jugador2.getX()) && 
			     //   (jugador2.esDerecha() && jugador2.getX() < jugador1.getX() || 
			       //  !jugador2.esDerecha() && jugador2.getX() > jugador1.getX())) 
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

