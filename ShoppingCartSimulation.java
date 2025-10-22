// File: ShoppingCartSimulation.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShoppingCartSimulation extends JFrame implements ActionListener {
    JCheckBox laptopBox, phoneBox, headphonesBox;
    JButton billButton;
    JTextArea resultArea;

    // Prices for items
    int laptopPrice = 800;
    int phonePrice = 500;
    int headphonesPrice = 150;

    public ShoppingCartSimulation() {
        setTitle("Shopping Cart Simulation");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new BorderLayout());

        JPanel itemsPanel = new JPanel(new GridLayout(3, 1));
        laptopBox = new JCheckBox("Laptop ($800)");
        phoneBox = new JCheckBox("Phone ($500)");
        headphonesBox = new JCheckBox("Headphones ($150)");
        itemsPanel.add(laptopBox);
        itemsPanel.add(phoneBox);
        itemsPanel.add(headphonesBox);

        billButton = new JButton("Generate Bill");
        billButton.addActionListener(this);

        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        add(itemsPanel, BorderLayout.NORTH);
        add(billButton, BorderLayout.CENTER);
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        StringBuilder bill = new StringBuilder("Selected Items:\n");
        int total = 0;
        if (laptopBox.isSelected()) {
            bill.append("Laptop - $800\n");
            total += laptopPrice;
        }
        if (phoneBox.isSelected()) {
            bill.append("Phone - $500\n");
            total += phonePrice;
        }
        if (headphonesBox.isSelected()) {
            bill.append("Headphones - $150\n");
            total += headphonesPrice;
        }
        bill.append("Total: $" + total);
        resultArea.setText(bill.toString());
        JOptionPane.showMessageDialog(this, bill.toString(), "Bill", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShoppingCartSimulation());
    }
}
