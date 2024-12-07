package pantallaInicio;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovimientoJugador2 implements KeyListener {
	public boolean derecha, izquierda,arriba,abajo,atacar,defensa,patada;
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int codigo = e.getKeyCode();
		if (codigo == KeyEvent.VK_J) { // movimiento izq
			izquierda = true;

		}
		if (codigo == KeyEvent.VK_L) { // mov derecha
			derecha = true;
		}
		if (codigo == KeyEvent.VK_I) { // mov arriba
			arriba = true;
		}
		if (codigo == KeyEvent.VK_K) { // mov abajo
			abajo = true;
		}
		if (codigo == KeyEvent.VK_O) { //ataque
            atacar = true;
        }
		if (codigo == KeyEvent.VK_U) { //defensa
			defensa = true;
        }
		if (codigo == KeyEvent.VK_M) { // patada
			patada = true;
        }


	}

	@Override
	public void keyReleased(KeyEvent e) {
		int codigo = e.getKeyCode();
		if (codigo == KeyEvent.VK_J) { // movimiento izq
			izquierda = false;

		}
		if (codigo == KeyEvent.VK_L) { // mov derecha
			derecha = false;
		}
		if (codigo == KeyEvent.VK_I) {  // mov arriba
			arriba = false;
		}
		if (codigo == KeyEvent.VK_K) { // mov abajo
			abajo = false;
		}
		if (codigo == KeyEvent.VK_O) {	//ataque
            atacar = false;
        }
		if (codigo == KeyEvent.VK_U) { //defensa
			defensa = false;
        }
		if (codigo == KeyEvent.VK_M) { // patada
			patada = false;
        }
		
	}
}
