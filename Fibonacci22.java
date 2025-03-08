import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SerieFibonacci extends JFrame {
    private JPanel contentPane;
    private JTextField txtNumero;
    private JTextArea txtResultado;

    public SerieFibonacci() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 255));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblNumero = new JLabel("Ingrese un número:");
        lblNumero.setFont(new Font("Arial Black", Font.PLAIN, 11));
        lblNumero.setBounds(10, 20, 120, 25);
        contentPane.add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(140, 20, 100, 25);
        contentPane.add(txtNumero);

        JButton btnCalcular = new JButton("Calcular Fibonacci");
        btnCalcular.setFont(new Font("Arial Black", Font.PLAIN, 10));
        btnCalcular.setBounds(140, 60, 150, 25);
        contentPane.add(btnCalcular);

        txtResultado = new JTextArea();
        txtResultado.setBounds(10, 100, 360, 150);
        txtResultado.setEditable(false);
        contentPane.add(txtResultado);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(txtNumero.getText());
                String resultado = calcularFibonacci(numero);
                txtResultado.setText(resultado);
            }
        });
    }

    private String calcularFibonacci(int numero) {
        int a = 0, b = 1, c;
        StringBuilder sb = new StringBuilder("Serie Fibonacci: " + a + " " + b);
        int suma = a + b;

        for (int i = 2; i < numero; i++) {
            c = a + b;
            sb.append(" ").append(c);
            suma += c;
            a = b;
            b = c;
        }

        sb.append("\nSuma total: ").append(suma);
        return sb.toString();
    }

    public static void main(String[] args) {
        SerieFibonacci frame = new SerieFibonacci();
        frame.setVisible(true);
    }
}