package slip24;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scrolling Text");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        JLabel label = new JLabel("Scrolling text...");
        label.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(label);
        frame.setVisible(true);
        while (true) {
            String text = label.getText();
            text = text.substring(1) + text.substring(0, 1);
            label.setText(text);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}