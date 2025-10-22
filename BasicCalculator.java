// File: BasicCalculator.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicCalculator extends JFrame implements ActionListener {
    private JTextField displayField;
    private StringBuilder currentInput = new StringBuilder();

    public BasicCalculator() {
        setTitle("Basic Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "=", "+", "C"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            buttonPanel.add(btn);
        }

        setLayout(new BorderLayout());
        add(displayField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = ((JButton) e.getSource()).getText();
        if (cmd.equals("=")) {
            try {
                double result = eval(currentInput.toString());
                displayField.setText(String.valueOf(result));
                currentInput.setLength(0);
            } catch (Exception ex) {
                displayField.setText("Error");
                currentInput.setLength(0);
            }
        } else if (cmd.equals("C")) {
            currentInput.setLength(0);
            displayField.setText("");
        } else {
            currentInput.append(cmd);
            displayField.setText(currentInput.toString());
        }
    }

    // Simple expression evaluator (supports +, -, *, /)
    private double eval(String expr) {
        // Use ScriptEngine for simplicity
        try {
            return Double.parseDouble(new javax.script.ScriptEngineManager()
                .getEngineByName("JavaScript").eval(expr).toString());
        } catch (Exception e) {
            throw new RuntimeException("Invalid Expression");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BasicCalculator());
    }
}
