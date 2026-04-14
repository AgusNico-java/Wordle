package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import logica.modelo.Record;
import logica.modelo.RecordTable;

public class Records extends JFrame {

    private static final Color BG_COLOR = Color.decode("#121213");
    private static final Color TEXT_COLOR = Color.WHITE;
    private static final Color TITLE_COLOR = Color.decode("#538d4e");
    private static final Color BUTTON_GREEN = Color.decode("#538d4e");
    private static final Color BUTTON_GRAY = Color.decode("#3a3a3c");

    private static final Font FONT_TEXT = new Font("Segoe UI", Font.BOLD, 13);
    private static final Font FONT_TITLE = new Font("Segoe UI", Font.BOLD, 24);

    public Records(Main parent) {
        initialize(parent);
    }

    private void initialize(Main parent) {
        setSize(620, 480);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().setBackground(BG_COLOR);
        setTitle("Wordle - Ranking");

        JLabel titulo = new JLabel("RECORDS");
        titulo.setForeground(TITLE_COLOR);
        titulo.setFont(FONT_TITLE);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(0, 15, 620, 40);
        getContentPane().add(titulo);

        RecordTable tabla = new RecordTable();
        List<Record> lista = tabla.obtenerRecords();
        lista.sort((r1, r2) -> Long.compare(r1.getTime(), r2.getTime()));

        String texto = "<html><body style='font-family: Segoe UI; color: white;'>"
                     + "<h3 style='color: #818384; font-weight: normal; margin-bottom: 10px;'>MEJORES TIEMPOS</h3>"
                     + "<table style='width: 100%; color: white;'>";

        int pos = 1;
        for (Record r : lista) {
            String tiempoLindo = formatearMilisATiempo(r.getTime());
            texto += "<tr>"
                  + "<td style='width: 30px; font-weight: bold; color: #538d4e;'>" + pos + ".</td>"
                  + "<td style='font-size: 14px; padding-bottom: 5px;'>" + r.getName() + "</td>"
                  + "<td style='text-align: right; color: #818384;'>" + tiempoLindo + "</td>"
                  + "</tr>";
            pos++;
        }
        texto += "</table></body></html>";

        JLabel labelRecords = new JLabel(texto);
        labelRecords.setVerticalAlignment(JLabel.TOP);
        labelRecords.setBounds(160, 75, 300, 240);
        getContentPane().add(labelRecords);

        // --- BOTÓN VOLVER (Gris) ---
        JButton botonVolver = new JButton("Volver");
        botonVolver.setBounds(30, 395, 110, 35);
        estilizarBoton(botonVolver, BUTTON_GRAY);
        getContentPane().add(botonVolver);

        botonVolver.addActionListener(e -> {
            parent.setVisible(true);
            dispose();
        });

        // --- BOTÓN NUEVA PARTIDA (Verde) ---
        JButton botonIniciarPartida = new JButton("Nueva Partida");
        botonIniciarPartida.setBounds(429, 395, 145, 35);
        estilizarBoton(botonIniciarPartida, BUTTON_GREEN);
        getContentPane().add(botonIniciarPartida);

        botonIniciarPartida.addActionListener(e -> {
            SeleccionDeNivel seleccionDeNivel = new SeleccionDeNivel(parent);
            seleccionDeNivel.setVisible(true);
            dispose();
        });
    }

    /**
     * Aplica el estilo Wordle a los botones: fondo sólido, texto blanco, sin bordes feos.
     */
    private void estilizarBoton(JButton boton, Color colorFondo) {
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFont(FONT_TEXT);
        boton.setFocusPainted(false); // Quita el recuadro de puntos al hacer clic
        boton.setBorder(BorderFactory.createEmptyBorder()); // Quita el borde 3D
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);
    }

    private String formatearMilisATiempo(long milis) {
        long segundosTotales = milis / 1000;
        long minutos = segundosTotales / 60;
        long segundos = segundosTotales % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }
}
