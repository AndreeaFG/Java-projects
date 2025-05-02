package Portofolio;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ImageFrame extends JFrame {
    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;
    private JPanel colorPanel;

    public ImageFrame() {
        setTitle("Setting the square color");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        setLocationRelativeTo(null);
        creationSliders();
        creationCuloarePanel();

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(3, 1));
        sliderPanel.add(redSlider);
        sliderPanel.add(greenSlider);
        sliderPanel.add(blueSlider);
        add(sliderPanel, BorderLayout.SOUTH);
        add(colorPanel, BorderLayout.CENTER);
    }

    private void creationSliders() {
    	redSlider = new JSlider(0, 255, 0);
    	redSlider.setMajorTickSpacing(50);
    	redSlider.setPaintTicks(true);
    	redSlider.setPaintLabels(true);
    	redSlider.setBorder(BorderFactory.createTitledBorder("Red"));

    	greenSlider = new JSlider(0, 255, 0);
        greenSlider.setMajorTickSpacing(50);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintLabels(true);
        greenSlider.setBorder(BorderFactory.createTitledBorder("Green"));

        blueSlider = new JSlider(0, 255, 0);
        blueSlider.setMajorTickSpacing(50);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintLabels(true);
        blueSlider.setBorder(BorderFactory.createTitledBorder("Blue"));

        ChangeListener listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateColor();
            }
        };

        redSlider.addChangeListener(listener);
        greenSlider.addChangeListener(listener);
        blueSlider.addChangeListener(listener);
    }

    private void creationCuloarePanel() {
    	colorPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
                g.fillRect(150, 150, 100, 100);
            }
        };
        colorPanel.setPreferredSize(new Dimension(800, 800));
    }

    private void updateColor() {
    	colorPanel.repaint();
    }

    public static void main(String...strings) {
        SwingUtilities.invokeLater(() -> {
            ImageFrame frame = new ImageFrame();
        });
    }
}