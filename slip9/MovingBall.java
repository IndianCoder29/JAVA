package slip9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovingBall {
    private static final int BALL_SIZE = 20;
    private static final int PANEL_HEIGHT = 200;
    private int y = PANEL_HEIGHT / 2;
    private int direction = 1;

    public static void main(String[] args) {
        new MovingBall().createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Moving Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.fillOval(getWidth() / 2 - BALL_SIZE / 2, y, BALL_SIZE,
                        BALL_SIZE);
            }
        };
        panel.setPreferredSize(new Dimension(400, PANEL_HEIGHT));
        JButton button = new JButton("Start");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            y += direction;
                            if (y == PANEL_HEIGHT - BALL_SIZE || y == 0) {
                                direction *= -1;
                            }
                            panel.repaint();
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
        frame.add(panel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}