package entidad;

import interfaces.IMovimiento;

public class MovimientoJugador1 implements IMovimiento {
    private Jugador1 jugador1;
    private int desplazamiento = 10; // Valor predeterminado


    public MovimientoJugador1(Jugador1 jugador1) {
        this.jugador1 = jugador1;
    }

	/*
	 * @Override public void moverArriba() { jugador1.setY(jugador1.getY() - 10); //
	 *  }
	 * 
	 * @Override public void moverAbajo() { jugador1.setY(jugador1.getY() + 10); }
	 * 
	 * @Override public void moverIzquierda() { jugador1.setX(jugador1.getX() - 10);
	 * }
	 * 
	 * @Override public void moverDerecha() { jugador1.setX(jugador1.getX() +
	 * desplazamiento); }
	 * 
	 * @Override public void atacar() {  }
	 * 
	 * @Override public void defender() { jugador1.setDefendiendo(true); } public
	 * void setDesplazamiento(int desplazamiento) { this.desplazamiento =
	 * desplazamiento; }
	 */
}
