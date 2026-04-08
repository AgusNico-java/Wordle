package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Derrota extends JFrame{
	private String palabraSecreta;
	
	public Derrota(JFrame main, String palabraSecreta) {
		this.palabraSecreta = palabraSecreta;
		initialize(main);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame main) {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("PERDISTE!");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titulo.setBounds(124, 22, 99, 66);
		getContentPane().add(titulo);
		
		JLabel etiqueta = new JLabel("La palabra secreta era: ");
		etiqueta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etiqueta.setBounds(20, 101, 178, 24);
		getContentPane().add(etiqueta);
		
		JLabel lblNewLabel = new JLabel(this.palabraSecreta);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(30, 135, 139, 35);
		getContentPane().add(lblNewLabel);
		
		JButton botonMenuPrincipal = new JButton("Volver al inicio");
		botonMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				setVisible(false);
			}
		});
		botonMenuPrincipal.setBounds(26, 206, 143, 24);
		getContentPane().add(botonMenuPrincipal);
		
		JButton botonIntentarDeNuevo = new JButton("Intentar nuevamente");
		botonIntentarDeNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeleccionDeNivel seleccionDeNivel = new SeleccionDeNivel(main);
				seleccionDeNivel.setVisible(true);
				setVisible(false);
			}
		});
		botonIntentarDeNuevo.setBounds(251, 206, 124, 24);
		getContentPane().add(botonIntentarDeNuevo);
	}

}
