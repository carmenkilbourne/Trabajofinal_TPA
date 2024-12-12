package entidad;

public class GestorInteraccionesJugadores{
    private Jugador1 jugador1;
    private Jugador2 jugador2;
    private InputsJugadores inputsJugador1;
    private InputsJugadores inputsJugador2;
    private final int areaEfectividadX = 160;
    private final int areaEfectividadY = 160;

    public GestorInteraccionesJugadores(Jugador1 jugador1, Jugador2 jugador2, InputsJugadores inputsJugador1, InputsJugadores inputsJugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.inputsJugador1 = inputsJugador1;
        this.inputsJugador2 = inputsJugador2;
    }

    public void actualizarMovimiento() {
        // Jugador 1 realiza ataques
        if (inputsJugador1.getAccionJugador1() == InputsJugadores.Accion.ATAQUE) {
            jugador1.atacar(jugador2);
            inputsJugador1.resetAccionJugador1(); // Resetear acción para evitar múltiples ataques continuos
        }
        // Jugador 2 realiza ataques
        if (inputsJugador2.getAccionJugador2() == InputsJugadores.Accion.ATAQUE) {
            jugador2.atacar(jugador1);
            inputsJugador2.resetAccionJugador2(); // Resetear acción para evitar múltiples ataques continuos
        }

 // Establecer estado de defensa de los jugadores
    jugador1.setDefendiendo(inputsJugador1.getAccionJugador1() == InputsJugadores.Accion.DEFENSA);
    jugador2.setDefendiendo(inputsJugador2.getAccionJugador2() == InputsJugadores.Accion.DEFENSA);
    }
 
    private boolean esEfectivo() {
        
        return true;
    }

}

