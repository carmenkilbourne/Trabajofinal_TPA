package entidad;

public class GestorInteraccionesJugadores{
    private Jugador1 jugador1;
    private Jugador2 jugador2;
    private InputsJugadores inputsJugadores;
    private final int areaEfectividadX = 160;
    private final int areaEfectividadY = 160;

    public GestorInteraccionesJugadores(Jugador1 jugador1, Jugador2 jugador2, InputsJugadores inputsJugadores) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.inputsJugadores = inputsJugadores;
    }

    public void actualizarMovimiento() {
    	if(esEfectivo()) {
        // Jugador 1 realiza ataques
        if (inputsJugadores.getAccionJugador1() == InputsJugadores.Accion.ATAQUE) {
            jugador1.atacar(jugador2);
            inputsJugadores.resetAccionJugador1(); // Resetear acción para evitar múltiples ataques continuos
        }
        // Jugador 2 realiza ataques
        if (inputsJugadores.getAccionJugador2() == InputsJugadores.Accion.ATAQUE) {
            jugador2.atacar(jugador1);
            inputsJugadores.resetAccionJugador2(); // Resetear acción para evitar múltiples ataques continuos
        }
        // Jugador 1 realiza ataques
        if (inputsJugadores.getAccionJugador1() == InputsJugadores.Accion.PATADA) {
            jugador1.atacar(jugador2);
            inputsJugadores.resetAccionJugador1(); // Resetear acción para evitar múltiples ataques continuos
        }
        // Jugador 2 realiza ataques
        if (inputsJugadores.getAccionJugador2() == InputsJugadores.Accion.PATADA) {
            jugador2.atacar(jugador1);
            inputsJugadores.resetAccionJugador2(); // Resetear acción para evitar múltiples ataques continuos
        }
    	}
 // Establecer estado de defensa de los jugadores
    jugador1.setDefendiendo(inputsJugadores.getAccionJugador1() == InputsJugadores.Accion.DEFENSA);
    jugador2.setDefendiendo(inputsJugadores.getAccionJugador2() == InputsJugadores.Accion.DEFENSA);
    }
 
    private boolean esEfectivo() {
        // Calcular las diferencias en las coordenadas X y Y
        int distanciaX = Math.abs(jugador1.getX() - jugador2.getX());	//calculo de la distancia en x
        int distanciaY = Math.abs(jugador1.getY() - jugador2.getY());

        // Verificar si los jugadores están dentro del área de efectividad
        if (distanciaX <= areaEfectividadX && distanciaY <= areaEfectividadY) {
            // Verificar si están mirando el uno al otro
            boolean jugador1MiraJugador2 = jugador1.esDerecha() && jugador1.getX() < jugador2.getX();
            boolean jugador2MiraJugador1 = !jugador2.esDerecha() && jugador2.getX() > jugador1.getX();

            if (jugador1MiraJugador2 || jugador2MiraJugador1) {
                return true; // Los jugadores están dentro del área y se están mirando
            }
        }

        return false; // No cumplen las condiciones de efectividad
    }

}

