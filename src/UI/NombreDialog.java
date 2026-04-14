package UI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NombreDialog extends JDialog {

    private static final Color BG         = Color.decode("#121213");
    private static final Color TEXT       = Color.WHITE;
    private static final Color TEXT_MUTED = Color.decode("#818384");
    private static final Color GREEN      = Color.decode("#538d4e");

    private String nombre = null;

    public NombreDialog(JFrame parent) {
        super(parent, "Wordle", true);
        initialize(parent);
    }

    private void initialize(JFrame parent) {
        setSize(380, 200);
        setLocationRelativeTo(parent);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(BG);
        getContentPane().setLayout(null);

        JLabel label = new JLabel("Ingresá tu nombre para el ranking:");
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        label.setForeground(TEXT_MUTED);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(0, 25, 380, 20);
        getContentPane().add(label);

        JTextField inputNombre = new JTextField();
        inputNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        inputNombre.setBackground(Color.decode("#1a1a1b"));
        inputNombre.setForeground(TEXT);
        inputNombre.setCaretColor(TEXT);
        inputNombre.setHorizontalAlignment(SwingConstants.CENTER);
        inputNombre.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.decode("#3a3a3c"), 1),
            BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));
        inputNombre.setBounds(90, 60, 200, 30);
        getContentPane().add(inputNombre);

        JButton btnRegistrar = Main.crearBoton("Registrar", GREEN, Color.decode("#6aaf5e"));
        btnRegistrar.setBounds(135, 110, 110, 32);
        getContentPane().add(btnRegistrar);

        btnRegistrar.addActionListener(e -> {
            String texto = inputNombre.getText().trim();
            if (!texto.isEmpty()) {
                nombre = texto;
            }
            dispose();
        });

        inputNombre.addActionListener(e -> btnRegistrar.doClick());
    }

    public String getNombre() {
        return nombre;
    }
}
