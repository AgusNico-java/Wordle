package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Instrucciones extends JFrame {

    private static final Color BG         = Color.decode("#121213");
    private static final Color TEXT       = Color.WHITE;
    private static final Color TEXT_MUTED = Color.decode("#818384");

    public Instrucciones(Main parent) {
        initialize(parent);
    }

    private void initialize(Main parent) {
        setSize(620, 480);
        setLocationRelativeTo(parent);
        setTitle("Wordle");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(BG);
        getContentPane().setLayout(null);

        JLabel titulo = new JLabel("¿Cómo jugar?");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titulo.setForeground(TEXT);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(0, 25, 620, 35);
        getContentPane().add(titulo);

        JLabel subtitulo = new JLabel("Adiviná la palabra en 6 intentos");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitulo.setForeground(TEXT_MUTED);
        subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        subtitulo.setBounds(0, 65, 620, 20);
        getContentPane().add(subtitulo);

        agregarRegla(90,  Color.decode("#538d4e"), "Verde",    "La letra está en la palabra y en la posición correcta.");
        agregarRegla(145, Color.decode("#b59f3b"), "Amarillo", "La letra está en la palabra pero en posición incorrecta.");
        agregarRegla(200, Color.decode("#3a3a3c"), "Gris",     "La letra no está en la palabra.");

        JLabel nota = new JLabel("Cada intento debe ser una palabra válida de la longitud correcta.");
        nota.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        nota.setForeground(TEXT_MUTED);
        nota.setHorizontalAlignment(SwingConstants.CENTER);
        nota.setBounds(0, 270, 620, 20);
        getContentPane().add(nota);

        JButton botonVolver = Main.crearBoton("← Volver", Color.decode("#1a1a1b"), Color.decode("#2c2c2e"));
        botonVolver.setBounds(20, 400, 110, 32);
        getContentPane().add(botonVolver);

        JButton botonJugar = Main.crearBoton("Jugar", Color.decode("#538d4e"), Color.decode("#6aaf5e"));
        botonJugar.setBounds(474, 400, 110, 32);
        getContentPane().add(botonJugar);

        botonVolver.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                dispose();
            }
        });

        botonJugar.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                SeleccionDeNivel seleccionDeNivel = new SeleccionDeNivel(parent);
                seleccionDeNivel.setVisible(true);
                dispose();
            }
        });
    }

    private void agregarRegla(int y, Color color, String nombreColor, String descripcion) {
        // bloque total: 35 + 10 + 70 + 10 + 375 = 500px → inicio: (620-500)/2 = 60
        int x = 60;

        JPanel indicador = new JPanel();
        indicador.setBackground(color);
        indicador.setBorder(BorderFactory.createLineBorder(color.darker(), 1));
        indicador.setBounds(x, y, 35, 35);
        getContentPane().add(indicador);

        JLabel lblColor = new JLabel(nombreColor);
        lblColor.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblColor.setForeground(TEXT);
        lblColor.setBounds(x + 45, y, 70, 35);
        getContentPane().add(lblColor);

        JLabel lblDesc = new JLabel(descripcion);
        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblDesc.setForeground(TEXT_MUTED);
        lblDesc.setBounds(x + 125, y, 375, 35);
        getContentPane().add(lblDesc);
    }
}
