package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
<<<<<<< HEAD
=======
import javax.swing.WindowConstants;
>>>>>>> master

import logica.modelo.Dificultad;

public class SeleccionDeNivel extends JFrame {

    private static final Color BG       = Color.decode("#121213");
    private static final Color TEXT     = Color.WHITE;
    private static final Color TEXT_MUTED = Color.decode("#818384");

    private static final Color FACIL_COLOR   = Color.decode("#538d4e");
    private static final Color MEDIO_COLOR   = Color.decode("#b59f3b");
    private static final Color DIFICIL_COLOR = Color.decode("#8b2020");

    private final ButtonGroup buttonGroup = new ButtonGroup();

    public SeleccionDeNivel(JFrame parent) {
        initialize(parent);
    }

    private void initialize(JFrame parent) {
        setSize(620, 480);
        setLocationRelativeTo(parent);
<<<<<<< HEAD
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
=======
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
>>>>>>> master
        setTitle("Wordle");
        getContentPane().setBackground(BG);
        getContentPane().setLayout(null);

        JLabel titulo = new JLabel("Seleccioná el nivel");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titulo.setForeground(TEXT);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(0, 40, 620, 35);
        getContentPane().add(titulo);

        JLabel subtitulo = new JLabel("¿Cuántas letras querés adivinar?");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitulo.setForeground(TEXT_MUTED);
        subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        subtitulo.setBounds(0, 85, 620, 20);
        getContentPane().add(subtitulo);

        JButton botonIniciarPartida = Main.crearBoton("Jugar!", FACIL_COLOR, FACIL_COLOR.brighter());
        botonIniciarPartida.setBounds(454, 395, 120, 35);
        botonIniciarPartida.setEnabled(false);
        botonIniciarPartida.setBackground(Color.decode("#3a3a3c"));
        getContentPane().add(botonIniciarPartida);

        JButton botonVolver = Main.crearBoton("← Volver", Color.decode("#1a1a1b"), Color.decode("#2c2c2e"));
        botonVolver.setBounds(20, 395, 110, 35);
        getContentPane().add(botonVolver);

        JRadioButton facilRadioButton   = crearRadioButton("Fácil  · 5 letras");
        JRadioButton medioRadioButton   = crearRadioButton("Medio  · 6 letras");
        JRadioButton dificilRadioButton = crearRadioButton("Difícil · 7 letras");

        buttonGroup.add(facilRadioButton);
        buttonGroup.add(medioRadioButton);
        buttonGroup.add(dificilRadioButton);

        facilRadioButton.setBounds(210, 140, 200, 35);
        medioRadioButton.setBounds(210, 195, 200, 35);
        dificilRadioButton.setBounds(210, 250, 200, 35);

        facilRadioButton.setActionCommand(Dificultad.FACIL.getNombre());
        medioRadioButton.setActionCommand(Dificultad.MEDIO.getNombre());
        dificilRadioButton.setActionCommand(Dificultad.DIFICIL.getNombre());

        facilRadioButton.addActionListener(new ActionListener() {
<<<<<<< HEAD
            public void actionPerformed(ActionEvent e) {
=======
            @Override
			public void actionPerformed(ActionEvent e) {
>>>>>>> master
                getContentPane().setBackground(mezclarConFondo(FACIL_COLOR, 0.08f));
                botonIniciarPartida.setBackground(FACIL_COLOR);
                botonIniciarPartida.setEnabled(true);
                repintarRadioButtons(facilRadioButton, medioRadioButton, dificilRadioButton);
            }
        });

        medioRadioButton.addActionListener(new ActionListener() {
<<<<<<< HEAD
            public void actionPerformed(ActionEvent e) {
=======
            @Override
			public void actionPerformed(ActionEvent e) {
>>>>>>> master
                getContentPane().setBackground(mezclarConFondo(MEDIO_COLOR, 0.08f));
                botonIniciarPartida.setBackground(MEDIO_COLOR);
                botonIniciarPartida.setEnabled(true);
                repintarRadioButtons(facilRadioButton, medioRadioButton, dificilRadioButton);
            }
        });

        dificilRadioButton.addActionListener(new ActionListener() {
<<<<<<< HEAD
            public void actionPerformed(ActionEvent e) {
=======
            @Override
			public void actionPerformed(ActionEvent e) {
>>>>>>> master
                getContentPane().setBackground(mezclarConFondo(DIFICIL_COLOR, 0.08f));
                botonIniciarPartida.setBackground(DIFICIL_COLOR);
                botonIniciarPartida.setEnabled(true);
                repintarRadioButtons(facilRadioButton, medioRadioButton, dificilRadioButton);
            }
        });

        getContentPane().add(facilRadioButton);
        getContentPane().add(medioRadioButton);
        getContentPane().add(dificilRadioButton);

        botonVolver.addActionListener(new ActionListener() {
<<<<<<< HEAD
            public void actionPerformed(ActionEvent e) {
=======
            @Override
			public void actionPerformed(ActionEvent e) {
>>>>>>> master
                parent.setVisible(true);
                dispose();
            }
        });

        botonIniciarPartida.addActionListener(new ActionListener() {
<<<<<<< HEAD
            public void actionPerformed(ActionEvent e) {
=======
            @Override
			public void actionPerformed(ActionEvent e) {
>>>>>>> master
                String dificultad = buttonGroup.getSelection().getActionCommand();
                WordleWindow wordleWindow = new WordleWindow(parent, dificultad);
                wordleWindow.setVisible(true);
                setVisible(false);
            }
        });
    }

    private JRadioButton crearRadioButton(String texto) {
        JRadioButton rb = new JRadioButton(texto);
        rb.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        rb.setForeground(TEXT_MUTED);
        rb.setBackground(BG);
        rb.setOpaque(false);
        rb.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rb.setBorder(BorderFactory.createEmptyBorder(4, 12, 4, 12));
        rb.addMouseListener(new MouseAdapter() {
<<<<<<< HEAD
            public void mouseEntered(MouseEvent e) { rb.setForeground(TEXT); }
            public void mouseExited(MouseEvent e)  {
                if (!rb.isSelected()) rb.setForeground(TEXT_MUTED);
=======
            @Override
			public void mouseEntered(MouseEvent e) { rb.setForeground(TEXT); }
            @Override
			public void mouseExited(MouseEvent e)  {
                if (!rb.isSelected()) {
					rb.setForeground(TEXT_MUTED);
				}
>>>>>>> master
            }
        });
        return rb;
    }

    private void repintarRadioButtons(JRadioButton... botones) {
        for (JRadioButton rb : botones) {
            rb.setForeground(rb.isSelected() ? TEXT : TEXT_MUTED);
        }
    }

    private Color mezclarConFondo(Color color, float alpha) {
        int r = (int) (BG.getRed()   + (color.getRed()   - BG.getRed())   * alpha);
        int g = (int) (BG.getGreen() + (color.getGreen() - BG.getGreen()) * alpha);
        int b = (int) (BG.getBlue()  + (color.getBlue()  - BG.getBlue())  * alpha);
        return new Color(r, g, b);
    }
}
