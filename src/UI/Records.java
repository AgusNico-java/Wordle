package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Records extends JFrame {

	public Records(Main parent) {
		initialize(parent);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Main parent) {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("Records");
		titulo.setForeground(new Color(255, 0, 0));
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titulo.setBounds(134, 10, 162, 91);
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
