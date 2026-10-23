/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyUser;

/**
 *
 * @author DucPc
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UserFrame extends JFrame {
    // Các components giao diện
    private JTextField txtUserId, txtUsername, txtEmail, txtPassword;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnAdd, btnUpdate, btnDelete, btnClear, btnRefresh;

    private UserDAO userDAO;

    public UserFrame() {
        userDAO = new UserDAO();
        initComponents();
        loadTableData();
    }

    private void initComponents() {     
        setTitle("Quản Lý User");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ===== PANEL NHẬP LIỆU (Bên trái) =====
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Thông Tin User"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // User ID
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("User ID:"), gbc);
        gbc.gridx = 1;
        txtUserId = new JTextField(20);
        txtUserId.setEditable(true); 
        inputPanel.add(txtUserId, gbc);

        // Username
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        txtUsername = new JTextField(20);
        inputPanel.add(txtUsername, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        txtEmail = new JTextField(20);
        inputPanel.add(txtEmail, gbc);

        // Password
        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        txtPassword = new JTextField(20); // Dùng JTextField để dễ nhìn demo
        inputPanel.add(txtPassword, gbc);

        // nút cn
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 5, 5));       

        btnAdd = new JButton("Thêm Mới");
        
        btnAdd.addActionListener(e -> addUser());
        btnUpdate = new JButton("Cập Nhật");          
        btnUpdate.addActionListener(e -> updateUser());
        btnDelete = new JButton("Xóa");
        btnDelete.addActionListener(e -> deleteUser());
        btnClear = new JButton("Làm Mới");
        btnClear.addActionListener(e -> clearFields());     
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);       
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(inputPanel, BorderLayout.CENTER);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

       
        String[] columns = {"User ID", "Username", "Email", "Password"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    displayUserToForm(selectedRow);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Danh Sách User"));
        add(leftPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
    }

    // load dl database vào bảng
    private void loadTableData() {
        tableModel.setRowCount(0); 
        List<User> users = userDAO.getAllUsers();
        for (User u : users) {
            Object[] row = {
                u.getUserid(),
                u.getUsername(),
                u.getEmail(),
                u.getPassword()
            };
            tableModel.addRow(row);
        }
    }

    // ===== HIỂN THỊ LÊN FORM KHI CLICK =====
    private void displayUserToForm(int rowIndex) {
        txtUserId.setText(tableModel.getValueAt(rowIndex, 0).toString());
        txtUsername.setText(tableModel.getValueAt(rowIndex, 1).toString());
        txtEmail.setText(tableModel.getValueAt(rowIndex, 2).toString());
        txtPassword.setText(tableModel.getValueAt(rowIndex, 3).toString());
        
        txtUserId.setEditable(false); 
    }

    // ===== THÊM MỚI =====
    private void addUser() {
        if (txtUserId.getText().trim().isEmpty() || txtUsername.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ID và Username!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User u = new User();
        u.setUserid(txtUserId.getText().trim());
        u.setUsername(txtUsername.getText().trim());
        u.setEmail(txtEmail.getText().trim());
        u.setPassword(txtPassword.getText().trim());

        if (userDAO.insert(u) > 0) {
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
            clearFields();
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại (Trùng ID?)!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===== CẬP NHẬT =====
    private void updateUser() {
        if (txtUserId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn user để cập nhật!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User u = new User();
        u.setUserid(txtUserId.getText().trim()); // ID lấy từ ô text (đang bị khóa nếu click từ bảng)
        u.setUsername(txtUsername.getText().trim());
        u.setEmail(txtEmail.getText().trim());
        u.setPassword(txtPassword.getText().trim());

        if (userDAO.update(u) > 0) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            clearFields();
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteUser() {
       
        if (txtUserId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "hay chọn user can xoa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String id = txtUserId.getText().trim();
        if (userDAO.delete(id) > 0) {
            JOptionPane.showMessageDialog(this, "Xoa thanh cong!");
            clearFields();   
            loadTableData(); 
        } else {
            JOptionPane.showMessageDialog(this, "Xoa that bai", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtUserId.setText("");
        txtUserId.setEditable(true); // Mở lại ID để nhập mới
        txtUsername.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        table.clearSelection();
    }
}
