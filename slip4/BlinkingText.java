import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class BlinkingText implements Runnable {
    private volatile boolean running = true;

    @Override
    public void run() {
        JFrame frame = new JFrame("Blinking Text");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JLabel label = new JLabel("Blinking Text");
        frame.add(label);
        frame.setVisible(true);

        while (running) {
            try {
                Thread.sleep(500); // Blink every 500 milliseconds (half a second)
                SwingUtilities.invokeLater(() -> label.setVisible(!label.isVisible())); // Toggle visibility
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
    }

    public static void main(String[] args) {
        BlinkingText blinkingText = new BlinkingText();
        Thread thread = new Thread(blinkingText);
        thread.start();

        // Close the window after 10 seconds
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        blinkingText.stop();
    }
}