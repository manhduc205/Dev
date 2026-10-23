/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab01;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Bai2 extends JFrame {
    private JTextField txtF;
    private JTextField txtC;
    private JButton btnCalculate;
    private JButton btnContinue;
    private JButton btnExit;

    public Bai2() {
        setTitle("Convert from F to C!");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // F
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblF = new JLabel("Nhập vào độ F:");
        lblF.setForeground(Color.RED);
        
        mainPanel.add(lblF, gbc);

        gbc.gridx = 1;
        txtF = new JTextField(15);
        mainPanel.add(txtF, gbc);

        // C
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lblC = new JLabel("Độ C tương ứng:");
        lblC.setForeground(Color.RED);
        
        mainPanel.add(lblC, gbc);

        gbc.gridx = 1;
        txtC = new JTextField(15);
        txtC.setEditable(false);
        txtC.setBackground(Color.WHITE);
        mainPanel.add(txtC, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JPanel buttonPanel = new JPanel(new FlowLayout());

        btnCalculate = new JButton("Tính");
        btnCalculate.setBackground(Color.LIGHT_GRAY);

        btnContinue = new JButton("Tiếp tục");
        btnContinue.setBackground(Color.LIGHT_GRAY);

        btnExit = new JButton("Thoát");
        btnExit.setBackground(Color.LIGHT_GRAY);

        buttonPanel.add(btnCalculate);
        buttonPanel.add(btnContinue);
        buttonPanel.add(btnExit);

        mainPanel.add(buttonPanel, gbc);
        add(mainPanel);

        // sự kiện
        btnCalculate.addActionListener(this::calculate);
        btnContinue.addActionListener(e -> reset());
        btnExit.addActionListener(e -> System.exit(0));

        txtF.addActionListener(this::calculate);

        setVisible(true);
    }

    private void calculate(ActionEvent e) {
        String input = txtF.getText().trim();

        try {
            if (input.isEmpty()) {
                throw new NumberFormatException();
            }

            double f = Double.parseDouble(input);
            double c = (f - 32) / 1.8;

            txtC.setText(String.format("%.3f", c));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Dữ liệu không hợp lệ!",
                    "Message",
                    JOptionPane.ERROR_MESSAGE);
            txtF.requestFocus();
            txtF.selectAll();
        }
    }

    private void reset() {
        txtF.setText("");
        txtC.setText("");
        txtF.requestFocus();
    }

    public static void main(String[] args) {
        new Bai2();
    }
}

