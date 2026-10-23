/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab01;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author DucPc
 */
public class GridLayoutDemo extends JFrame {
    public GridLayoutDemo() {
        setTitle("Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(2, 3));

        
        add(new JButton("Button " + 2));
        add(new JButton("Button " + 3));
        add(new JButton("Button " + 4));
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutDemo();
    }
}
