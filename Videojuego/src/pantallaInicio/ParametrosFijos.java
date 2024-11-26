package pantallaInicio;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ParametrosFijos {
	int alturaFrame,anchuraFrame;
	public ParametrosFijos(){
		Dimension tamanoFrame = Toolkit.getDefaultToolkit().getScreenSize();	//tamano de pantalla
    	alturaFrame = (int) tamanoFrame.getHeight();
    	anchuraFrame = (int) tamanoFrame.getWidth();
	}
	public int getAlturaPantalla() {
		return alturaFrame;
	}
	public int getAnchoPantalla() {
		return anchuraFrame;
	}

}
