package entidad;

public class MovimientoJugador2 {
    private int x, y;
    private boolean saltando = false;
    private int tiempoSalto = 0;
    private final int maxAlturaSalto = 100;
    private final int velocidadSalto = 10;
    private final int desplazamiento = 10;
    private boolean atacando = false;
    private int contadorAtaque = 0;
    private final int DURACION_ATAQUE = 10;
    private boolean esDerecha = true;
    private String direccion;

    private InputsJugadores inputs;

    public MovimientoJugador2(InputsJugadores inputs, int inicialX, int inicialY) {
        this.inputs = inputs;
        this.x = inicialX;  // Inicializar x
        this.y = inicialY;  // Inicializar y
        setVariables();
    }

    public void setVariables() {
        direccion = "izquierda";
    }
    public void update(int panelWidth, int panelHeight) {
        // Movimientos basados en entradas del jugador
        if (inputs.getAccionJugador2() == InputsJugadores.Accion.DERECHA) {
            direccion = "derecha";
            esDerecha = true;
            x += desplazamiento;
            if (x > panelWidth - 200) x = panelWidth - 200;
        }

        if (inputs.getAccionJugador2() == InputsJugadores.Accion.IZQUIERDA) {
            direccion = "izquierda";
            esDerecha = false;
            x -= desplazamiento;
            if (x < 0) x = 0;
        }

        if (inputs.getAccionJugador2() == InputsJugadores.Accion.ARRIBA && !saltando) {
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

        if (inputs.getAccionJugador2() == InputsJugadores.Accion.ABAJO) {
            direccion = "abajo1";
            y += desplazamiento;
            if (y > 320) y = 320;
        }

        if (inputs.getAccionJugador2() == InputsJugadores.Accion.ATAQUE && !atacando) {
            atacando = true;
            contadorAtaque = DURACION_ATAQUE;
            direccion = esDerecha ? "ataque1" : "ataque1i"; // Primera fase del ataque
        } else if (inputs.getAccionJugador2() == InputsJugadores.Accion.PATADA && !atacando) {
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
}

