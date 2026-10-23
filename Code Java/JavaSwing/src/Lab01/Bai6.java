/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab01;

/**
 *
 * @author DucPc
 */

import java.awt.FlowLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
public class Bai6 extends JFrame{
    private JList<String> listLeft, listRight;
    private DefaultListModel<String> modelLeft, modelRight;
    private JButton btnCopy;

    public Bai6() {
        initFrame();
        initGUI();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai6();
    }

    private void initFrame() {
        this.setTitle("Multiple Selection Lists");
        this.setSize(450, 250);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        String[] colors = {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Red"};

        modelLeft = new DefaultListModel<>();
        modelRight = new DefaultListModel<>();

        for (String c : colors) {
            modelLeft.addElement(c);
        }

        listLeft = new JList<>(modelLeft);
        listRight = new JList<>(modelRight);

        listLeft.setVisibleRowCount(7);
        listRight.setVisibleRowCount(7);
        listLeft.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        btnCopy = new JButton("Copy >>>");

        btnCopy.addActionListener(e -> {
            for (String item : listLeft.getSelectedValuesList()) {
                if (!modelRight.contains(item)) modelRight.addElement(item);
            }
        });

        this.add(new JScrollPane(listLeft));
        this.add(btnCopy);
        this.add(new JScrollPane(listRight));
    }
}
