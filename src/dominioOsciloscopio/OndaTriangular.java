package dominioOsciloscopio;

/**
 *
 * @author Camilo Lotero
 */
public class OndaTriangular extends Ondas {
 
  public OndaTriangular(double periodo, double amplitud, double desfase) {
    super(periodo, amplitud, desfase);
  }
        public static void dibujarOndaTriangular(Plano p,double amplitud, double periodo, double desfase) {  
  
              for (double x = -50; x <= 50; x += 0.001) {
                
                double y = (2*amplitud/Math.PI)* Math.asin(Math.sin(2*Math.PI/periodo*x + desfase));
                
                p.dibujarPunto(x, y);
                 
              }
        }
}
           


        
  
      
    
    
    

    
 
 
    
        
       
         
    
        
