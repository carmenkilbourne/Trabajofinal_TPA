package entidad;

public class MovimientoJugador {
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

    public MovimientoJugador(InputsJugadores inputs, int inicialX, int inicialY) {
        this.inputs = inputs;
        this.x = inicialX;  // Inicializar x
        this.y = inicialY;  // Inicializar y
        setVariables();
    }

    public void setVariables() {
        x = 0;
        y = 320;
        direccion = "arriba";
    }
    public void update(int panelWidth, int panelHeight) {
        // Movimientos basados en entradas del jugador
        if (inputs.getAccionJugador1() == InputsJugadores.Accion.DERECHA) {
            direccion = "derecha";
            esDerecha = true;
            x += desplazamiento;
            if (x > panelWidth - 200) x = panelWidth - 200;
        }

        if (inputs.getAccionJugador1() == InputsJugadores.Accion.IZQUIERDA) {
            direccion = "izquierda";
            esDerecha = false;
            x -= desplazamiento;
            if (x < 0) x = 0;
        }

        if (inputs.getAccionJugador1() == InputsJugadores.Accion.ARRIBA && !saltando) {
            saltando = true;
            tiempoSalto = 0;
        }

        if (saltando) {
            if (tiempoSalto < maxAlturaSalto) {
                y -= velocidadSalto;
                if (y < 120) y = 120; // Limitar altura máxima
                tiempoSalto += velocidadSalto;
            } else {
                saltando = false;
            }
        }

        if (y < 320 && !saltando) {
            y += velocidadSalto;  // Gravedad
            if (y > 320) y = 320;
        }

        if (inputs.getAccionJugador1() == InputsJugadores.Accion.ABAJO) {
            direccion = "abajo";
            y += desplazamiento;
            if (y > 320) y = 320;
        }

        if ((inputs.getAccionJugador1() == InputsJugadores.Accion.ATAQUE || 
            inputs.getAccionJugador1() == InputsJugadores.Accion.PATADA) && !atacando) {
            atacando = true;
            contadorAtaque = DURACION_ATAQUE;
            direccion = (inputs.getAccionJugador1() == InputsJugadores.Accion.ATAQUE) ? "atacar" : "patada";
        }

        if (atacando) {
            contadorAtaque--;
            if (contadorAtaque <= 0) {
                atacando = false;
                direccion = esDerecha ? "derecha" : "izquierda";
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
