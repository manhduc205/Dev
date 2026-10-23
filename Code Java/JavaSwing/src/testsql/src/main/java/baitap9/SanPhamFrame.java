package baitap9;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.List;

public class SanPhamFrame extends JFrame {

    private JTextField txtId, txtName, txtPrice, txtQuantity, txtDescription;
    private JComboBox<Category> cbCategory;

    private JTable tblProduct;
    private DefaultTableModel model;

    private DefaultListModel<Category> categoryListModel;
    private JList<Category> categoryList;

    private final SanPhamDAO dao = new SanPhamDAO();
    private final CategoryDAO categoryDAO = new CategoryDAO(); 
    private DanhMucSanPham danhMuc = new DanhMucSanPham();

    public SanPhamFrame() {
        setTitle("Quản lý sản phẩm");
        setSize(1000, 600); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initUI();
        loadCategories();
        loadTable(); 
    }

    private void initUI() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem writeDataItem = new JMenuItem("Write Data to disk");
        JMenuItem openDataItem = new JMenuItem("Open Data from disk");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(writeDataItem);
        fileMenu.add(openDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        writeDataItem.addActionListener(e -> writeDataToDisk());
        openDataItem.addActionListener(e -> openDataFromDisk());
        exitItem.addActionListener(e -> System.exit(0));

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Quản lý sản phẩm");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.RED);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("Danh mục sản phẩm"));
        leftPanel.setPreferredSize(new Dimension(300, 0));

        categoryListModel = new DefaultListModel<>();
        categoryList = new JList<>(categoryListModel);
        categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        categoryList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                filterProductsByCategory();
            }
        });

        JScrollPane categoryScrollPane = new JScrollPane(categoryList);
        leftPanel.add(categoryScrollPane, BorderLayout.CENTER);

        JPanel categoryButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JButton btnNewCategory = new JButton("New");
        JButton btnUpdateCategory = new JButton("Update");
        JButton btnRemoveCategory = new JButton("Remove"); 
        
        categoryButtonPanel.add(btnNewCategory);
        categoryButtonPanel.add(btnUpdateCategory);
        categoryButtonPanel.add(btnRemoveCategory);
        leftPanel.add(categoryButtonPanel, BorderLayout.SOUTH);

        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết"));

        String[] cols = {"Product ID", "Product Name", "UnitPrice", "Quantity", "Description", "Category"};
        model = new DefaultTableModel(cols, 0);
        tblProduct = new JTable(model);
        tblProduct.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                fillForm();
            }
        });

        JScrollPane tableScrollPane = new JScrollPane(tblProduct);
        tableScrollPane.setPreferredSize(new Dimension(0, 200)); 
        rightPanel.add(tableScrollPane, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; 
        formPanel.add(new JLabel("Category :"), gbc);
        cbCategory = new JComboBox<>();
        gbc.gridx = 1; gbc.gridy = 0; gbc.gridwidth = 2; 
        formPanel.add(cbCategory, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; formPanel.add(new JLabel("Product ID:"), gbc);
        txtId = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 1; gbc.gridwidth = 2; formPanel.add(txtId, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1; formPanel.add(new JLabel("Product Name:"), gbc);
        txtName = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 2; gbc.gridwidth = 2; formPanel.add(txtName, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1; formPanel.add(new JLabel("Unit Price:"), gbc);
        txtPrice = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 3; gbc.gridwidth = 2; formPanel.add(txtPrice, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 1; formPanel.add(new JLabel("Quantity:"), gbc);
        txtQuantity = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 4; gbc.gridwidth = 2; formPanel.add(txtQuantity, gbc);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 1; formPanel.add(new JLabel("Description:"), gbc);
        txtDescription = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 5; gbc.gridwidth = 2; formPanel.add(txtDescription, gbc);

        rightPanel.add(formPanel, BorderLayout.CENTER);
        JPanel productButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnNew = new JButton("New");
        JButton btnInsert = new JButton("Save"); 
        JButton btnUpdate = new JButton("Update"); 
        JButton btnRemove = new JButton("Remove");

        productButtonPanel.add(btnNew);
        productButtonPanel.add(btnInsert);
        productButtonPanel.add(btnUpdate); 
        productButtonPanel.add(btnRemove); 
        
        rightPanel.add(productButtonPanel, BorderLayout.SOUTH);

        contentPanel.add(leftPanel, BorderLayout.WEST);
        contentPanel.add(rightPanel, BorderLayout.CENTER);
        add(contentPanel, BorderLayout.CENTER);
        
        // Logic Ssp
        btnNew.addActionListener(e -> clearForm());    
        btnInsert.addActionListener(e -> insertProduct()); 
        btnUpdate.addActionListener(e -> updateProduct());
        btnRemove.addActionListener(e -> deleteProduct());
        
        btnNewCategory.addActionListener(e -> newCategory());
        btnUpdateCategory.addActionListener(e -> updateCategory());
        btnRemoveCategory.addActionListener(e -> removeCategory()); 
    }


    private void loadCategories() {
        List<Category> list = categoryDAO.getAllCategories();
        
        cbCategory.removeAllItems();
        categoryListModel.clear();
        
        for (Category c : list) {
            cbCategory.addItem(c);
            categoryListModel.addElement(c);
        }
    }
    
    private void filterProductsByCategory() {
        Category selectedCate = categoryList.getSelectedValue();
        if (selectedCate != null) {
            List<SanPham> list = dao.getProductsByCategoryId(selectedCate.getId());
            model.setRowCount(0);
            for (SanPham sp : list) {
                addToTable(sp);
            }
        }
    }

    private void loadTable() {
        model.setRowCount(0);
        List<SanPham> list = dao.getAll();
        for (SanPham sp : list) {
            addToTable(sp);
        }
    }

    private void addToTable(SanPham sp) {
        model.addRow(new Object[]{
            sp.getProductId(),
            sp.getProductName(),
            sp.getUnitPrice(),
            sp.getQuantity(),
            sp.getDescription(),
            sp.getCategoryName()
        });
    }

    private SanPham getProductFromForm() {
        Category c = (Category) cbCategory.getSelectedItem();
        if (c == null) throw new RuntimeException("Chưa chọn danh mục!");
        return new SanPham(
            txtId.getText().trim(),
            txtName.getText().trim(),
            Float.parseFloat(txtPrice.getText().trim()),
            Integer.parseInt(txtQuantity.getText().trim()),
            txtDescription.getText().trim(),
            c.getId(),
            c.getName()
        );
    }

    private void insertProduct() {
        try {
            SanPham sp = getProductFromForm();
            if (dao.insert(sp)) {
                JOptionPane.showMessageDialog(this, "Lưu thành công!");
                refreshData();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Lưu thất bại (Có thể trùng ID)!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi dữ liệu: " + e.getMessage());
        }
    }
    
    private void updateProduct() {
        try {
            if(txtId.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần update!");
                return;
            }
            SanPham sp = getProductFromForm();
            if (dao.update(sp)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                refreshData();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    private void deleteProduct() {
        String id = txtId.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần xóa!");
            return;
        }
        if (dao.delete(id)) {
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            refreshData();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại!");
        }
    }
    
    private void refreshData(){
        if(categoryList.isSelectionEmpty()) loadTable(); 
        else filterProductsByCategory();
    }

    private void fillForm() {
        int r = tblProduct.getSelectedRow();
        if (r < 0) return;
        
        txtId.setText(model.getValueAt(r, 0).toString());
        txtName.setText(model.getValueAt(r, 1).toString());
        txtPrice.setText(model.getValueAt(r, 2).toString());
        txtQuantity.setText(model.getValueAt(r, 3).toString());
        txtDescription.setText(model.getValueAt(r, 4).toString());
        
        String catName = model.getValueAt(r, 5) != null ? model.getValueAt(r, 5).toString() : "";
        for (int i = 0; i < cbCategory.getItemCount(); i++) {
            if (cbCategory.getItemAt(i).getName().equals(catName)) {
                cbCategory.setSelectedIndex(i);
                break;
            }
        }
    }

    private void clearForm() {
        txtId.setText("");
        txtName.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        txtDescription.setText("");
        tblProduct.clearSelection();
    }
    
    private void newCategory() {
        String name = JOptionPane.showInputDialog(this, "Nhập tên danh mục mới:");
        if (name != null && !name.trim().isEmpty()) {
            if (categoryDAO.addCategory(name.trim())) {
                JOptionPane.showMessageDialog(this, "Thêm danh mục thành công!");
                loadCategories();
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi thêm danh mục!");
            }
        }
    }

    private void updateCategory() {
        Category selected = categoryList.getSelectedValue();
        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Chọn danh mục cần sửa!");
            return;
        }
        String newName = JOptionPane.showInputDialog(this, "Tên mới:", selected.getName());
        if (newName != null && !newName.trim().isEmpty()) {
            if (categoryDAO.updateCategory(selected.getName(), newName.trim())) {
                JOptionPane.showMessageDialog(this, "Sửa thành công!");
                loadCategories();
                refreshData();
            }
        }
    }

    private void removeCategory() {
        Category selected = categoryList.getSelectedValue();
        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Chọn danh mục cần xóa!");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Xóa danh mục: " + selected.getName() + "?");
        if(confirm == JOptionPane.YES_OPTION){
            
            if (categoryDAO.deleteCategory(selected.getName())) {
                JOptionPane.showMessageDialog(this, "Xóa danh mục thành công!");
                loadCategories();
                refreshData();
               
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Không thể xóa! Danh mục đang chứa sản phẩm hoặc có lỗi xảy ra.");
            }
        }
    }

    private void writeDataToDisk() {
        try {
            List<SanPham> products = dao.getAll();
            DanhMucSanPham dm = new DanhMucSanPham();
            for (SanPham sp : products) dm.add(sp);

            String filePath = "sanpham.dat"; 
            myFile.luuDoiTuong(dm, filePath);
            JOptionPane.showMessageDialog(this, "Đã lưu vào file: " + new File(filePath).getAbsolutePath());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi lưu file: " + e.getMessage());
        }
    }

    private void openDataFromDisk() {
        try {
            String filePath = "sanpham.dat";
            Object obj = myFile.docDoiTuong(filePath);
            if (obj instanceof DanhMucSanPham) {
                danhMuc = (DanhMucSanPham) obj;
                model.setRowCount(0);
                for (SanPham sp : danhMuc.getItems()) {
                    addToTable(sp);
                }
                JOptionPane.showMessageDialog(this, "Đọc file thành công!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi đọc file (Có thể file chưa tồn tại): " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SanPhamFrame().setVisible(true));
    }
}