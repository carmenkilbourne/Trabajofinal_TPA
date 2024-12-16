package entidad;

/**
 * Clase base de los Jugador que tiene elementos que son comunes en ambas clases
 */
public abstract class Jugador {
	protected int saludActual;
	protected int saludMax;
	protected boolean defendiendo;
	protected int ataque;
	protected String direccion;
	protected int alturaJugador;
	protected int anchuraJugador;
	protected int x, y;

	// Métodos comunes a todos los jugadores
	/**
	 * Metodo para recibir una cantidad de daño dependiendo de si se esta
	 * defendiendo o no
	 * 
	 * @param cantidadDanio
	 */
	public void recibirDanio(int cantidadDanio) {
		if (defendiendo) {
			cantidadDanio = 0; // Si est defendiendo no se provo
		}
		saludActual -= cantidadDanio;
		if (saludActual < 0)
			saludActual = 0;
		System.out.println(getClass().getSimpleName() + " ha recibido daño, vida restante: " + getSaludActual());
	}

	/**
	 * Metodo que devuelve el impacto sobre la vida de otro jugador
	 * 
	 * @return ataque
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * Metodo para quitar vida a otro jugador
	 * 
	 * @param enemigo
	 */
	public void atacar(Jugador enemigo) {
		enemigo.recibirDanio(this.ataque);
	}

	/**
	 * Devuelve la cantidad de vida que tiene el jugador en cada momento
	 * 
	 * @return saludActual
	 */
	public int getSaludActual() {
		return saludActual;
	}

	/**
	 * Metodo que devuelve la posicion del jugador en el eje X
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Metodo que devuelve la posicion en el eje Y del jugador
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Metodo para set salud maxima;
	 * 
	 * @param saludMax
	 */
	public void setSaludMaxima(int saludMax) {
		this.saludMax = saludMax;
	}
	public int getAlturaJugador() {
		return alturaJugador;
	}

	public void setAlturaJugador(int alturaJugador) {
		this.alturaJugador = alturaJugador;
	}

	public int getAnchuraJugador() {
		return anchuraJugador;
	}

	public void setAnchuraJugador(int anchuraJugador) {
		this.anchuraJugador = anchuraJugador;
	}

}
