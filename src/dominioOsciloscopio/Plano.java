package dominioOsciloscopio;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.JPanel;
/**
 *
 * @author Camilo Lotero
 */
public class Plano {
  private JPanel p;  
  private int w;
  private int h;
  private int escala;
  
  /**
   * 
   * @param p
   * @param escala 
   */
  public Plano(JPanel p, int escala) {
    this.escala = escala;
    this.p = p;
    w = p.getWidth();
	h = p.getHeight();
    
  }
  /**
   * 
   */
  
  public void dibujarPlano() {
	    Graphics2D g = (Graphics2D) p.getGraphics();

	    g.setBackground(new Color(14, 26, 103));
	    g.clearRect(0, 0, w, h);
	    g.setColor(Color.GREEN);
	    g.setStroke(new BasicStroke(2));
	    g.drawLine(w / 2, 0, w / 2, h);
	    g.drawLine(0, h / 2, w, h / 2);
	    g.setColor(Color.WHITE);
	    g.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0, new float[] { 2 }, 0));

	    int x2 = w / 2;
	    int etiquetaX = 0;
	    for (int x = w / 2; x < w; x += escala) {
	        g.drawLine(x, 0, x, h);
	        g.drawLine(x2, 0, x2, h);
	        x2 = x2 - escala;

	        // Agregar etiquetas en el eje x
	        if (x != w / 2) {
	            if (x > w / 2) {
	                etiquetaX++;
	                g.drawString(Integer.toString(etiquetaX), x + 2, h / 2 + 15);
	                g.drawString(Integer.toString(-etiquetaX), x2 + 2 + escala, h / 2 + 15);
	            } else {
	                g.drawString(Integer.toString(-etiquetaX), x - 8, h / 2 + 15);
	                g.drawString(Integer.toString(etiquetaX), x2 - 8, h / 2 + 15);
	                etiquetaX++;
	            }
	        }
	    }

	    int y2 = h / 2;
	    int etiquetaY = 0;
	    for (int y = h / 2; y < h; y += escala) {
	        g.drawLine(0, y, w, y);
	        g.drawLine(0, y2, w, y2);
	        y2 = y2 - escala;

	        // Agregar etiquetas en el eje y
	        if (y != h / 2) {
	            if (y > h / 2) {
	                etiquetaY++;
	                g.drawString(Integer.toString(-etiquetaY), w / 2 + 5, y - 2);
	                g.drawString(Integer.toString(etiquetaY), w / 2 + 5, y2 + escala - 2);
	            } else {
	                g.drawString(Integer.toString(etiquetaY), w / 2 + 5, y + 12);
	                g.drawString(Integer.toString(-etiquetaY), w / 2 + 5, y2 + 12);
	                etiquetaY++;
	            }
	        }
	    }
	}

  

      public void dibujarPunto(double x, double y){

        Graphics2D g =  (Graphics2D) p.getGraphics();
        g.setColor(Color.RED);
        g.setStroke(new BasicStroke(3));

        int xDigital = (int) (w/2   + x*escala);
        int yDigital = (int) (h/2 - y*escala);
        g.drawLine(xDigital,  yDigital,xDigital,  yDigital);

        /**Este código también funciona solo que al dibujar puntos es mas lento.
        int xDigital = (int) (w/2   + x*escala);
        int yDigital = (int) (h/2 - y*escala);
        g.fillOval(xDigital - 2,yDigital -2,4,4);
        g.setColor(Color.RED);
        g.setStroke(new BasicStroke(1));
        **/
      } 

      public void dibujarLinea(double x1, double y1, double x2, double y2) {
      Graphics2D g = (Graphics2D) p.getGraphics();
      g.setColor(Color.RED);
      g.setStroke(new BasicStroke(3));

      int x1Digital = (int) (w / 2 + x1 * escala);
      int y1Digital = (int) (h / 2 - y1 * escala);
      int x2Digital = (int) (w / 2 + x2 * escala);
      int y2Digital = (int) (h / 2 - y2 * escala);

      g.drawLine(x1Digital, y1Digital, x2Digital, y2Digital);

    }

}
  