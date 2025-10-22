// File: OnlineFeedbackForm.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnlineFeedbackForm extends JFrame implements ActionListener {
    private JRadioButton[] ratingButtons;
    private ButtonGroup ratingGroup;
    private JTextArea commentsArea;
    private JButton submitButton;

    public OnlineFeedbackForm() {
        setTitle("Online Feedback Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel ratingPanel = new JPanel(new FlowLayout());
        ratingPanel.add(new JLabel("Rate us:"));
        ratingButtons = new JRadioButton[5];
        ratingGroup = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            ratingButtons[i] = new JRadioButton((i + 1) + " Star");
            ratingGroup.add(ratingButtons[i]);
            ratingPanel.add(ratingButtons[i]);
        }

        commentsArea = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(commentsArea);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        setLayout(new BorderLayout());
        add(ratingPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int rating = 0;
        for (int i = 0; i < 5; i++) {
            if (ratingButtons[i].isSelected()) {
                rating = i + 1;
                break;
            }
        }
        String comments = commentsArea.getText().trim();
        if (rating == 0) {
            JOptionPane.showMessageDialog(this, "Please select a rating.");
            return;
        }
        JOptionPane.showMessageDialog(this, "Thank you for your feedback!\nRating: " + rating + " Star(s)\nComments: " + comments);
        commentsArea.setText("");
        ratingGroup.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OnlineFeedbackForm());
    }
}
