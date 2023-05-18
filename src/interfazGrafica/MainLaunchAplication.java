package interfazGrafica;

import javax.swing.SwingUtilities;

public class MainLaunchAplication {
	/**
     * Launch the application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
           
            public void run() {
            	FramePrincipal simulador = new FramePrincipal();
            	simulador.pack();
            }
        });
    }

}
/**
 * El código que se está utilizando en el método main es una forma común de iniciar una aplicación Swing de manera correcta y fluida. 
 * Al utilizar SwingUtilities.invokeLater(new Runnable() { ... }), se está asegurando que la creación y visualización de la interfaz 
 * gráfica se realicen en el hilo de despacho de eventos de Swing (Event Dispatch Thread), que es el hilo apropiado para manejar la 
 * interfaz de usuario en Swing.
Cuando se ejecuta el método main en Java, normalmente se ejecuta en el hilo principal (conocido como hilo "main"). 
Si se crea y muestra la interfaz gráfica directamente en el hilo principal, puede haber problemas de concurrencia y rendimiento, 
ya que Swing no está diseñado para ser utilizado en varios hilos simultáneamente.

Al usar SwingUtilities.invokeLater, le estás diciendo a Swing que programe la creación de la interfaz gráfica en el Event Dispatch Thread, 
lo que garantiza que se ejecute de manera segura y sin bloqueos.
En resumen, al utilizar SwingUtilities.invokeLater, es probable que experimentes una mayor fluidez y rendimiento en tu aplicación Swing, 
ya que estás siguiendo las mejores prácticas recomendadas por Swing para trabajar con la interfaz gráfica de usuario.
 */
    