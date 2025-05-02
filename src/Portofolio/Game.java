package Portofolio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private JButton startStopButton;
    private DrawingCanvas canvasCircle;
    private boolean displacement;
    private Thread animationThread;

    public Game() {
        setTitle("Displacement circle");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        setLocationRelativeTo(null);
        
        startStopButton = new JButton("Start");
        startStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displacement) {
                    stopAnimation();
                } else {
                    startAnimation();
                }
            }
        });
        canvasCircle = new DrawingCanvas();
        add(startStopButton, BorderLayout.NORTH);
        add(canvasCircle, BorderLayout.CENTER);
    }

    private void startAnimation() {
    	displacement = true;
        startStopButton.setText("Stop");
        animationThread = new Thread(new Runnable() {
            @Override
            public void run() {
            	canvasCircle.animate();
            }
        });
        animationThread.start();
    }

    private void stopAnimation() {
    	displacement = false;
        startStopButton.setText("Start");
        animationThread.interrupt();
    }

    private class DrawingCanvas extends JPanel {
        private int x = 0, y = 0;
        private int dx = 2, dy = 2;
        private final int diameter = 80;

        public DrawingCanvas() {
            setBackground(Color.WHITE);
        }

        public void animate() {
            while (displacement) {
                x += dx;
                y += dy;

                if (x + diameter > getWidth() || x<0) {
                    dx = -dx;
                }
                if (y + diameter > getHeight() || y<0) {
                    dy = -dy;
                }
                repaint();

                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.MAGENTA);
            g.fillOval(x, y, diameter, diameter);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	Game frame = new Game();
            }
        });
    }
}