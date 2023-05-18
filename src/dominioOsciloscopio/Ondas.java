
package dominioOsciloscopio;
/**
 *
 * @author Camilo Lotero
 */
public class Ondas {
  private  double desfase;
  private  double periodo;
  private  double amplitud;

    /**
     * 
     * @param periodo
     * @param amplitud
     * @param desfase
     */
    public Ondas(double periodo,double amplitud,double desfase) {
    
        this.desfase = desfase;
        this.periodo = periodo;
        this.amplitud = amplitud;
    }
}

