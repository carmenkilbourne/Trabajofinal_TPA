package entidad;


/**
 * Clase para devolver los parametros salud y cantidad de danio que va a ejercer cada jugador
 */
class ParametrosJugadores {
    int saludMax;
    int ataque;
	int alturaJugador;
	int desplazamiento;
	int anchuraJugador;

   
	/**
     * COnstructor de la clase ParametroJugadores
     * @param saludMax
     * @param ataque
     */
    public ParametrosJugadores(int saludMax, int ataque,int alturaJugador,int anchuraJugador,int desplazamiento) {
        this.saludMax = saludMax;
        this.ataque = ataque;
        this.alturaJugador = alturaJugador;
        this.anchuraJugador = anchuraJugador;
        this.desplazamiento = desplazamiento;
    }
    public int getSaludMax() {
    	return saludMax;
    }
    public int getAtaque() {
    	return ataque;
    }
    public int getAnchuraJugador() {
		return anchuraJugador;
	}
	public int getAlturaJugador() {
		return alturaJugador;
	}
	public int getDesplazamiento() {
		return desplazamiento;
	}
}