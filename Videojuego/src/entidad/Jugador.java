package entidad;

/**
 * Clase base de los Jugador que tiene elementos que son comunes en ambas
 * clases, es una clase abstracta ya que nunca se va a instanciar. Implementa un
 * patrón Template Method que define el esqueleto de un algoritmo en una
 * superclase pero dejaria a sus subclases Jugador1 y Jugador2 sobreescribir
 * funciones.
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

	/**
	 * Metodo para recibir una cantidad de daño dependiendo de si se esta
	 * defendiendo o no.
	 * 
	 * @param cantidadDanio es la cantidad de daño que va a recibir un jugador
	 *                      dependiendo del tipo que sea.
	 */
	public void recibirDanio(int cantidadDanio) {
		if (defendiendo) {
			cantidadDanio = 0; // Si est defendiendo no se provoCA daño
		}
		saludActual -= cantidadDanio;
		if (saludActual < 0)
			saludActual = 0;
		System.out.println(getClass().getSimpleName() + " ha recibido daño, vida restante: " + getSaludActual());
	}

	/**
	 * Metodo que devuelve el impacto sobre la vida de otro jugador.
	 * 
	 * @return ataque es la cantidad de daño que provoca el jugador
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * Metodo para quitar vida a otro jugador.
	 * 
	 * @param enemigo para implementar su método recibir daño
	 */
	public void atacar(Jugador enemigo) {
		enemigo.recibirDanio(this.ataque);
	}

	/**
	 * Devuelve la cantidad de vida que tiene el jugador en cada momento.
	 * 
	 * @return cantidad de vida que tiene el jugador.
	 */
	public int getSaludActual() {
		return saludActual;
	}

	/**
	 * Devuelve la posicion del jugador en el eje X.
	 * 
	 * @return posición en el eje X
	 */
	public int getX() {
		return x;
	}

	/**
	 * Metodo que devuelve la posicion en el eje Y del jugador.
	 * 
	 * @return posición en el eje Y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Metodo para establecer la salud máxima.
	 * 
	 * @param saludMax es la salud máxima
	 */
	public void setSaludMaxima(int saludMax) {
		this.saludMax = saludMax;
	}

	/**
	 * Metodo que devuelve la altura del jugador.
	 * 
	 * @return alturaJugador
	 */
	public int getAlturaJugador() {
		return alturaJugador;
	}

	/**
	 * Método que establece la altura del jugador.
	 * 
	 * @param alturaJugador
	 */
	public void setAlturaJugador(int alturaJugador) {
		this.alturaJugador = alturaJugador;
	}

	/**
	 * Método que devuelve el ancho del jugador.
	 * 
	 * @return ancho de jugador.
	 */
	public int getAnchuraJugador() {
		return anchuraJugador;
	}

	/**
	 * Método que establece la anchura del jugador
	 * 
	 * @param anchuraJugador
	 */
	public void setAnchuraJugador(int anchuraJugador) {
		this.anchuraJugador = anchuraJugador;
	}

	/**
	 * Método que devuelve el máximo nivel de vida del jugador.
	 * 
	 * @return salud máxima del jugador.
	 */
	public int getSaludMaxima() {
		return saludMax;
	}

	/**
	 * Método que establece si se esta defendiendo.
	 * 
	 * @param defendiendo es boolean que sera true si el jugador se defiende y false
	 *                    si deja de hacerlo.
	 */
	public void setDefendiendo(boolean defendiendo) {
		this.defendiendo = defendiendo;
	}

}
