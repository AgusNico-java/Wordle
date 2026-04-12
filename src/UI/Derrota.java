package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Derrota extends JFrame {

    private static final Color BG         = Color.decode("#121213");
    private static final Color TEXT       = Color.WHITE;
    private static final Color TEXT_MUTED = Color.decode("#818384");
    private static final Color RED        = Color.decode("#8b2020");

    private String palabraSecreta;

    public Derrota(JFrame main, String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
        initialize(main);
    }

    private void initialize(JFrame main) {
        setSize(620, 480);
        setLocationRelativeTo(main);
        setTitle("Wordle");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(BG);
        getContentPane().setLayout(null);

        JLabel titulo = new JLabel("¡PERDISTE!");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titulo.setForeground(RED);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(0, 50, 620, 50);
        getContentPane().add(titulo);

        JLabel etiqueta = new JLabel("La palabra secreta era:");
        etiqueta.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        etiqueta.setForeground(TEXT_MUTED);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setBounds(0, 120, 620, 25);
        getContentPane().add(etiqueta);

        JLabel lblPalabra = new JLabel(this.palabraSecreta.toUpperCase());
        lblPalabra.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblPalabra.setForeground(TEXT);
        lblPalabra.setHorizontalAlignment(SwingConstants.CENTER);
        lblPalabra.setBounds(0, 150, 620, 40);
        getContentPane().add(lblPalabra);

        JButton botonMenuPrincipal = Main.crearBoton("Volver al inicio", Color.decode("#3a3a3c"), Color.decode("#535355"));
        botonMenuPrincipal.setBounds(138, 310, 155, 35);
        getContentPane().add(botonMenuPrincipal);

        JButton botonIntentarDeNuevo = Main.crearBoton("Intentar de nuevo", Color.decode("#538d4e"), Color.decode("#6aaf5e"));
        botonIntentarDeNuevo.setBounds(328, 310, 160, 35);
        getContentPane().add(botonIntentarDeNuevo);

        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                main.setVisible(true);
                dispose();
            }
        });

        botonIntentarDeNuevo.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                SeleccionDeNivel seleccionDeNivel = new SeleccionDeNivel(main);
                seleccionDeNivel.setVisible(true);
                dispose();
            }
        });
    }
}
