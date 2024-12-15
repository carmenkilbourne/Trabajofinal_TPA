package entidad;

public class MovimientoJugador {

    private InputsJugadores inputs;
    private int x;
    private int y;
    private String direccion;
    private boolean esDerecha;
    private boolean saltando;
    private int tiempoSalto = 0;
    private int desplazamiento = 10;
    private int velocidadSalto = 10;
    private int maxAlturaSalto = 100;
    private boolean atacando = false;
    private int contadorAtaque = 0;
    private static final int DURACION_ATAQUE = 10;

    public MovimientoJugador(InputsJugadores inputs, int inicialX, int inicialY, String posInicial) {
        this.inputs = inputs;
        this.x = inicialX;
        this.y = inicialY;
        direccion = posInicial;
    }

    public void update(int panelWidth, int panelHeight, boolean esJugador1) {
        // Movimientos basados en entradas del jugador dependiendo de si se trata del jugador 1 o 2
        InputsJugadores.Accion accion = esJugador1 ? inputs.getAccionJugador1() : inputs.getAccionJugador2();

        if (accion == InputsJugadores.Accion.DERECHA) {
            direccion = "derecha";
            esDerecha = true;
            x += desplazamiento;
            if (x > panelWidth - 200) x = panelWidth - 200;
        }

        if (accion == InputsJugadores.Accion.IZQUIERDA) {
            direccion = "izquierda";
            esDerecha = false;
            x -= desplazamiento;
            if (x < 0) x = 0;
        }

        if (accion == InputsJugadores.Accion.ARRIBA && !saltando) {
            saltando = true;
            tiempoSalto = 0;
        }

        if (saltando) {
            if (tiempoSalto < maxAlturaSalto) {
                y -= velocidadSalto;
                if (y < 120) y = 120; // Limitar de altura máxima
                tiempoSalto += velocidadSalto;
            } else {
                saltando = false;
            }
        }

        if (y < 320 && !saltando) {
            y += velocidadSalto;  // Gravedad(va bajando a una velocidad )
            if (y > 320) y = 320;
        }

        if (accion == InputsJugadores.Accion.ABAJO) {
            direccion = "abajo1";
            y += desplazamiento;
            if (y > 320) y = 320;
        }

        if (accion == InputsJugadores.Accion.ATAQUE && !atacando) {
            atacando = true;
            contadorAtaque = DURACION_ATAQUE;
            direccion = esDerecha ? "ataque1" : "ataque1i"; // Primera fase del ataque
        } else if (accion == InputsJugadores.Accion.PATADA && !atacando) {
            atacando = true;
            contadorAtaque = DURACION_ATAQUE;
            direccion = esDerecha ? "patada1" : "patada1i"; // Primera fase de la patada
        }

        // Actualizar el estado del ataque/patada
        if (atacando) {
            contadorAtaque--;
            if (contadorAtaque > DURACION_ATAQUE / 2) {
                // Primera fase de la animación
                if (direccion.startsWith("ataque")) {
                    direccion = esDerecha ? "ataque1" : "ataque1i";
                } else if (direccion.startsWith("patada")) {
                    direccion = esDerecha ? "patada1" : "patada1i";
                }
            } else {
                // Segunda fase de la animación
                if (direccion.startsWith("ataque")) {
                    direccion = esDerecha ? "ataque12" : "ataque2i";
                } else if (direccion.startsWith("patada")) {
                    direccion = esDerecha ? "patada2" : "patada2i";
                }
            }

            // Terminar el ataque/patada
            if (contadorAtaque <= 0) {
                atacando = false;
                direccion = esDerecha ? "derecha" : "izquierda"; // Regresar a la posición inicial
            }
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public String getDireccion() { return direccion; }
    public boolean esDerecha() {
    	return esDerecha;
    }
    public void setX(int x) {
        this.x = x;
    }

	public void setY(int y) {
		this.y = y;
	}
}