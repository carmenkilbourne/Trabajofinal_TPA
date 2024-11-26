package pantallaInicio;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JFrameSize
{

  public static void main(String[] args)
  {
    // schedule this for the event dispatch thread (edt)
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        displayJFrame();
      }
    });
  }

  static void displayJFrame()
  {
    // create our jframe as usual
    JFrame jframe = new JFrame("JFrame Size Example");
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    panel.setLayout(null); 
    panel.setPreferredSize(new Dimension(400, 300));
    

    // Fondo de pantalla
    FondoPantalla pantallaInicio = new FondoPantalla("/Imagenes/pi.png");
    pantallaInicio.setBounds(0, 0, 400, 300);
    jframe.add(pantallaInicio);
    // set the jframe size and location, and make i	t visible
    jframe.setPreferredSize(new Dimension(400, 300));
    jframe.pack();
    jframe.setLocationRelativeTo(null);
    jframe.setVisible(true);
  }

}