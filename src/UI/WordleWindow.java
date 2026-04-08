package UI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import logica.modelo.EstadoDeJuego;
import logica.modelo.Juego;
import logica.modelo.LetraArriesgada;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class WordleWindow extends JFrame {

    private Juego juego;
    public JTextField ingresoDePalabra;

    private JPanel grillaPalabras;

    private static final int CELL_SIZE   = 45;
    private static final int GRID_X      = 10;
    private static final int GRID_Y      = 110;
    private static final int GRID_WIDTH  = 400;
    private static final int GRID_HEIGHT = 300;

    public WordleWindow(JFrame parent, String dificultad) {
        this.juego = new Juego(dificultad);
        getContentPane().setLayout(null);

        JLabel titulo = new JLabel("JUEGO EN CURSO");
        titulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        titulo.setBounds(127, 10, 198, 36);
        getContentPane().add(titulo);

        ingresoDePalabra = new JTextField();
        ingresoDePalabra.setBounds(4, 78, 184, 24);
        getContentPane().add(ingresoDePalabra);
        ingresoDePalabra.setColumns(10);
        ingresoDePalabra.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ') e.consume();
                if (ingresoDePalabra.getText().length() >= juego.getNumeroDeLetras()) e.consume();
            }
        });

        JLabel etiquetaIngresoPalabra = new JLabel("Ingrese una palabra");
        etiquetaIngresoPalabra.setFont(new Font("Tahoma", Font.PLAIN, 12));
        etiquetaIngresoPalabra.setBounds(10, 55, 141, 24);
        getContentPane().add(etiquetaIngresoPalabra);

        grillaPalabras = new JPanel();
        grillaPalabras.setBounds(GRID_X, GRID_Y, GRID_WIDTH, GRID_HEIGHT);
        grillaPalabras.setBackground(Color.decode("#121213"));
        getContentPane().add(grillaPalabras);

        JLabel intentosRestantes = new JLabel("INTENTOS RESTANTES: ");
        intentosRestantes.setBounds(10, 430, 124, 24);
        getContentPane().add(intentosRestantes);

        JLabel numeroIntentos = new JLabel(String.valueOf(juego.getIntentos()));
        numeroIntentos.setBounds(144, 436, 44, 12);
        getContentPane().add(numeroIntentos);

        JLabel lblPalabraSecreta = new JLabel(juego.palabraSecreta);
        lblPalabraSecreta.setBounds(185, 432, 71, 20);
        getContentPane().add(lblPalabraSecreta);

        JButton btnRendirse = new JButton("RENDIRSE");
        btnRendirse.addActionListener(e -> {
            dispose();
            parent.setVisible(true);
        });
        btnRendirse.setBounds(324, 431, 84, 20);
        getContentPane().add(btnRendirse);

        JButton botonArriesgar = new JButton("ARRIESGAR");
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
        botonArriesgar.setBounds(198, 77, 101, 24);
        getContentPane().add(botonArriesgar);

        initialize();
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
        celda.setFont(new Font("Arial", Font.BOLD, 20));
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

    private void initialize() {
        setBounds(100, 100, 450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}