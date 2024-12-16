package entidad;


class ParametrosJugadores {
    int saludMax;
    int ataque;

    public ParametrosJugadores(int saludMax, int ataque) {
        this.saludMax = saludMax;
        this.ataque = ataque;
    }
    public int getSaludMax() {
    	return saludMax;
    }
    public int getAtaque() {
    	return ataque;
    }
}