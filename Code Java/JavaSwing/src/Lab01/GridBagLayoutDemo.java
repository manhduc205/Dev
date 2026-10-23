/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab01;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author DucPc
 */
public class GridBagLayoutDemo extends JFrame {
    public GridBagLayoutDemo() {
        setTitle("Demo");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JButton("Button 1"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(new JButton("Button 2"), gbc);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridBagLayoutDemo();
    }
}
