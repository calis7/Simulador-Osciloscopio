package interfazGrafica;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dominioOsciloscopio.*;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;

public class PantallaSenial extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public PantallaSenial() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Pantalla de Señal", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 120, 215)));
        setLayout(new GridLayout(1, 1));
       
    
    }
}
