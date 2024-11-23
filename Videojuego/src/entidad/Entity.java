package entidad;
import java.awt.image.BufferedImage;

public class Entity {
	protected int x,y;
	public int desplazamiento;
	public BufferedImage salto1,derecha1,izquierda1,abajo1,ataque1,ataque12,pow,patada1,patada2;
	public String direccion;
	protected int saludActual;
    protected int ataque;
    protected int alturaJugador = 200;
	protected int anchuraJugador = 200;

	public int getAtaque() {
        return ataque;
    }
    public void recibirDanio(int danio) {
    	saludActual -= danio;
        if (saludActual < 0) saludActual = 0;
        System.out.println("Vida restante: " + saludActual);
    }
	 public void atacar(Entity defensor) {
		        defensor.recibirDanio(this.getAtaque());
    }
	 public int getX() {
		 return x;
	 }
	 public int getY() {
		 return y;
	 }
	 public int getalturaJugador() {
		 return alturaJugador;
	 }
	 public int getanchuraJugador() {
		 return anchuraJugador;
	 }
}
