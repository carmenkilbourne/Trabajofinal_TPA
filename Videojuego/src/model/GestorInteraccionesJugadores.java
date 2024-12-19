package model;

import controlador.InputsJugadores;
import controlador.InputsJugadores.Accion;

/**
 * Clase GestorInteraccionesJugadores que va ha gestionar las interacciones
 * entre ambos jugadores.
 */
public class GestorInteraccionesJugadores implements IGestorInteraccionesJugadores {
	private Jugador1 jugador1;
	private Jugador2 jugador2;
	private InputsJugadores inputsJugadores;
	private final int areaEfectividadX = 160;
	private final int areaEfectividadY = 160;
	private final int distanciaMinima = 50; // Distancia mínima para evitar colisiones

	/**
	 * Constructor de la clase GestorInteraccionesJugadores. Instanciar la clase con
	 * los parametros necesarios para gestionar
	 * las interacciones entre los usuarios.
	 * 
	 * @param jugador1
	 * @param jugador2
	 * @param inputsJugadores
	 */
	public GestorInteraccionesJugadores(Jugador1 jugador1, Jugador2 jugador2, InputsJugadores inputsJugadores) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.inputsJugadores = inputsJugadores;
	}

	/**
	 * Metodo que actualiza el movimiento de los jugadores dependiendo de si estan
	 * colisionando o de si estan atacandose o de si se estan defendiendo.
	 */
	public void actualizarMovimiento() {
		if (esEfectivo()) {
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
		evitarColisiones();
	}

	/**
	 * Método que determina si un ataque es o no es efectivo dependiendo de la
	 * distancia que separa ambos jugadores o de si el jugador que ataca esta
	 * mirando en la direccion del oponente.
	 * 
	 * @return true si es efectivo y false si no es efectivo.
	 */
	private boolean esEfectivo() {
		// Calcular las diferencias en las coordenadas X y Y
		int distanciaX = Math.abs(jugador1.getX() - jugador2.getX());
		int distanciaY = Math.abs(jugador1.getY() - jugador2.getY());

		// Verificar si los jugadores están dentro del área de efectividad
		if (distanciaX <= areaEfectividadX && distanciaY <= areaEfectividadY) {
			// Verificar si están mirando el uno al otro
			boolean jugador1MiraJugador2 = jugador1.esDerecha() && jugador1.getX() < jugador2.getX();
			boolean jugador2MiraJugador1 = !jugador2.esDerecha() && jugador2.getX() > jugador1.getX();

			// Verificar si están mirando en la dirección correcta
			boolean mirandoCorrectamente = (jugador1MiraJugador2 || jugador2MiraJugador1)
					|| (!jugador1.esDerecha() && jugador1.getX() > jugador2.getX())
					|| (jugador2.esDerecha() && jugador2.getX() < jugador1.getX());

			if (mirandoCorrectamente) {
				return true; // Los jugadores están dentro del área y se están mirando correctamente
			}
		}

		return false; // No cumplen las condiciones de efectividad
	}

	/**
	 * Método para evitar colisiones que se basa en empujar al jugador contrario
	 * para que los jugadores no entren en contacto.
	 */
	private void evitarColisiones() { // se empuja al otro jugador si entra dentro del rango del jugador contrario
		int distanciaX = Math.abs(jugador1.getX() - jugador2.getX());
		int distanciaY = Math.abs(jugador1.getY() - jugador2.getY());

		if (distanciaX <= distanciaMinima && distanciaY == 0) {
			// Ajustar posiciones para evitar colisión
			if (jugador1.getX() < jugador2.getX()) {
				jugador1.setX(jugador1.getX() - distanciaMinima);
				jugador2.setX(jugador2.getX() + distanciaMinima);
			} else {
				jugador1.setX(jugador1.getX() + distanciaMinima);
				jugador2.setX(jugador2.getX() - distanciaMinima);
			}
		}
	}
}
