package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JButton botonVolver = Main.crearBoton("← Volver", Color.decode("#1a1a1b"), Color.decode("#2c2c2e"));
        botonVolver.setBounds(20, 400, 110, 32);
        getContentPane().add(botonVolver);

        JButton botonJugar = Main.crearBoton("Jugar", Color.decode("#538d4e"), Color.decode("#6aaf5e"));
        botonJugar.setBounds(474, 400, 110, 32);
        getContentPane().add(botonJugar);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setVisible(true);
                dispose();
            }
        });

        botonJugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SeleccionDeNivel seleccionDeNivel = new SeleccionDeNivel(main);
                seleccionDeNivel.setVisible(true);
                dispose();
            }
        });
    }
}
