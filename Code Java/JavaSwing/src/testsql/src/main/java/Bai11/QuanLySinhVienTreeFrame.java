/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai11;

/**
 *
 * @author DucPc
 */


import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.tree.*;

public class QuanLySinhVienTreeFrame extends JFrame {

    private JTree treeLopHoc;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode rootNode;

    private JList<SinhVien> listSinhVien;
    private DefaultListModel<SinhVien> listModel;

    private JTextField txtMaSV, txtHoTen, txtTuoi;
    private JButton btnAddSV, btnRemoveSV, btnUpdateSV, btnClearSV;

    // DAO
    private LopHocDAO lopHocDAO;
    private SinhVienDAO sinhVienDAO;

    // Biến lưu trạng thái
    private LopHoc currentSelectedLop = null;

    public QuanLySinhVienTreeFrame() {
        // Khởi tạo DAO
        lopHocDAO = new LopHocDAO();
        sinhVienDAO = new SinhVienDAO();

        initUI();
        loadTreeData(); // Tải dữ liệu từ DB lên Tree
    }

    private void initUI() {
        setTitle("Quản lý sinh viên (JTree & JDBC)");
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header
        JLabel lblTitle = new JLabel("THÔNG TIN SINH VIÊN", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(Color.BLUE);
        add(lblTitle, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // --- LEFT PANEL (TREE) ---
        rootNode = new DefaultMutableTreeNode("Danh sách lớp học");
        treeModel = new DefaultTreeModel(rootNode);
        treeLopHoc = new JTree(treeModel);

        // Sự kiện chọn Node trên Tree
        treeLopHoc.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode selectedNode = 
                (DefaultMutableTreeNode) treeLopHoc.getLastSelectedPathComponent();
            
            if (selectedNode != null && selectedNode.getUserObject() instanceof LopHoc) {
                currentSelectedLop = (LopHoc) selectedNode.getUserObject();
                loadSinhVienList(currentSelectedLop.getMaLop());
            } else {
                currentSelectedLop = null;
                listModel.clear();
            }
        });

        JScrollPane treeScroll = new JScrollPane(treeLopHoc);
        treeScroll.setBorder(BorderFactory.createTitledBorder("Danh sách lớp học"));
        
        JPanel leftContainer = new JPanel(new BorderLayout());
        leftContainer.add(treeScroll, BorderLayout.CENTER);
        // Nút chức năng cho lớp (nếu cần phát triển thêm)
        JPanel pnlLopBtn = new JPanel();
        pnlLopBtn.add(new JButton("Add Class")); 
        pnlLopBtn.add(new JButton("Delete Class"));
        leftContainer.add(pnlLopBtn, BorderLayout.SOUTH);
        
        mainPanel.add(leftContainer);

        // --- RIGHT PANEL (LIST & FORM) ---
        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        
        // List Sinh Viên
        listModel = new DefaultListModel<>();
        listSinhVien = new JList<>(listModel);
        listSinhVien.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) fillForm();
        });

        JScrollPane listScroll = new JScrollPane(listSinhVien);
        listScroll.setBorder(BorderFactory.createTitledBorder("Danh sách sinh viên..."));
        listScroll.setPreferredSize(new Dimension(0, 200));
        rightPanel.add(listScroll, BorderLayout.NORTH);

        // Form nhập liệu
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; inputPanel.add(new JLabel("Mã SV:"), gbc);
        gbc.gridx = 1; txtMaSV = new JTextField(20); inputPanel.add(txtMaSV, gbc);

        gbc.gridx = 0; gbc.gridy = 1; inputPanel.add(new JLabel("Họ tên:"), gbc);
        gbc.gridx = 1; txtHoTen = new JTextField(20); inputPanel.add(txtHoTen, gbc);

        gbc.gridx = 0; gbc.gridy = 2; inputPanel.add(new JLabel("Tuổi:"), gbc);
        gbc.gridx = 1; txtTuoi = new JTextField(20); inputPanel.add(txtTuoi, gbc);

        rightPanel.add(inputPanel, BorderLayout.CENTER);

        // Buttons
        JPanel btnPanel = new JPanel(new FlowLayout());
        btnAddSV = new JButton("Add");
        btnRemoveSV = new JButton("Remove");
        btnUpdateSV = new JButton("Update");
        btnClearSV = new JButton("Clear");

        btnAddSV.addActionListener(e -> addStudent());
        btnRemoveSV.addActionListener(e -> deleteStudent());
        btnUpdateSV.addActionListener(e -> updateStudent());
        btnClearSV.addActionListener(e -> clearForm());

        btnPanel.add(btnAddSV);
        btnPanel.add(btnRemoveSV);
        btnPanel.add(btnUpdateSV);
        btnPanel.add(btnClearSV);

        rightPanel.add(btnPanel, BorderLayout.SOUTH);

        mainPanel.add(rightPanel);
        add(mainPanel, BorderLayout.CENTER);
    }

    // --- LOGIC NGHIỆP VỤ ---

    private void loadTreeData() {
        rootNode.removeAllChildren();
        List<LopHoc> list = lopHocDAO.getAllLopHoc();
        for (LopHoc lh : list) {
            // Node chứa Object LopHoc
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(lh);
            rootNode.add(node);
        }
        treeModel.reload();
        // Mở rộng cây
        for (int i = 0; i < treeLopHoc.getRowCount(); i++) treeLopHoc.expandRow(i);
    }

    private void loadSinhVienList(String maLop) {
        listModel.clear();
        List<SinhVien> list = sinhVienDAO.getSinhVienByLop(maLop);
        for (SinhVien sv : list) {
            listModel.addElement(sv);
        }
    }

    private void fillForm() {
        SinhVien sv = listSinhVien.getSelectedValue();
        if (sv != null) {
            txtMaSV.setText(sv.getMaSV());
            txtHoTen.setText(sv.getHoTen());
            txtTuoi.setText(String.valueOf(sv.getTuoi()));
            txtMaSV.setEditable(false); // Khóa mã khi xem/sửa
        }
    }

    private void clearForm() {
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtTuoi.setText("");
        txtMaSV.setEditable(true);
        listSinhVien.clearSelection();
    }

    private void addStudent() {
        if (currentSelectedLop == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Lớp học trên cây trước!");
            return;
        }
        if (txtMaSV.getText().isEmpty() || txtHoTen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập đầy đủ thông tin!");
            return;
        }

        try {
            SinhVien sv = new SinhVien(
                txtMaSV.getText(),
                txtHoTen.getText(),
                Integer.parseInt(txtTuoi.getText()),
                currentSelectedLop.getMaLop()
            );

            if (sinhVienDAO.insert(sv)) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                loadSinhVienList(currentSelectedLop.getMaLop());
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại (Trùng mã SV?)");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tuổi phải là số!");
        }
    }

    private void updateStudent() {
        if (listSinhVien.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn sinh viên cần sửa!");
            return;
        }
        try {
            SinhVien sv = new SinhVien(
                txtMaSV.getText(), // Mã SV cũ (đã khóa không cho sửa)
                txtHoTen.getText(),
                Integer.parseInt(txtTuoi.getText()),
                currentSelectedLop.getMaLop()
            );

            if (sinhVienDAO.update(sv)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                loadSinhVienList(currentSelectedLop.getMaLop());
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tuổi phải là số!");
        }
    }

    private void deleteStudent() {
        SinhVien sv = listSinhVien.getSelectedValue();
        if (sv == null) {
            JOptionPane.showMessageDialog(this, "Chọn sinh viên cần xóa!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Xóa sinh viên: " + sv.getHoTen() + "?");
        if (confirm == JOptionPane.YES_OPTION) {
            if (sinhVienDAO.delete(sv.getMaSV())) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                loadSinhVienList(currentSelectedLop.getMaLop());
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuanLySinhVienTreeFrame().setVisible(true));
    }
}
