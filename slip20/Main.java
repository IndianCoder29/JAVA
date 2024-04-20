package slip20;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Blinking Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        // Create a new JLabel with an ImageIcon
        ImageIcon icon = new ImageIcon("path_to_your_image_file"); // replace with your image file path
        JLabel label = new JLabel(icon);
        frame.getContentPane().add(label, BorderLayout.CENTER);
        // Create a new Timer that calls actionPerformed every 500 ms
        new Timer(500, e -> {
            // Each time actionPerformed is called, toggle the visibility of the label
            label.setVisible(!label.isVisible());
        }).start();
        // Make the JFrame visible
        frame.setVisible(true);
    }
}