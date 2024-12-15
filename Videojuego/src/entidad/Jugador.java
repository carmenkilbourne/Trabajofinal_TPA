package entidad;

public abstract class Jugador {
    protected int saludActual;
    protected int saludMax;
    protected boolean defendiendo;
    protected int ataque = 10;
    protected String direccion;
    protected int alturaJugador = 200;
    protected int anchuraJugador=200;
    protected int x,y;
    // Métodos comunes a todos los jugadores
    public void recibirDanio(int cantidad) {
        if (defendiendo) {
            cantidad = 0; // Si est defendiendo no se provo
        }
        saludActual -= cantidad;
        if (saludActual < 0) saludActual = 0;
        System.out.println(getClass().getSimpleName() + " ha recibido daño, vida restante: " + getSaludActual());
    }

    public int getAtaque() {
        return ataque;
    }
    public void atacar(Jugador enemigo) {
        System.out.println(getClass().getSimpleName() + " ataca a " + enemigo.getClass().getSimpleName());
        enemigo.recibirDanio(this.ataque);
    }


    public int getSaludActual() {
        return saludActual;
    }
    public int getX() {
    	return x;
    }
    public int getY() {
    	return x;
    }

}
