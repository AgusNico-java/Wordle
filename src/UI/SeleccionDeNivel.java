package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import logica.modelo.Dificultad;

import javax.swing.ButtonGroup;

public class SeleccionDeNivel extends JFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public SeleccionDeNivel(JFrame parent) {
		initialize(parent);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame parent) {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("Seleccione el nivel");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titulo.setBounds(121, 10, 175, 65);
		getContentPane().add(titulo);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(10, 221, 84, 20);
		getContentPane().add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.setVisible(true);
				dispose();
			}
		});
		
		JRadioButton facilRadioButton = new JRadioButton("Facil");
		facilRadioButton.setSelected(true);
		buttonGroup.add(facilRadioButton);
		facilRadioButton.setBounds(121, 119, 102, 20);
		facilRadioButton.setActionCommand(Dificultad.FACIL.getNombre());
		getContentPane().add(facilRadioButton);
		
		JRadioButton medioRadioButton = new JRadioButton("Medio");
		buttonGroup.add(medioRadioButton);
		medioRadioButton.setBounds(121, 152, 102, 20);
		medioRadioButton.setActionCommand(Dificultad.MEDIO.getNombre());
		getContentPane().add(medioRadioButton);
		
		JRadioButton dificilRadioButton = new JRadioButton("Dificil");
		buttonGroup.add(dificilRadioButton);
		dificilRadioButton.setBounds(121, 192, 102, 20);
		dificilRadioButton.setActionCommand(Dificultad.DIFICIL.getNombre());
		getContentPane().add(dificilRadioButton);
		
		JButton botonIniciarPartida = new JButton("Jugar!");
		botonIniciarPartida.setBounds(287, 221, 120, 20);
		getContentPane().add(botonIniciarPartida);
		
		botonIniciarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dificultad = buttonGroup.getSelection().getActionCommand();
				WordleWindow wordleWindow = new WordleWindow(parent, dificultad);
				wordleWindow.setVisible(true);
				setVisible(false);
			}
		});
	}
}
