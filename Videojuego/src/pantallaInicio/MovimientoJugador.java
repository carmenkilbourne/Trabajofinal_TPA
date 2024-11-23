package pantallaInicio;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovimientoJugador implements KeyListener {
	public boolean derecha, izquierda,arriba,abajo,atacar,defensa;
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int codigo = e.getKeyCode();
		if (codigo == KeyEvent.VK_A) { // movimiento izq
			izquierda = true;
		}
		if (codigo == KeyEvent.VK_D) { // mov derecha
			derecha = true;
		}
		if (codigo == KeyEvent.VK_W) { // mov arriba
			arriba = true;
		}
		if (codigo == KeyEvent.VK_S) { // mov abajo
			abajo = true;
		}
		if (codigo == KeyEvent.VK_Q) { // atacar
            atacar = true;
        }
		if (codigo == KeyEvent.VK_E) { // defensa
			defensa = true;
        }


	}

	@Override
	public void keyReleased(KeyEvent e) {
		int codigo = e.getKeyCode();
		if (codigo == KeyEvent.VK_A) { // movimiento izq
			izquierda = false;

		}
		if (codigo == KeyEvent.VK_D) { // mov derecha
			derecha = false;
		}
		if (codigo == KeyEvent.VK_W) {  // mov arriba
			arriba = false;
		}
		if (codigo == KeyEvent.VK_S) { // mov abajo
			abajo = false;
		}
		if (codigo == KeyEvent.VK_Q) {	//atacar
            atacar = false;
        }
		if (codigo == KeyEvent.VK_E) { // defensa
			defensa = false;
        }	
	}
}
