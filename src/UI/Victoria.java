package UI;

import java.awt.Color;
import java.awt.Font;
<<<<<<< HEAD
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
>>>>>>> master

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
<<<<<<< HEAD
=======
import javax.swing.WindowConstants;
>>>>>>> master

public class Victoria extends JFrame {

    private static final Color BG         = Color.decode("#121213");
    private static final Color TEXT       = Color.WHITE;
    private static final Color TEXT_MUTED = Color.decode("#818384");
    private static final Color GREEN      = Color.decode("#538d4e");

    private JTextField nombre;

    public Victoria(JFrame main, String tiempoDeJuego) {
        initialize(main, tiempoDeJuego);
    }

    private void initialize(JFrame main, String tiempoDeJuego) {
        setSize(620, 480);
        setLocationRelativeTo(main);
        setTitle("Wordle");
<<<<<<< HEAD
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
=======
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
>>>>>>> master
        getContentPane().setBackground(BG);
        getContentPane().setLayout(null);

        JLabel titulo = new JLabel("¡VICTORIA!");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titulo.setForeground(GREEN);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(0, 40, 620, 50);
        getContentPane().add(titulo);

        JLabel texto = new JLabel("Adivinaste la palabra en:");
        texto.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        texto.setForeground(TEXT_MUTED);
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setBounds(0, 105, 620, 25);
        getContentPane().add(texto);

        JLabel tiempo = new JLabel(tiempoDeJuego);
        tiempo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        tiempo.setForeground(TEXT);
        tiempo.setHorizontalAlignment(SwingConstants.CENTER);
        tiempo.setBounds(0, 135, 620, 40);
        getContentPane().add(tiempo);

        JLabel ingresoDeNombreLabel = new JLabel("Ingresá tu nombre para el ranking:");
        ingresoDeNombreLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        ingresoDeNombreLabel.setForeground(TEXT_MUTED);
        ingresoDeNombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ingresoDeNombreLabel.setBounds(0, 200, 550, 20);
        getContentPane().add(ingresoDeNombreLabel);

        nombre = new JTextField();
        nombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        nombre.setBackground(Color.decode("#1a1a1b"));
        nombre.setForeground(TEXT);
        nombre.setCaretColor(TEXT);
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        nombre.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.decode("#3a3a3c"), 1),
            BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));
        nombre.setBounds(210, 230, 200, 30);
        getContentPane().add(nombre);

        JButton btnRegistrar = Main.crearBoton("Registrar", GREEN, Color.decode("#6aaf5e"));
        btnRegistrar.setBounds(250, 280, 120, 32);
        getContentPane().add(btnRegistrar);

        btnRegistrar.addActionListener(new ActionListener() {
<<<<<<< HEAD
            public void actionPerformed(ActionEvent e) {
=======
            @Override
			public void actionPerformed(ActionEvent e) {
>>>>>>> master
                // TODO: guardar record
                main.setVisible(true);
                dispose();
            }
        });
    }
}
