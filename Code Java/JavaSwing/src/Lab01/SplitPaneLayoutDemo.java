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

public class SplitPaneLayoutDemo extends JFrame {
    public SplitPaneLayoutDemo() {
        setTitle("Demo");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea leftArea = new JTextArea("Left Panel");
        leftArea.setBackground(Color.GREEN);

        JTextArea rightArea = new JTextArea("Right Panel");
        rightArea.setBackground(Color.RED);

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(leftArea),
                new JScrollPane(rightArea)
        );

        splitPane.setDividerLocation(200);
        splitPane.setOneTouchExpandable(true);
        add(splitPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SplitPaneLayoutDemo());
    }
}

