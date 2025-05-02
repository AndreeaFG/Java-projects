package Portofolio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColoredCircleFrame extends JFrame {
    private int colorIndex = 0;

    public ColoredCircleFrame(String title) {
        setTitle(title);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Timer timer = new Timer(1000, e -> repaint());
        timer.start();

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = 100;
        g.setColor(getNextColor());
        int diameter = radius * 2;
        g.fillOval(centerX - radius, centerY - radius, diameter, diameter);
    }

    private Color getNextColor() {
        colorIndex = (colorIndex + 20) % 256;
        return new Color(colorIndex, 0, 0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColoredCircleFrame("Colored circle"));
    }
}
