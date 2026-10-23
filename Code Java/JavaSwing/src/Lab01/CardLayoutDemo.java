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
public class CardLayoutDemo extends JFrame {
    private CardLayout card;
    private JPanel cardPanel;

    public CardLayoutDemo() {
        setTitle("Demo");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        card = new CardLayout();
        cardPanel = new JPanel(card);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);

        cardPanel.add(redPanel, "Red");
        cardPanel.add(greenPanel, "Green");

        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(e -> card.next(cardPanel));

        add(cardPanel, BorderLayout.CENTER);
        add(btnNext, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CardLayoutDemo();
    }
}
