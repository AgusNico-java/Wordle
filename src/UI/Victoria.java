package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Victoria extends JFrame {
	private JTextField nombre;

	public Victoria(JFrame main, String tiempoDeJuego) {
		initialize(main, tiempoDeJuego);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame main, String tiempoDeJuego) {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("VICTORIA");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		titulo.setBounds(130, 10, 131, 66);
		getContentPane().add(titulo);
		
		JLabel texto = new JLabel("Adivinaste la palabra secreta en: ");
		texto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		texto.setBounds(109, 86, 236, 43);
		getContentPane().add(texto);
		
		nombre = new JTextField();
		nombre.setBounds(109, 181, 96, 18);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		JLabel ingresoDeNombreLabel = new JLabel("Ingresa tu nombre: ");
		ingresoDeNombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ingresoDeNombreLabel.setBounds(104, 150, 122, 21);
		getContentPane().add(ingresoDeNombreLabel);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Registrar nombre para enviar record
				
				main.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(237, 180, 84, 20);
		getContentPane().add(btnNewButton);
		
		JLabel tiempo = new JLabel(tiempoDeJuego);
		tiempo.setBounds(155, 118, 122, 27);
		getContentPane().add(tiempo);
		
	}

}
