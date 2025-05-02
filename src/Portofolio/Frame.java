package Portofolio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Frame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField numeField;
    private JTextField prenumeField;
    private JComboBox<String> anStudiuComboBox;
    private JComboBox<String> facultateComboBox;
    private JRadioButton taxaRadioButton;
    private JRadioButton bugetRadioButton;
    private JComboBox<String> cursComboBox;
    private JTextArea informatiiTextArea;

    public Frame() {
        setTitle("Formular de inregistrare curs online");
        setSize(900, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 4, 9, 9));
        setVisible(true);
        setLocationRelativeTo(null);
        
        numeField = new JTextField(30);
        prenumeField = new JTextField(30);

        String[] aniStudiu = {"1", "2", "3", "4"};
        anStudiuComboBox = new JComboBox<>(aniStudiu);

        String[] facultati = {"ETTI", "Automatica si Calculatoare", "Constructii", "Instalatii"};
        facultateComboBox = new JComboBox<>(facultati);

        bugetRadioButton = new JRadioButton("Buget");
        taxaRadioButton = new JRadioButton("Taxa");

        ButtonGroup finantareGrup = new ButtonGroup();
        finantareGrup.add(taxaRadioButton);
        finantareGrup.add(bugetRadioButton);

        String[] cursuri = {"Programare Java", "Programare C", "Programare C++"};
        cursComboBox = new JComboBox<>(cursuri);

        informatiiTextArea = new JTextArea(5, 20);
        informatiiTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(informatiiTextArea);

        JButton inregistrareButton = new JButton("Inregistrare");
        inregistrareButton.addActionListener(new InregistrareButtonListener());

        add(new JLabel("Nume:"));
        add(numeField);
        add(new JLabel("Prenume:"));
        add(prenumeField);
        add(new JLabel("Anul de studii:"));
        add(anStudiuComboBox);
        add(new JLabel("Facultatea:"));
        add(facultateComboBox);
        add(new JLabel("Finantare:"));
        add(bugetRadioButton);
        add(new JLabel());
        add(taxaRadioButton);
        add(new JLabel("Cursul dorit:"));
        add(cursComboBox);
        add(inregistrareButton);
        add(new JLabel());
        add(new JLabel("Informatii student:"));
        add(scrollPane);
    }

    private class InregistrareButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nume = numeField.getText();
            String prenume = prenumeField.getText();
            String anStudiu = (String) anStudiuComboBox.getSelectedItem();
            String facultate = (String) facultateComboBox.getSelectedItem();
            String finantare = bugetRadioButton.isSelected() ? "Buget" : taxaRadioButton.isSelected() ? "Taxa" : "Neselectat";
            String curs = (String) cursComboBox.getSelectedItem();

            String informatii = String.format("Nume: %s\nPrenume: %s\nAnul de studii: %s\nFacultatea: %s\nFinantare: %s\nCurs dorit: %s",
                    nume, prenume, anStudiu, facultate, finantare, curs);

            informatiiTextArea.setText(informatii);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\ImageFrame\\PbFrame.txt", true))) {
                writer.write(informatii);
                writer.newLine();
                writer.newLine();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Eroare la salvarea datelor în fisier!", "Eroare", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String... strings) {
        SwingUtilities.invokeLater(() -> {
            Frame frame = new Frame();
        });
    }
}
