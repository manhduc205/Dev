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

public class SpringLayoutDemo extends JFrame {
    public SpringLayoutDemo() {
        setTitle("Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        JLabel lbl = new JLabel("Name:");
        JTextField txt = new JTextField(15);
        JButton btn = new JButton("OK");
        add(lbl);
        add(txt);
        add(btn);
        layout.putConstraint(SpringLayout.WEST, lbl, 20, SpringLayout.WEST, this.getContentPane());
        layout.putConstraint(SpringLayout.NORTH, lbl, 30, SpringLayout.NORTH, this.getContentPane());
        layout.putConstraint(SpringLayout.WEST, txt, 10, SpringLayout.EAST, lbl);
        layout.putConstraint(SpringLayout.NORTH, txt, 30, SpringLayout.NORTH, this.getContentPane());
        layout.putConstraint(SpringLayout.WEST, btn, 0, SpringLayout.WEST, txt);
        layout.putConstraint(SpringLayout.NORTH, btn, 20, SpringLayout.SOUTH, txt);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SpringLayoutDemo();
    }
}
