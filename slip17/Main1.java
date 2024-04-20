package slip17;

import javax.swing.*;
import java.awt.event.*;

public class Main1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Display");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField textField = new JTextField();
        JButton button = new JButton("Start");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    public void run() {
                        for (int i = 1; i <= 100; i++) {
                            textField.setText(String.valueOf(i));
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
        frame.getContentPane().add(textField, "North");
        frame.getContentPane().add(button, "South");
        frame.setVisible(true);
    }
}