package interfazGrafica;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class Escalas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Escalas() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Osciloscopio", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.textHighlight));
		setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Escala Amplitud");
		add(lblNewLabel);
		
		JSlider slider = new JSlider();
		add(slider);
		
		JLabel lblNewLabel_1 = new JLabel("Escala Periodo");
		add(lblNewLabel_1);
		
		JSlider slider_1 = new JSlider();
		add(slider_1);

	}

}
