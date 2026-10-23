/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab01;

/**
 *
 * @author DucPc
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Bai5 extends JFrame {
    
    private final String[] days = {
            "Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"
    };

    private final JList<String> lstDays = new JList<>(days);
    private final JLabel lblSelected = new JLabel("", SwingConstants.CENTER);

    public Bai5() {
        setTitle("ListDemo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 260);
        setLocationRelativeTo(null);

        lblSelected.setForeground(Color.BLUE);
        lblSelected.setBorder(new LineBorder(Color.BLACK, 1));


        lstDays.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lstDays.setVisibleRowCount(6);
        lstDays.addListSelectionListener(this::onListChanged);

        lstDays.setSelectedIndex(0);
        lblSelected.setText(days[0]);

        setLayout(new BorderLayout(4, 5));
        add(lblSelected, BorderLayout.NORTH);
        add(new JScrollPane(lstDays), BorderLayout.CENTER);
    }

    private void onListChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            String value = lstDays.getSelectedValue();
            if (value != null) {
                lblSelected.setText(value);
            }
        }
    }

    public static void main(String[] args) {
        new Bai5().setVisible(true);
    }
}

