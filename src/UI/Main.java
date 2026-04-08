package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Main extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}  catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
				initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WORDLE");
		lblNewLabel.setForeground(Color.decode("#00ff00"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(148, 26, 137, 57);
		getContentPane().add(lblNewLabel);
		
		JButton newGameButton = new JButton("Iniciar Partida");
		newGameButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newGameButton.setBounds(112, 93, 110, 31);
		getContentPane().add(newGameButton);
		
		JButton instruccionesButton = new JButton("Instrucciones");
		instruccionesButton.setBounds(112, 145, 110, 31);
		getContentPane().add(instruccionesButton);
		
		JButton recordsButton = new JButton("Records");
		recordsButton.setBounds(112, 199, 110, 36);
		getContentPane().add(recordsButton);
		
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeleccionDeNivel seleccionDeNivel = new SeleccionDeNivel(Main.this);
				seleccionDeNivel.setVisible(true);
				setVisible(false);

			}
		});

		instruccionesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instrucciones instrucciones = new Instrucciones(Main.this);
				instrucciones.setVisible(true);
				setVisible(false);

			}
		});
		
		recordsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Records records = new Records(Main.this);
				records.setVisible(true);
				setVisible(false);

			}
		});


	}
}
