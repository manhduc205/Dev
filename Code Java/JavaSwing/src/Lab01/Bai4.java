package Lab01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Bai4 extends JFrame {

    private JTextField txtFullName, txtResult;
    private JRadioButton rdMr, rdMiss;
    private JButton btnWelcome, btnClear, btnCancel;
    private ButtonGroup bg;

    public Bai4() {
        setTitle("Welcome to!");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Color red = Color.RED;
        Color blue = Color.BLUE;

        gbc.gridx = 0; 
        gbc.gridy = 0;
        JLabel lblName = new JLabel("Full name:");
        lblName.setForeground(red);
        panel.add(lblName, gbc);

        gbc.gridx = 1;
        txtFullName = new JTextField(18);
        panel.add(txtFullName, gbc);

        TitledBorder tb = BorderFactory.createTitledBorder("Gender");
        tb.setTitleColor(blue);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.setBorder(tb);

        rdMr = new JRadioButton("Mr.");
        rdMiss = new JRadioButton("Miss");

        bg = new ButtonGroup();
        bg.add(rdMr);
        bg.add(rdMiss);

        genderPanel.add(rdMr);
        genderPanel.add(rdMiss);

        gbc.gridx = 1; 
        gbc.gridy = 1;
        panel.add(genderPanel, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 2;
        JLabel lblResult = new JLabel("Result:");
        lblResult.setForeground(red);
        panel.add(lblResult, gbc);

        gbc.gridx = 1;
        txtResult = new JTextField(18);
        txtResult.setEditable(false);
        txtResult.setForeground(red);
        panel.add(txtResult, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));

        btnWelcome = new JButton("Welcome");
        btnClear = new JButton("Clear");
        btnCancel = new JButton("Cancel");

        btnWelcome.setForeground(blue);
        btnClear.setForeground(blue);
        btnCancel.setForeground(blue);

        buttonPanel.add(btnWelcome);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnCancel);

        gbc.gridx = 0; 
        gbc.gridy = 3; 
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(buttonPanel, gbc);

        add(panel);

        btnWelcome.addActionListener(e -> handleWelcome());
        btnClear.addActionListener(e -> handleClear());
        btnCancel.addActionListener(e -> handleExit());
    }

    private void handleWelcome() {
        String name = txtFullName.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your full name!");
            return;
        }

        if (!rdMr.isSelected() && !rdMiss.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please choose gender!");
            return;
        }

        String gender = rdMr.isSelected() ? "Mr." : "Miss";
        txtResult.setText("Welcome " + gender + " " + name);
    }

    private void handleClear() {
        txtFullName.setText("");
        txtResult.setText("");
        bg.clearSelection();
        txtFullName.requestFocus();
    }

    private void handleExit() {
        int r = JOptionPane.showConfirmDialog(this,
                "Are you sure to exit?", "Confirm",
                JOptionPane.YES_NO_OPTION);
        if (r == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new Bai4().setVisible(true);
    }
}
