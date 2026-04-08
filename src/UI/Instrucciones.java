package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Instrucciones extends JFrame {

	public Instrucciones(Main parent) {
		initialize(parent);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Main parent) {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("Instrucciones");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titulo.setBounds(169, 10, 127, 100);
		getContentPane().add(titulo);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(10, 221, 84, 20);
		getContentPane().add(botonVolver);
		
		JButton botonIniciarPartida = new JButton("Iniciar Partida");
		botonIniciarPartida.setBounds(287, 221, 120, 20);
		getContentPane().add(botonIniciarPartida);
		
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.setVisible(true);
				dispose();
			}
		});
		
		botonIniciarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeleccionDeNivel seleccionDeNivel = new SeleccionDeNivel(parent);
				seleccionDeNivel.setVisible(true);
				dispose();
			}
		});
	}

}
