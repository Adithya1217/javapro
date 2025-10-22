// File: ATMSimulation.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMSimulation extends JFrame implements ActionListener {
    private JPasswordField pinField;
    private JButton enterButton;
    private JPanel mainPanel, actionPanel;
    private double balance = 1000.0; // Initial balance
    private final String correctPIN = "1234";

    public ATMSimulation() {
        setTitle("ATM Simulation");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        mainPanel.add(new JLabel("Enter PIN:"));
        pinField = new JPasswordField();
        mainPanel.add(pinField);
        enterButton = new JButton("Enter");
        enterButton.addActionListener(this);
        mainPanel.add(new JLabel(""));
        mainPanel.add(enterButton);

        add(mainPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            String pin = new String(pinField.getPassword());
            if (pin.equals(correctPIN)) {
                showATMOptions();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect PIN!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showATMOptions() {
        // Remove PIN panel
        getContentPane().removeAll();

        actionPanel = new JPanel(new FlowLayout());
        JButton checkBalanceBtn = new JButton("Check Balance");
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");

        checkBalanceBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Balance: $" + balance));
        depositBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
            try {
                double amt = Double.parseDouble(input);
                if (amt > 0) {
                    balance += amt;
                    JOptionPane.showMessageDialog(this, "Deposited $" + amt + ". New Balance: $" + balance);
                } else {
                    JOptionPane.showMessageDialog(this, "Enter a positive amount.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input.");
            }
        });
        withdrawBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
            try {
                double amt = Double.parseDouble(input);
                if (amt > 0 && amt <= balance) {
                    balance -= amt;
                    JOptionPane.showMessageDialog(this, "Withdrew $" + amt + ". New Balance: $" + balance);
                } else if (amt > balance) {
                    JOptionPane.showMessageDialog(this, "Insufficient funds.");
                } else {
                    JOptionPane.showMessageDialog(this, "Enter a positive amount.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input.");
            }
        });

        actionPanel.add(checkBalanceBtn);
        actionPanel.add(depositBtn);
        actionPanel.add(withdrawBtn);

        add(actionPanel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ATMSimulation());
    }
}
