package Portofolio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageFrame3 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField red;
    private JTextField green;
    private JTextField blue;
    private JLabel result;

    public ImageFrame3() {
        setTitle("Colors graphic application");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 3));
        setVisible(true);
        setLocationRelativeTo(null);
        
        red = new JTextField();
        green = new JTextField();
        blue = new JTextField();
        JLabel redLabel = new JLabel("R:");
        JLabel greenLabel = new JLabel("G:");
        JLabel blueLabel = new JLabel("B:");
        JButton resultCulorButton = new JButton("Result color");
        resultCulorButton.addActionListener(new ShowColorButtonListener());
        result = new JLabel("Quantities of colors", SwingConstants.CENTER);
        result.setOpaque(true);
        add(redLabel);
        add(red);
        add(greenLabel);
        add(green);
        add(blueLabel);
        add(blue);
        add(resultCulorButton);
        add(result);
    }

    private class ShowColorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int r = Integer.parseInt(red.getText());
                int g = Integer.parseInt(green.getText());
                int b = Integer.parseInt(blue.getText());
                if (r<0 || r>255 || g<0 || g>255 || b<0 || b>255){
                    throw new NumberFormatException();
                }
                Color color = new Color(r, g, b);
                result.setText(String.format("R: %d, G: %d, B: %d", r, g, b));
                result.setBackground(color);
                result.setForeground(Color.BLACK);
            } catch (NumberFormatException ex) {
            	result.setText("Incorrect values! Values must be between 0-255.");
            	result.setBackground(Color.WHITE);
            	result.setForeground(Color.RED);
            }
        }
    }

    public static void main(String...strings) {
        SwingUtilities.invokeLater(() -> {
            ImageFrame3 frame = new ImageFrame3();
        });
    }
}