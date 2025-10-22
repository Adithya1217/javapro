// File: EmployeeManagementForm.java

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class EmployeeManagementForm extends JFrame implements ActionListener {
    private JTextField nameField, deptField, salaryField;
    private JButton submitButton;
    private DefaultTableModel tableModel;
    private JTable employeeTable;

    public EmployeeManagementForm() {
        setTitle("Employee Management Form");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Department:"));
        deptField = new JTextField();
        formPanel.add(deptField);

        formPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        formPanel.add(salaryField);

        formPanel.add(new JLabel(""));
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        formPanel.add(submitButton);

        // Table
        tableModel = new DefaultTableModel(new Object[]{"Name", "Department", "Salary"}, 0);
        employeeTable = new JTable(tableModel);

        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(employeeTable), BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText().trim();
        String dept = deptField.getText().trim();
        String salary = salaryField.getText().trim();

        if (name.isEmpty() || dept.isEmpty() || salary.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }
        try {
            double sal = Double.parseDouble(salary);
            tableModel.addRow(new Object[]{name, dept, sal});
            nameField.setText("");
            deptField.setText("");
            salaryField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Salary must be a number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeManagementForm());
    }
}
