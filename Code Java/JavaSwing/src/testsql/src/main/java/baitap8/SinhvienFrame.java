package baitap8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class SinhvienFrame extends JFrame {

    private JList<String> studentList;
    private DefaultListModel<String> listModel;
    private JTextField txtMaSV, txtHoTen, txtTuoi;
    private JButton btnAdd, btnRemove, btnUpdate, btnClear;

    private SinhvienDAO sinhvienDao;

    private List<Sinhvien> listSinhvienData = new ArrayList<>();

    public SinhvienFrame() {
        sinhvienDao = new SinhvienDAO();
        initFrame();
        loaddata();    
    }

    public void initFrame() {
        setTitle("Quan ly sinh vien");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("THONG TIN SINH VIEN", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(Color.RED);
        add(lblTitle, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10)); 
        add(mainPanel, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("Danh sach sinh vien..."));

        listModel = new DefaultListModel<>();
        studentList = new JList<>(listModel);
        leftPanel.add(new JScrollPane(studentList), BorderLayout.CENTER);
        
        mainPanel.add(leftPanel);

        JPanel rightPanel = new JPanel(new BorderLayout()); 
        
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblMa = new JLabel("Ma sinh vien:");
        JLabel lblHoTen = new JLabel("Ho va ten:");
        JLabel lblTuoi = new JLabel("Tuoi:");

        txtMaSV = new JTextField(15);
        txtHoTen = new JTextField(15);
        txtTuoi = new JTextField(15);

        gbc.gridy = 0; gbc.gridx = 0;
        inputPanel.add(lblMa, gbc);
        gbc.gridx = 1;
        inputPanel.add(txtMaSV, gbc);

        gbc.gridy = 1; gbc.gridx = 0;
        inputPanel.add(lblHoTen, gbc);
        gbc.gridx = 1;
        inputPanel.add(txtHoTen, gbc);

        gbc.gridy = 2; gbc.gridx = 0;
        inputPanel.add(lblTuoi, gbc);
        gbc.gridx = 1;
        inputPanel.add(txtTuoi, gbc);
        
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(inputPanel, BorderLayout.NORTH);
        rightPanel.add(wrapperPanel, BorderLayout.CENTER);

        mainPanel.add(rightPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15)); 
        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        btnUpdate = new JButton("Update");
        btnClear = new JButton("Clear");

        btnAdd.addActionListener(e -> add());
        btnClear.addActionListener(e -> clear());
        btnUpdate.addActionListener(e -> update());
        btnRemove.addActionListener(e -> remove());
        
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnRemove);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnClear);

        add(buttonPanel, BorderLayout.SOUTH);
        
        studentList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = studentList.getSelectedIndex();
                if (index >= 0) {
                    displayAccountToForm(index);
                }
            }
        });
    }
    public void loaddata() {
        try {
            List<Sinhvien> list = sinhvienDao.getAllSinhvien();
            listSinhvienData.clear();
            listSinhvienData.addAll(list);
            listModel.clear();
            for (Sinhvien s : list) {
                listModel.addElement(s.getTensv());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu!");
        }
    }

    public void displayAccountToForm(int rowIndex) {
        Sinhvien sv = listSinhvienData.get(rowIndex);
        txtMaSV.setText(sv.getMsv());
        txtHoTen.setText(sv.getTensv());
        txtTuoi.setText(String.valueOf(sv.getTuoi()));
        txtMaSV.setEditable(false);
    }
    
    public void add() {
        if (txtMaSV.getText().trim().isEmpty() || txtHoTen.getText().trim().isEmpty()|| txtTuoi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!","Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Sinhvien s = new Sinhvien();
        s.setMsv(txtMaSV.getText().trim());
        s.setTensv(txtHoTen.getText().trim());
        try {
            s.setTuoi(Integer.parseInt(txtTuoi.getText().trim()));
        } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(this, "Tuổi phải là số!"); return;
        }
        int result = sinhvienDao.insert(s);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
            clear();
            loaddata();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại!");
        }
    }
    
    public void update(){
        if (txtMaSV.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Sinhvien s = new Sinhvien();
        s.setMsv(txtMaSV.getText().trim());
        s.setTensv(txtHoTen.getText().trim());
        try {
             s.setTuoi(Integer.parseInt(txtTuoi.getText().trim()));
        } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(this, "Tuổi phải là số!"); return;
        }
        int result = sinhvienDao.update(s);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
            clear();
            loaddata();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại!");
        }
    }
    
    public void remove(){
        if (txtMaSV.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên cần xóa!");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sinh viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int result = sinhvienDao.delete(txtMaSV.getText().trim());
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                clear();
                loaddata();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
            }
        }
    }
    
    public void clear() {
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtTuoi.setText("");        
        txtMaSV.setEditable(true);
        studentList.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SinhvienFrame().setVisible(true));
    }
}