package pantallaInicio;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovimientoJugador implements KeyListener {
	public boolean derecha, izquierda;

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
	}
}
