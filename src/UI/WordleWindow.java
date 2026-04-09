package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import logica.modelo.EstadoDeJuego;
import logica.modelo.Juego;
import logica.modelo.LetraArriesgada;

public class WordleWindow extends JFrame {

    private static final Color BG       = Color.decode("#121213");
    private static final Color TEXT     = Color.WHITE;
    private static final Color TEXT_MUTED = Color.decode("#818384");

    private static final int CELL_SIZE   = 45;
    private static final int GRID_X      = 75;
    private static final int GRID_Y      = 115;
    private static final int GRID_WIDTH  = 400;
    private static final int GRID_HEIGHT = 300;

    private Juego juego;
    private JTextField ingresoDePalabra;
    private JPanel grillaPalabras;

    public WordleWindow(JFrame parent, String dificultad) {
        this.juego = new Juego(dificultad);

        setSize(550, 520);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wordle");
        getContentPane().setBackground(BG);
        getContentPane().setLayout(null);

        JLabel titulo = new JLabel("WORDLE");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(Color.decode("#538d4e"));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(0, 15, 550, 30);
        getContentPane().add(titulo);

        JLabel lblPalabraSecreta = new JLabel("Palabra secreta: " + juego.palabraSecreta);
        lblPalabraSecreta.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblPalabraSecreta.setForeground(TEXT_MUTED);
        lblPalabraSecreta.setBounds(10, 15, 200, 20);
        getContentPane().add(lblPalabraSecreta);

        JLabel etiqueta = new JLabel("Ingresá una palabra");
        etiqueta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        etiqueta.setForeground(TEXT_MUTED);
        etiqueta.setBounds(75, 58, 150, 20);
        getContentPane().add(etiqueta);

        ingresoDePalabra = new JTextField();
        ingresoDePalabra.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        ingresoDePalabra.setBackground(Color.decode("#1a1a1b"));
        ingresoDePalabra.setForeground(TEXT);
        ingresoDePalabra.setCaretColor(TEXT);
        ingresoDePalabra.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.decode("#3a3a3c"), 1),
            BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));
        ingresoDePalabra.setBounds(75, 80, 240, 28);
        ingresoDePalabra.setColumns(10);
        ingresoDePalabra.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ') e.consume();
                if (ingresoDePalabra.getText().length() >= juego.getNumeroDeLetras()) e.consume();
            }
        });
        getContentPane().add(ingresoDePalabra);

        JButton botonArriesgar = Main.crearBoton("Arriesgar", Color.decode("#538d4e"), Color.decode("#6aaf5e"));
        botonArriesgar.setBounds(325, 80, 110, 28);
        getContentPane().add(botonArriesgar);

        grillaPalabras = new JPanel();
        grillaPalabras.setBounds(GRID_X, GRID_Y, GRID_WIDTH, GRID_HEIGHT);
        grillaPalabras.setBackground(BG);
        getContentPane().add(grillaPalabras);

        JPanel panelIntentos = new JPanel();
        panelIntentos.setLayout(null);
        panelIntentos.setBackground(Color.decode("#1a1a1b"));
        panelIntentos.setBorder(BorderFactory.createLineBorder(Color.decode("#3a3a3c"), 1));
        panelIntentos.setBounds(75, 425, 200, 30);
        getContentPane().add(panelIntentos);

        JLabel intentosLabel = new JLabel("Intentos restantes:");
        intentosLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        intentosLabel.setForeground(TEXT_MUTED);
        intentosLabel.setBounds(8, 7, 140, 16);
        panelIntentos.add(intentosLabel);

        JLabel numeroIntentos = new JLabel(String.valueOf(juego.getIntentos()));
        numeroIntentos.setFont(new Font("Segoe UI", Font.BOLD, 12));
        numeroIntentos.setForeground(Color.decode("#538d4e"));
        numeroIntentos.setBounds(152, 7, 30, 16);
        panelIntentos.add(numeroIntentos);

        JButton btnRendirse = Main.crearBoton("Rendirse", Color.decode("#3a3a3c"), Color.decode("#535355"));
        btnRendirse.setBounds(390, 425, 100, 30);
        getContentPane().add(btnRendirse);

        botonArriesgar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                juego.verificarPalabra(ingresoDePalabra.getText());
                numeroIntentos.setText(String.valueOf(juego.getIntentos()));
                actualizarGrilla(juego.getPalabrasUsadas());
                ingresoDePalabra.setText("");

                if (juego.getEstadoDeJuego().equals(EstadoDeJuego.DERROTA)) {
                    dispararPantallaDerrota(parent);
                }
                if (juego.getEstadoDeJuego().equals(EstadoDeJuego.VICTORIA)) {
                    dispararPantallaVictoria(parent);
                }
            }
        });

        ingresoDePalabra.addActionListener(e -> botonArriesgar.doClick());

        btnRendirse.addActionListener(e -> {
            dispose();
            parent.setVisible(true);
        });
    }

    private void actualizarGrilla(List<LetraArriesgada[]> palabrasUsadas) {
        grillaPalabras.removeAll();

        if (palabrasUsadas == null || palabrasUsadas.isEmpty()) {
            grillaPalabras.revalidate();
            grillaPalabras.repaint();
            return;
        }

        int columnas = palabrasUsadas.get(0).length;
        int filas    = palabrasUsadas.size();

        grillaPalabras.setLayout(new GridLayout(filas, columnas, 5, 5));

        for (LetraArriesgada[] intento : palabrasUsadas) {
            for (LetraArriesgada letra : intento) {
                grillaPalabras.add(crearCeldaLetra(letra));
            }
        }

        grillaPalabras.revalidate();
        grillaPalabras.repaint();
    }

    private JLabel crearCeldaLetra(LetraArriesgada letra) {
        JLabel celda = new JLabel(
            String.valueOf(letra.getLetra()).toUpperCase(),
            SwingConstants.CENTER
        );
        celda.setFont(new Font("Segoe UI", Font.BOLD, 20));
        celda.setForeground(Color.WHITE);
        celda.setOpaque(true);
        celda.setBackground(Color.decode(letra.getColor()));
        celda.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
        celda.setBorder(BorderFactory.createLineBorder(Color.decode("#3a3a3c"), 2));
        return celda;
    }

    private void dispararPantallaVictoria(JFrame parent) {
        Victoria victoria = new Victoria(parent, juego.getTiempoDeJuego());
        victoria.setVisible(true);
        setVisible(false);
    }

    private void dispararPantallaDerrota(JFrame parent) {
        Derrota derrota = new Derrota(parent, juego.palabraSecreta);
        derrota.setVisible(true);
        setVisible(false);
    }
}
