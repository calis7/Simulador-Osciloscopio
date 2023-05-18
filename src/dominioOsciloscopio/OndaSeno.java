
package dominioOsciloscopio;


/**
 *
 * @author Camilo Lotero
 */
public class OndaSeno extends Ondas {

   public OndaSeno(double periodo, double amplitud, double desfase) {
    super(periodo, amplitud, desfase);
  }
        public static void dibujarOndaSeno(Plano p,double amplitud, double periodo, double desfase) {  
    
              for (double x = -50; x <= 50; x += 0.001) {
           
                double y =  amplitud*Math.sin(2*Math.PI/periodo*x + desfase);
                
                p.dibujarPunto(x, y);
                
              }
            
        }
         
}
    
    

    
 
 
    
        
       
         
    
        
