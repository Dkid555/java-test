package data.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator extends JFrame implements ActionListener {

    static JFrame frame;
    static JTextField result;
    static String a = "", b = "", operation = "";

    public void windowClosing(WindowEvent e) {
        dispose();
    }


    public static void main(String[] args) {

        Calculator listen = new Calculator();
        //System.out.println("Hello");
        frame = new JFrame("Calculator");
        result = new JTextField(16);
        result.setEditable(false);


        //result.setText("test info");
        ArrayList<JButton> buttons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            JButton jTmpButton = new JButton(Integer.toString(i));
            jTmpButton.addActionListener(listen);
            buttons.add(jTmpButton);
        }

        List<String> oper = Arrays.asList("+", "-", "/", "*", "c","=");

        JPanel panel = new JPanel();
        buttons.forEach(panel::add);
        oper.forEach(it -> {
            JButton jTmpButton = new JButton(it);
            jTmpButton.addActionListener(listen);
            panel.add(jTmpButton);
        });
        GridLayout layout = new GridLayout(4, 4);
        panel.setLayout(layout);

        JPanel mainPanel = new JPanel();
        mainPanel.add(result);
        mainPanel.add(panel);

        frame.add(mainPanel);

        frame.setSize(360, 180);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //return;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());

        String s = e.getActionCommand();

        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            if (operation.equals("")) {
                a = a + s;
            } else {
                b = b + s;
            }
            result.setText(a + operation + b);


        } else if (s.charAt(0) == 'c') {
            a = b = operation = "";
            result.setText(a + operation + b);
        } else if (s.charAt(0) == '=') {
            int rslt = switch (operation) {
                case "+" -> Integer.parseInt(a) + Integer.parseInt(b);
                case "-" -> Integer.parseInt(a) - Integer.parseInt(b);
                //case "*" ->
                case "/" -> Integer.parseInt(a) / Integer.parseInt(b);
                default -> Integer.parseInt(a) * Integer.parseInt(b);
            };
            a = String.valueOf(rslt);
            result.setText(a);
            operation = b = "";
        } else {
            if (operation.equals("")) {
                operation = s;
                result.setText(a + operation + b);
            }
        }
    }

}

