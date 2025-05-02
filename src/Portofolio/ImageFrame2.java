package Portofolio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ImageFrame2 extends JFrame {
    private JPanel circleCanvas;
    private JButton redButton;
    private JButton blackButton;
    private JLabel result;

    private Color currentColor;
    private int totalAnswers =0;
    private int correctAnswers =0;
    private long totalTime =0;
    private long startTime;

    private final int nrAttempts =10;
    private int attempts =0;
    private Random random = new Random();

    public ImageFrame2() {
        setTitle("Correct button application");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        setLocationRelativeTo(null);
        
        circleCanvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawCircle(g);
            }
        };
        redButton = new JButton("RED");
        blackButton = new JButton("BLACK");
        result = new JLabel("Choose the color:", JLabel.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(redButton);
        buttonPanel.add(blackButton);

        add(circleCanvas, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(result, BorderLayout.NORTH);
        redButton.addActionListener(new ButtonListener(Color.RED));
        blackButton.addActionListener(new ButtonListener(Color.BLACK));

        startNewAttempt();
    }

    private void drawCircle(Graphics g) {
        if (currentColor != null) {
            int diameter = 200;
            int x = (circleCanvas.getWidth()-diameter)/2;
            int y = (circleCanvas.getHeight()-diameter)/2;
            g.setColor(currentColor);
            g.fillOval(x, y, diameter, diameter);
        }
    }

    private void startNewAttempt() {
        if (attempts < nrAttempts) {
        	currentColor = random.nextBoolean() ? Color.RED : Color.BLACK;
        	startTime = System.currentTimeMillis();
        	circleCanvas.repaint();
        } else {
        	displayResults();
        }
    }

    private void displayResults() {
        double averageTime = (double) totalTime / totalAnswers;
        result.setText(String.format("Corecte: %d din %d. Average time: %.2f ms", correctAnswers, nrAttempts, averageTime));
        redButton.setEnabled(false);
        blackButton.setEnabled(false);
    }

    private class ButtonListener implements ActionListener {
        private Color expectedColor;
        public ButtonListener(Color expectedColor) {
            this.expectedColor = expectedColor;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            long reactionTime = System.currentTimeMillis()-startTime;
            totalAnswers++;
            totalTime += reactionTime;
            if (currentColor.equals(expectedColor)) {
            	correctAnswers++;
            }
            attempts++;
            startNewAttempt();
        }
    }

    public static void main(String... strings) {
        SwingUtilities.invokeLater(() -> {
        	ImageFrame2 frame = new ImageFrame2();
        });
    }
}