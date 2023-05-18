package dominioOsciloscopio;
/**
 *
 * @author Camilo Lotero
 */
public class OndaCuadrada extends Ondas {
  

public OndaCuadrada(double periodo, double amplitud, double desfase) {
    super(periodo, amplitud, desfase);
  }

        public static void dibujarOndaCuadrada(Plano p, double amplitud, double periodo, double desfase) {  
        double prevX = -50;
        double prevY = amplitud * Math.signum(Math.sin(2 * Math.PI / periodo * prevX + desfase));
  
              for (double x = -50; x <= 50; x += 0.001) {
              double y = amplitud * Math.signum(Math.sin(2 * Math.PI / periodo * x + desfase));
  
              p.dibujarLinea(prevX, prevY, x, y);
              prevX = x;
              prevY = y;
              }


        }

}





        

           


        
  
      
    
    
    

    
 
 
    
        
       
         
    
        
