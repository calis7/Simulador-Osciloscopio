package interfazGrafica;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import dominioOsciloscopio.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * Create the panel.
 */
public class GeneradorFunciones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfPeriodo;
	private JTextField tfVoltaje;
	private JTextField tfDesfase;
	private JButton btnGenerar;
	private JPanel panelTipoSenial;
	private PantallaSenialInterior pantallaSenialInterior;
	private double periodo;
	private double amplitud;
	private double desfase;
	private int escala;
	private JButton btnReanudar;
	private JSlider jSliderPeriodo;
	private JSlider jSliderDesfase;
	private JSlider jSliderVoltaje;
	private JComboBox<String> comboBoxTipoSenial;
	private int clicks;
	private JPanel panelControles;
	private JSlider jSliderEscala;

	/**
	 * Constructor.
	 */
	public GeneradorFunciones(PantallaSenial pantallaSenial, PantallaSenialInterior pantallaSenialInterior) {
		
		this.escala = 30;
		this.pantallaSenialInterior = pantallaSenialInterior;
		pantallaSenialInterior.addMouseWheelListener(this::pantallaSenialInteriorMouseWheelMoved);

		panelTipoSenial = new JPanel();
		comboBoxTipoSenial = new JComboBox<>();

		setBackground(new Color(240, 240, 240));
		setForeground(SystemColor.textHighlight);
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Generador de Funciones", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 120, 215)));

		btnGenerar = new JButton("Generar");

		btnGenerar.addActionListener(this::btnGenerarActionPerformed);

		btnReanudar = new JButton("Reaundar");
		btnReanudar.addActionListener(this::btnReanudarActionPerformed);

		panelTipoSenial.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo de Se\u00F1al", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		panelControles = new JPanel();
		panelControles.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Controles",
				TitledBorder.LEFT, TitledBorder.TOP, null, SystemColor.textHighlight));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(GeneradorFunciones.class.getResource("/imagenes/Engranajes2.jpg")));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelControles, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 274, Short.MAX_VALUE)
						.addComponent(panelTipoSenial, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnReanudar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, 0, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGenerar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelTipoSenial, GroupLayout.PREFERRED_SIZE, 96, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelControles, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReanudar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap(30, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnGenerar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);

		JLabel lblVoltaje = new JLabel("Voltaje(V)");
		lblVoltaje.setFont(new Font("Consolas", Font.BOLD, 10));

		JLabel lblPeriodo = new JLabel("Periodo(s)");
		lblPeriodo.setFont(new Font("Consolas", Font.BOLD, 10));

		JLabel lblDesfase = new JLabel("Desfase(Rad)");
		lblDesfase.setFont(new Font("Consolas", Font.BOLD, 10));

		tfDesfase = new JTextField("0");
		tfDesfase.setBackground(SystemColor.control);
		tfDesfase.setHorizontalAlignment(SwingConstants.CENTER);

		jSliderDesfase = new JSlider();
		jSliderDesfase.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tfDesfase.setText(String.valueOf(jSliderDesfase.getValue()));
			}
		});
		jSliderDesfase.setPaintLabels(true);
		jSliderDesfase.setMinorTickSpacing(1);
		jSliderDesfase.setMajorTickSpacing(5);
		jSliderDesfase.setPaintTicks(true);
		jSliderDesfase.setMinimum(-10);
		jSliderDesfase.setMaximum(10);
		jSliderDesfase.setValue(0);
		jSliderDesfase.setOrientation(SwingConstants.VERTICAL);

		tfVoltaje = new JTextField("8");
		tfVoltaje.setBackground(SystemColor.control);
		tfVoltaje.setHorizontalAlignment(SwingConstants.CENTER);

		tfPeriodo = new JTextField("5");
		tfPeriodo.setBackground(SystemColor.control);
		tfPeriodo.setHorizontalAlignment(SwingConstants.CENTER);

		jSliderVoltaje = new JSlider();
		jSliderVoltaje.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tfVoltaje.setText(String.valueOf(jSliderVoltaje.getValue()));
			}
		});
		jSliderVoltaje.setPaintTicks(true);
		jSliderVoltaje.setPaintLabels(true);
		jSliderVoltaje.setMaximum(20);
		jSliderVoltaje.setMajorTickSpacing(5);
		jSliderVoltaje.setMinorTickSpacing(1);
		jSliderVoltaje.setValue(7);
		jSliderVoltaje.setOrientation(SwingConstants.VERTICAL);
		// jSliderVoltaje.addChangeListener(this::jSliderVoltajeAmpStateChanged);

		jSliderPeriodo = new JSlider();
		jSliderPeriodo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tfPeriodo.setText(String.valueOf(jSliderPeriodo.getValue()));
			}
		});
		jSliderPeriodo.setPaintLabels(true);
		jSliderPeriodo.setMajorTickSpacing(5);
		jSliderPeriodo.setPaintTicks(true);
		jSliderPeriodo.setMaximum(20);
		jSliderPeriodo.setMinorTickSpacing(1);
		jSliderPeriodo.setValue(5);
		jSliderPeriodo.setOrientation(SwingConstants.VERTICAL);

		JSlider JSliderEscala = new JSlider();

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(GeneradorFunciones.class.getResource("/imagenes/LupaMadera32x32.jpg")));

		jSliderEscala = new JSlider();
		jSliderEscala.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					
					if (jSliderEscala.getValue() != 0) {
						escala = jSliderEscala.getValue();
					} else {
						throw new IllegalArgumentException("La escala no puede ser cero.");
					}
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, "La escala no puede ser cero.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		jSliderEscala.setPaintLabels(true);
		jSliderEscala.setMajorTickSpacing(20);
		jSliderEscala.setPaintTicks(true);
		jSliderEscala.setMinorTickSpacing(5);
		GroupLayout gl_panelControles = new GroupLayout(panelControles);
		gl_panelControles.setHorizontalGroup(gl_panelControles.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelControles.createSequentialGroup().addContainerGap().addGroup(gl_panelControles
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelControles.createSequentialGroup().addGroup(gl_panelControles
								.createParallelGroup(Alignment.LEADING).addComponent(lblVoltaje)
								.addComponent(tfVoltaje, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelControles.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jSliderVoltaje, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panelControles.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelControles.createSequentialGroup().addGroup(gl_panelControles
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelControles.createSequentialGroup().addGap(18)
														.addComponent(lblPeriodo, GroupLayout.PREFERRED_SIZE, 80,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panelControles.createSequentialGroup().addGap(28)
														.addGroup(gl_panelControles
																.createParallelGroup(Alignment.LEADING)
																.addComponent(jSliderPeriodo,
																		GroupLayout.PREFERRED_SIZE, 50,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(tfPeriodo, GroupLayout.PREFERRED_SIZE, 40,
																		GroupLayout.PREFERRED_SIZE))))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panelControles.createParallelGroup(Alignment.LEADING)
														.addComponent(lblDesfase)
														.addGroup(gl_panelControles.createSequentialGroup().addGap(10)
																.addGroup(gl_panelControles
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(jSliderDesfase,
																				GroupLayout.PREFERRED_SIZE, 50,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(tfDesfase,
																				GroupLayout.PREFERRED_SIZE, 40,
																				GroupLayout.PREFERRED_SIZE)))))
										.addGroup(gl_panelControles.createSequentialGroup().addGap(18).addComponent(
												jSliderEscala, GroupLayout.PREFERRED_SIZE, 150,
												GroupLayout.PREFERRED_SIZE)))
								.addGap(80))
						.addGroup(gl_panelControles.createSequentialGroup()
								.addComponent(JSliderEscala, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
								.addGap(157)))));
		gl_panelControles.setVerticalGroup(gl_panelControles.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelControles.createSequentialGroup().addGroup(gl_panelControles
						.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDesfase, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelControles.createParallelGroup(Alignment.BASELINE).addComponent(lblVoltaje)
								.addComponent(lblPeriodo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGap(1)
						.addGroup(gl_panelControles.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfPeriodo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfDesfase, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfVoltaje, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelControles.createParallelGroup(Alignment.LEADING)
								.addComponent(jSliderDesfase, GroupLayout.PREFERRED_SIZE, 230,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelControles.createParallelGroup(Alignment.BASELINE)
										.addComponent(jSliderVoltaje, GroupLayout.PREFERRED_SIZE, 230,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jSliderPeriodo, GroupLayout.PREFERRED_SIZE, 230,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelControles.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelControles.createSequentialGroup()
										.addComponent(jSliderEscala, GroupLayout.PREFERRED_SIZE, 45,
												GroupLayout.PREFERRED_SIZE)
										.addGap(14).addComponent(JSliderEscala, GroupLayout.PREFERRED_SIZE, 15,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		
		
		panelControles.setLayout(gl_panelControles);


		comboBoxTipoSenial.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Sinusoidal", "Cuadrada", "Triangular" }));
		// comboBoxTipoSenial.addActionListener(this);

		comboBoxTipoSenial.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboBoxTipoSenialActionPerformed(evt);
			}

		});

		GroupLayout gl_panelTipoSenial = new GroupLayout(panelTipoSenial);
		gl_panelTipoSenial.setHorizontalGroup(gl_panelTipoSenial.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTipoSenial.createSequentialGroup().addGap(31)
						.addComponent(comboBoxTipoSenial, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(76, Short.MAX_VALUE)));
		gl_panelTipoSenial.setVerticalGroup(gl_panelTipoSenial.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTipoSenial
						.createSequentialGroup().addGap(24).addComponent(comboBoxTipoSenial, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(26, Short.MAX_VALUE)));
		panelTipoSenial.setLayout(gl_panelTipoSenial);
		setLayout(groupLayout);

	}

	/**
	 * 
	 * Eventos
	 * 
	 */
	
	/**
	 * 
	 * @param actionevent1
	 * Limpia la pantalla donde se visializa la señal
	 */
	
	private void btnReanudarActionPerformed(ActionEvent actionevent1) {

		if (escala > 0) {
			periodo = Double.parseDouble(tfPeriodo.getText());
			amplitud = Double.parseDouble(tfVoltaje.getText());
			desfase = Double.parseDouble(tfDesfase.getText());

			Plano p = new Plano(pantallaSenialInterior, escala);
			p.dibujarPlano();

		} else {
			setEscala(30);

		}
	}
	
	
	/**
	 * 
	 *
	 * @param evt
	 * 
	 * Ejecuta las acciones de graficar al oprimir el botón por cada tipo de señal.
	 */
	
	private void btnGenerarActionPerformed(ActionEvent evt) {
	    String tipoOnda = (String) comboBoxTipoSenial.getSelectedItem();

	    if (tfVoltaje.getText().equals("0") || tfPeriodo.getText().equals("0")) {
	        JOptionPane.showMessageDialog(this, "Ingrese valores al menos para Amplitud y Frecuencia");
	    } else {
	        try {
	            periodo = Double.parseDouble(tfPeriodo.getText());
	            amplitud = Double.parseDouble(tfVoltaje.getText());
	            desfase = Double.parseDouble(tfDesfase.getText());
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Debe ingresar valores numéricos", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	            return; // Salir del método si hay un error en el formato de los valores numéricos
	        }

	        if (tipoOnda.equalsIgnoreCase("Sinusoidal")) {
	            Plano p = new Plano(pantallaSenialInterior, escala);
	            p.dibujarPlano();
	            OndaSeno.dibujarOndaSeno(p, amplitud, periodo, desfase);
	        } else if (tipoOnda.equalsIgnoreCase("Cuadrada")) {
	            Plano p = new Plano(pantallaSenialInterior, escala);
	            p.dibujarPlano();
	            OndaCuadrada.dibujarOndaCuadrada(p, amplitud, periodo, desfase);
	        } else if (tipoOnda.equalsIgnoreCase("Triangular")) {
	            Plano p = new Plano(pantallaSenialInterior, escala);
	            p.dibujarPlano();
	            OndaTriangular.dibujarOndaTriangular(p, amplitud, periodo, desfase);
	        }

	        if (amplitud > 20) {
	            JOptionPane.showMessageDialog(this, "El valor debe estar entre 0 y 20", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}


/**	
	
	private void btnGenerarActionPerformed(ActionEvent evt) {


		if (comboBoxTipoSenial.getSelectedItem() == "Sinusoidal") {
			// dibuja una onda sinusoidal

			if (tfVoltaje.getText().equals("0") || tfPeriodo.getText().equals("0")) {
				JOptionPane.showMessageDialog(this, "Ingrese valores al menos para Amplitud y Frecuencia");
			} else {

				try {
					periodo = Double.parseDouble(tfPeriodo.getText());
					amplitud = Double.parseDouble(tfVoltaje.getText());
					desfase = Double.parseDouble(tfDesfase.getText());

				} catch (NumberFormatException ex) {

					JOptionPane.showMessageDialog(null, "Debe ingresar valores numéricos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				Plano p = new Plano(pantallaSenialInterior, escala);
				p.dibujarPlano();
				OndaSeno.dibujarOndaSeno(p, amplitud, periodo, desfase);

				if ((amplitud > 20) || (periodo > 20)) {
					// Mostrar un mensaje de error si el valor está fuera del rango
					JOptionPane.showMessageDialog(this, "El valor debe estar entre 0 y 20", "Error",
							JOptionPane.ERROR_MESSAGE);

				}
			}
		}

		if (comboBoxTipoSenial.getSelectedItem() == "Cuadrada") {
			// dibuja onda cuadrada

			if (tfVoltaje.getText().equals("0") || tfPeriodo.getText().equals("0")) {
				JOptionPane.showMessageDialog(this, "Ingrese valores al menos para Amplitud y Frecuencia");
			} else {

				try {
				
				periodo = Double.parseDouble(tfPeriodo.getText());
				amplitud = Double.parseDouble(tfVoltaje.getText());
				desfase = Double.parseDouble(tfDesfase.getText());
				

				} catch (NumberFormatException ex) {

					JOptionPane.showMessageDialog(null, "Debe ingresar valores numéricos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				Plano p = new Plano(pantallaSenialInterior, escala);
				p.dibujarPlano();
				OndaCuadrada.dibujarOndaCuadrada(p, amplitud, periodo, desfase);

				if (amplitud > 20) {
					// Mostrar un mensaje de error si el valor está fuera del rango
					JOptionPane.showMessageDialog(this, "El valor debe estar entre 0 y 20", "Error",
							JOptionPane.ERROR_MESSAGE);

				}

			}

		}

		if (comboBoxTipoSenial.getSelectedItem() == "Triangular") {

			if (tfVoltaje.getText().equals("0") || tfPeriodo.getText().equals("0")) {
				JOptionPane.showMessageDialog(this, "Ingrese valores al menos para Amplitud y Frecuencia");
			} else {

				// ***dibuja onda triangular ******* //
				
				try {
				periodo = Double.parseDouble(tfPeriodo.getText());
				amplitud = Double.parseDouble(tfVoltaje.getText());
				desfase = Double.parseDouble(tfDesfase.getText());
				

				} catch (NumberFormatException ex) {

					JOptionPane.showMessageDialog(null, "Debe ingresar valores numéricos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				Plano p = new Plano(pantallaSenialInterior, escala);
				p.dibujarPlano();
				OndaTriangular.dibujarOndaTriangular(p, amplitud, periodo, desfase);

				if (amplitud > 20) {
					// Mostrar un mensaje de error si el valor está fuera del rango
					JOptionPane.showMessageDialog(this, "El valor debe estar entre 0 y 20", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		}

	}
**/
	
	/**
	 * 
	 * @param clicks
	 * @param tipoOnda
	 * 
	 *                 Método que permite ajustar la escala de cada tipo de onda, se
	 *                 manejan errores a través de pantalla
	 * 
	 */

	public void ajustarEscala(String tipoOnda) {
		try {

			// Incrementar o decrementar la variable según el número de clics
			if (clicks > 0) {
				escala -= 3; // Movimiento hacia abajo
			} else {
				escala += 3; // Movimiento hacia arriba
			}

			if (escala <= 0) {
				throw new IllegalArgumentException("La escala no puede ser cero o negativa.");
			}

			Plano p = new Plano(pantallaSenialInterior, escala);
			p.dibujarPlano();

			if (tipoOnda.equalsIgnoreCase("sinusoidal")) {
				OndaSeno.dibujarOndaSeno(p, amplitud, periodo, desfase);
			} else if (tipoOnda.equalsIgnoreCase("cuadrada")) {
				OndaCuadrada.dibujarOndaCuadrada(p, amplitud, periodo, desfase);
			} else if (tipoOnda.equalsIgnoreCase("triangular")) {
				OndaTriangular.dibujarOndaTriangular(p, amplitud, periodo, desfase);
			}
		} catch (IllegalArgumentException e) {
			// Mostrar mensaje de error en un JOptionPane
			JOptionPane.showMessageDialog(null, "La escala ha alcanzado el límite máximo.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 
	 * @param evt
	 * 
	 */
/**
	private void pantallaSenialInteriorMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
		// TODO add your handling code here:

		if (comboBoxTipoSenial.getSelectedItem().equals("Sinusoidal")) {
			setClicks(evt.getWheelRotation());
			// jSliderEscala.getValue();
			ajustarEscala("sinusoidal");
		}
		

		else if (comboBoxTipoSenial.getSelectedItem().equals("Cuadrada")) {
			setClicks(evt.getWheelRotation());
			ajustarEscala("cuadrada");
		}

		else if (comboBoxTipoSenial.getSelectedItem().equals("Triangular")) {
			setClicks(evt.getWheelRotation());
			ajustarEscala("triangular");
		}

	}
**/
	
	private void pantallaSenialInteriorMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
	    // Se obtiene el tipo de onda seleccionado
	    String tipoOnda = (String) comboBoxTipoSenial.getSelectedItem();

	    // Se verifica el tipo de onda y realiza los ajustes de escala correspondientes
	    if (tipoOnda.equalsIgnoreCase("Sinusoidal") ||
	        tipoOnda.equalsIgnoreCase("Cuadrada") ||
	        tipoOnda.equalsIgnoreCase("Triangular")) {
	        setClicks(evt.getWheelRotation());
	        ajustarEscala(tipoOnda);
	    }
	}

	
		
		/**
		 * 
		 * setters and getters
		 */

	

	public JComboBox<String> getComboBoxTipoSenial() {
		return comboBoxTipoSenial;
	}

	public void setComboBoxTipoSenial(JComboBox<String> comboBoxTipoSenial) {
		this.comboBoxTipoSenial = comboBoxTipoSenial;
	}

	private void comboBoxTipoSenialActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	public int getEscala() {
		return escala;
	}

	public void setEscala(int escala) {
		this.escala = escala;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

}
