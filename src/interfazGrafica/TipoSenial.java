package interfazGrafica;

import javax.swing.JPanel;

import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import dominioOsciloscopio.*;

public class TipoSenial extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TipoSenial() {
		setBorder(new TitledBorder(null, "Tipo de se\u00F1al", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 192)));
		setLayout(new GridLayout(0, 1, 1, 1));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Seno");
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Cuadrada");
		add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Triangular");
		add(rdbtnNewRadioButton_2);

	}

}
