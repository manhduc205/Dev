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

public class TabbedPaneLayoutDemo extends JFrame {
    public TabbedPaneLayoutDemo() {
        setTitle("Demo");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("tab 1", new JLabel("tab1"));
        tabs.addTab("tab 2", new JLabel("tab2"));
        tabs.addTab("tab 3", new JLabel("tab3"));

        add(tabs);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TabbedPaneLayoutDemo();
    }
}
