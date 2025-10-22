// File: LoginForm.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// LoginForm class creates a simple login GUI
public class LoginForm extends JFrame implements ActionListener {
    // GUI components
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Hardcoded credentials
    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";

    public LoginForm() {
        // Set up the frame
        setTitle("Login Form");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create panel and layout
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        // Add username label and text field
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        // Add password label and password field
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Add empty label and login button
        panel.add(new JLabel(""));
        loginButton = new JButton("Login");
        loginButton.addActionListener(this); // Register event handler
        panel.add(loginButton);

        // Add panel to frame
        add(panel);

        setVisible(true);
    }

    // Handle button click event
    public void actionPerformed(ActionEvent e) {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        // Validate credentials
        if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
            JOptionPane.showMessageDialog(this, "Login Successful");
        } else {
            JOptionPane.showMessageDialog(this, "Login Failed");
        }
    }

    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new LoginForm());
    }
}
