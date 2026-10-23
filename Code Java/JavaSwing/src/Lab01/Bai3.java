/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab01;

/**
 *
 * @author DucPc
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai3 extends JFrame {
    private JTextField textField;
    private JCheckBox boldCheckBox, italicCheckBox;

    public Bai3() {
        setTitle("JCheckBox Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(350, 150);
        setLocationRelativeTo(null);

        textField = new JTextField("Watch the font style change", 22);
        textField.setFont(new Font("Serif", Font.PLAIN, 16));
        add(textField);

        boldCheckBox = new JCheckBox("Bold");
        italicCheckBox = new JCheckBox("Italic");
        JPanel panel = new JPanel();
        panel.add(boldCheckBox);
        panel.add(italicCheckBox);
        add(panel);

        ItemListener fontListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int style = Font.PLAIN;
                if (boldCheckBox.isSelected() && italicCheckBox.isSelected()) {
                    style = Font.BOLD | Font.ITALIC;
                } else if (boldCheckBox.isSelected()) {
                    style = Font.BOLD;
                } else if (italicCheckBox.isSelected()) {
                    style = Font.ITALIC;
                }
                textField.setFont(new Font("Serif", style, 16));
            }
        };
        boldCheckBox.addItemListener(fontListener);
        italicCheckBox.addItemListener(fontListener);
    }

    public static void main(String[] args) {
        new Bai3().setVisible(true);     
    }
}
