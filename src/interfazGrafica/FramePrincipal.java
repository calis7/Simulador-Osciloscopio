package interfazGrafica;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import dominioOsciloscopio.*;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;


public class FramePrincipal extends JFrame{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
 
    /**
     * Create the frame.
     */
    public FramePrincipal() {
        setTitle("Interfaz Simulador 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 856, 518);
        
        
       //Contenedor Principal
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        //Panel contenedor de la pantalla
        
        PantallaSenial pantallaSenial = new PantallaSenial();
        contentPane.add(pantallaSenial);
        
        
        //Panel de la pantalla de la señal
        PantallaSenialInterior pantallaSenialInterior = new  PantallaSenialInterior ();
        pantallaSenialInterior.setBackground(SystemColor.textHighlightText);
        pantallaSenialInterior.setForeground(new Color(0, 0, 0));
        pantallaSenialInterior.addMouseWheelListener(new MouseWheelListener() {
        	public void mouseWheelMoved(MouseWheelEvent e) {
        	}
        });

        //Panel generador de las señales
        GeneradorFunciones generadorFunciones = new GeneradorFunciones(pantallaSenial,pantallaSenialInterior);
        pantallaSenial.add(pantallaSenialInterior);
        pantallaSenialInterior.setLayout(new GridLayout(1, 1, 0, 0));
        
        JLabel jLabelFondo = new JLabel("");
        jLabelFondo.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelFondo.setIcon(new ImageIcon(FramePrincipal.class.getResource("/imagenes/UNIRfondo.jpeg")));
        
        pantallaSenialInterior.add(jLabelFondo);
        generadorFunciones.setPreferredSize(new Dimension(300, 0));
        contentPane.add(generadorFunciones);
        

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(generadorFunciones, BorderLayout.WEST);
        getContentPane().add(pantallaSenial, BorderLayout.CENTER);

        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

//Eventos
    
    
	
}