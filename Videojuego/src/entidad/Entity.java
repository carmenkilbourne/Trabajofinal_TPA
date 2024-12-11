package entidad;
import java.awt.image.BufferedImage;

public class Entity {
	protected int x,y;
	public int desplazamiento;
	//nombre de frames drecha, iquierda, frente, patada (drch,izq),puñetazo(drcha,izq);
	//public BufferedImage salto,derecha,izquierda,abajo1,ataque1,ataque12,pow,patada1,patada2,patada1i,patada2i,ataque1i,ataque2i;
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
