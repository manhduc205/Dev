/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab01;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author DucPc
 */
public class BorderLayoutDemo extends JFrame {
    public BorderLayoutDemo() {
        setTitle("Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(5, 5));

        add(new JButton("NORTH"), BorderLayout.NORTH);
        add(new JButton("SOUTH"), BorderLayout.SOUTH);
        add(new JButton("EAST"), BorderLayout.EAST);
        add(new JButton("WEST"), BorderLayout.WEST);
        add(new JButton("CENTER"), BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutDemo();
    }
}
