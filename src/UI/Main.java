package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
<<<<<<< HEAD

public class Main extends JFrame {

    private static final Color BG          = Color.decode("#121213");
=======
import javax.swing.WindowConstants;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
	private static final Color BG          = Color.decode("#121213");
>>>>>>> master
    private static final Color BTN_PRIMARY = Color.decode("#538d4e");
    private static final Color BTN_HOVER   = Color.decode("#6aaf5e");
    private static final Color BTN_DANGER  = Color.decode("#3a3a3c");
    private static final Color BTN_DANGER_HOVER = Color.decode("#535355");
    private static final Color BTN_GHOST   = Color.decode("#1a1a1b");
    private static final Color BTN_GHOST_HOVER = Color.decode("#2c2c2e");
    private static final Color TEXT_PRIMARY = Color.WHITE;
    private static final Color TEXT_MUTED   = Color.decode("#818384");

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main window = new Main();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Main() {
        initialize();
    }

    private void initialize() {
        setSize(620, 480);
        setLocationRelativeTo(null);
<<<<<<< HEAD
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
=======
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
>>>>>>> master
        setTitle("Wordle");
        getContentPane().setBackground(BG);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("WORDLE");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 38));
        lblTitulo.setForeground(Color.decode("#538d4e"));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 50, 620, 50);
        getContentPane().add(lblTitulo);

        JLabel lblPregunta = new JLabel("¿Querés jugar?");
        lblPregunta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblPregunta.setForeground(TEXT_MUTED);
        lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
        lblPregunta.setBounds(0, 110, 620, 25);
        getContentPane().add(lblPregunta);

        JButton newGameButton = crearBoton("Sí", BTN_PRIMARY, BTN_HOVER);
        newGameButton.setBounds(200, 160, 100, 38);
        getContentPane().add(newGameButton);

        JButton noButton = crearBoton("No", BTN_DANGER, BTN_DANGER_HOVER);
        noButton.setBounds(320, 160, 100, 38);
        getContentPane().add(noButton);

        JLabel lblCurso = new JLabel("TP Programación III · Com 01");
        lblCurso.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblCurso.setForeground(TEXT_MUTED);
        lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurso.setBounds(0, 230, 620, 18);
        getContentPane().add(lblCurso);

        JLabel lblIntegrantes = new JLabel("Rocha · Gomez Rodriguez · Sangueso · Taibo Cruz");
        lblIntegrantes.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblIntegrantes.setForeground(Color.decode("#505052"));
        lblIntegrantes.setHorizontalAlignment(SwingConstants.CENTER);
        lblIntegrantes.setBounds(0, 250, 620, 18);
        getContentPane().add(lblIntegrantes);

        JButton instruccionesButton = crearBoton("Cómo Jugar", BTN_GHOST, BTN_GHOST_HOVER);
        instruccionesButton.setBounds(30, 390, 140, 32);
        getContentPane().add(instruccionesButton);

        JButton recordsButton = crearBoton("Records", BTN_GHOST, BTN_GHOST_HOVER);
        recordsButton.setBounds(434, 390, 140, 32);
        getContentPane().add(recordsButton);

        newGameButton.addActionListener(new ActionListener() {
<<<<<<< HEAD
            public void actionPerformed(ActionEvent e) {
=======
            @Override
			public void actionPerformed(ActionEvent e) {
>>>>>>> master
                SeleccionDeNivel seleccionDeNivel = new SeleccionDeNivel(Main.this);
                seleccionDeNivel.setVisible(true);
                setVisible(false);
            }
        });

        noButton.addActionListener(new ActionListener() {
<<<<<<< HEAD
            public void actionPerformed(ActionEvent e) {
=======
            @Override
			public void actionPerformed(ActionEvent e) {
>>>>>>> master
                System.exit(0);
            }
        });

        instruccionesButton.addActionListener(new ActionListener() {
<<<<<<< HEAD
            public void actionPerformed(ActionEvent e) {
=======
            @Override
			public void actionPerformed(ActionEvent e) {
>>>>>>> master
                Instrucciones instrucciones = new Instrucciones(Main.this);
                instrucciones.setVisible(true);
                setVisible(false);
            }
        });

        recordsButton.addActionListener(new ActionListener() {
<<<<<<< HEAD
            public void actionPerformed(ActionEvent e) {
=======
            @Override
			public void actionPerformed(ActionEvent e) {
>>>>>>> master
                Records records = new Records(Main.this);
                records.setVisible(true);
                setVisible(false);
            }
        });
    }

    static JButton crearBoton(String texto, Color normal, Color hover) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setForeground(Color.WHITE);
        btn.setBackground(normal);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createEmptyBorder(6, 16, 6, 16));
        btn.addMouseListener(new MouseAdapter() {
<<<<<<< HEAD
            public void mouseEntered(MouseEvent e) { btn.setBackground(hover); }
            public void mouseExited(MouseEvent e)  { btn.setBackground(normal); }
=======
            @Override
			public void mouseEntered(MouseEvent e) { btn.setBackground(hover); }
            @Override
			public void mouseExited(MouseEvent e)  { btn.setBackground(normal); }
>>>>>>> master
        });
        return btn;
    }
}
