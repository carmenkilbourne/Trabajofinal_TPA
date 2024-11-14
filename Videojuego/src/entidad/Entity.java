package entidad;
import java.awt.image.BufferedImage;

public class Entity {
	public int x,y;
	public int desplazamiento;
	public BufferedImage salto1,derecha1,izquierda1,abajo1;
	public String direccion;
	protected int vida;
    protected int ataque;
	public int getAtaque() {
        return ataque;
    }
    public void recibirDanio(int danio) {
        vida -= danio;
        if (vida < 0) vida = 0;
        System.out.println("Vida restante: " + vida);
    }
	 public void atacar(Entity defensor) {
	        defensor.recibirDanio(this.getAtaque());
	    }

}
