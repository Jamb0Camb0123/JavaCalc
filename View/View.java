package View;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private JTextField display;

    public View() {
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 5, 5));
        String[][] buttons = {
                {"+/-", "CE", "C", "<x"},
                {"x^2", "√", "%", "/"},
                {"7", "8", "9", "x"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "+"},
                {"0", ".", "\"\"", "="}
        };

        for (String[] row : buttons) {
            for (String label : row) {
                JButton button = new JButton(label);
                button.setFont(new Font("Arial", Font.PLAIN, 20));
                buttonPanel.add(button);
                // Future: add button.addActionListener(...) here
            }
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    public void launch() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }

    public JTextField getDisplay() {
        return display;
    }
}
