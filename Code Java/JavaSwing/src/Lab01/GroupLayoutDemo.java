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

public class GroupLayoutDemo extends JFrame {
    public GroupLayoutDemo() {
        setTitle("GroupLayout Demo");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblName = new JLabel("Name:");
        JTextField txtName = new JTextField(15);
        JButton btnOk = new JButton("OK");
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(lblName)
                .addComponent(txtName)
                .addComponent(btnOk)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblName)
                .addComponent(txtName)
                .addComponent(btnOk)
        );

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GroupLayoutDemo();
    }
}