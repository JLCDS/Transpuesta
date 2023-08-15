import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MatrizTranspuesta {
    private int n;
    private List<List<JTextField>> matriz = new ArrayList<>();

    public MatrizTranspuesta() {
        JFrame frame = new JFrame("Matriz Transpuesta App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        JLabel sizeLabel = new JLabel("Tamaño de la matriz:");
        JTextField sizeField = new JTextField(1);
        JButton submitButton = new JButton("Aceptar");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n = Integer.parseInt(sizeField.getText());
                crearMatrizPanel(frame);
            }
        });

        inputPanel.add(sizeLabel);
        inputPanel.add(sizeField);
        inputPanel.add(submitButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void crearMatrizPanel(JFrame frame) {
        JPanel matrizPanel = new JPanel(new GridLayout(n, n));

        for (int i = 0; i < n; i++) {
            List<JTextField> fila = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                JTextField textField = new JTextField(5);
                fila.add(textField);
                matrizPanel.add(textField);
            }
            matriz.add(fila);
        }

        JButton generarButton = new JButton("Generar Matriz Transpuesta");
        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarMatrizTranspuesta(frame);
            }
        });

        matrizPanel.add(generarButton);
        frame.getContentPane().removeAll();
        frame.add(matrizPanel, BorderLayout.CENTER);
        frame.pack();
    }

    private void generarMatrizTranspuesta(JFrame frame) {
        List<List<Integer>> matrizTranspuesta = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            List<Integer> columnaTranspuesta = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int valor = Integer.parseInt(matriz.get(i).get(j).getText());
                columnaTranspuesta.add(valor);
            }
            matrizTranspuesta.add(columnaTranspuesta);
        }

        mostrarMatrizTranspuesta(matrizTranspuesta);
    }

    private void mostrarMatrizTranspuesta(List<List<Integer>> matrizTranspuesta) {
        JFrame resultFrame = new JFrame("Matriz Transpuesta Generada");
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultFrame.setLayout(new FlowLayout());

        JTextArea resultArea = new JTextArea(10, 20);
        resultArea.setEditable(false);

        StringBuilder contenido = new StringBuilder();
        for (List<Integer> fila : matrizTranspuesta) {
            contenido.append(fila.toString()).append("\n");
        }
        resultArea.setText(contenido.toString());

        resultFrame.add(new JScrollPane(resultArea));
        resultFrame.pack();
        resultFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MatrizTranspuesta();
            }
        });
    }
}
