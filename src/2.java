import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    JTextField display;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public SimpleCalculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
            "+", "1", "2", "3",
            "-", "4", "5", "6",
            "*", "7", "8", "9",
            "/", ".", "0", "="
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if ("0123456789.".contains(cmd)) {
            display.setText(display.getText() + cmd);
        } else if ("+-*/".contains(cmd)) {
            num1 = Double.parseDouble(display.getText());
            operator = cmd.charAt(0);
            display.setText("");
        } else if ("=".equals(cmd)) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            display.setText(num1 + "" + operator + num2 + "=" + result);
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
