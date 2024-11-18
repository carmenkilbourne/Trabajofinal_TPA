package entidad;
import java.awt.image.BufferedImage;

public class Entity {
	protected int x,y;
	public int desplazamiento;
	public BufferedImage salto1,derecha1,izquierda1,abajo1;
	public String direccion;
	protected int saludActual;
    protected int ataque;

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
}
