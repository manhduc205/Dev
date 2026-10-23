package com.mycompany.bai_9;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class SanPhamUI extends JFrame {

    private JTextField txtId, txtName, txtPrice, txtQuantity, txtDescription;
    private JComboBox<Category> cbCategory;

    private JTable tblProduct;
    private DefaultTableModel model;

    private DefaultListModel<String> categoryListModel;
    private JList<String> categoryList;

    private SanPhamDAO dao = new SanPhamDAO();
    private DanhMucSanPham danhMuc = new DanhMucSanPham();

    public SanPhamUI() {
        setTitle("Quản lý sản phẩm");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initUI();
        loadCategories();
        loadTable();
    }

    private void initUI() {
        // Menu Bar
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

        // Menu item actions
        writeDataItem.addActionListener(e -> writeDataToDisk());
        openDataItem.addActionListener(e -> openDataFromDisk());
        exitItem.addActionListener(e -> System.exit(0));

        // Title Panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Quản lý sản phẩm");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLUE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Main Content Panel
        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Left Panel - Category List
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("Danh mục sản phẩm"));
        leftPanel.setPreferredSize(new Dimension(230, 0));

        categoryListModel = new DefaultListModel<>();
        categoryList = new JList<>(categoryListModel);
        categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane categoryScrollPane = new JScrollPane(categoryList);
        leftPanel.add(categoryScrollPane, BorderLayout.CENTER);

        // Category list buttons
        JPanel categoryButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JButton btnNewCategory = new JButton("New");
        JButton btnUpdateCategory = new JButton("Update");
        JButton btnRemoveCategory = new JButton("Remove");

        categoryButtonPanel.add(btnNewCategory);
        categoryButtonPanel.add(btnUpdateCategory);
        categoryButtonPanel.add(btnRemoveCategory);
        leftPanel.add(categoryButtonPanel, BorderLayout.SOUTH);

        // Right Panel - Product Details
        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết"));

        // Product Table
        String[] cols = {"Product ID", "Product Name", "UnitPrice", "Quantity", "Description"};
        model = new DefaultTableModel(cols, 0);
        tblProduct = new JTable(model);

        tblProduct.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                fillForm();
            }
        });

        JScrollPane tableScrollPane = new JScrollPane(tblProduct);
        tableScrollPane.setPreferredSize(new Dimension(0, 120));
        rightPanel.add(tableScrollPane, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Category
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Category :"), gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.gridwidth = 2;
        cbCategory = new JComboBox<>();
        formPanel.add(cbCategory, gbc);

        // Product ID
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Product ID:"), gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.gridwidth = 2;
        txtId = new JTextField(20);
        formPanel.add(txtId, gbc);

        // Product Name
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Product Name:"), gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.gridwidth = 2;
        txtName = new JTextField(20);
        formPanel.add(txtName, gbc);

        // Unit Price
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Unit Price:"), gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        gbc.gridwidth = 2;
        txtPrice = new JTextField(20);
        formPanel.add(txtPrice, gbc);

        // Quantity
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Quantity:"), gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        gbc.gridwidth = 2;
        txtQuantity = new JTextField(20);
        formPanel.add(txtQuantity, gbc);

        // Description
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Description:"), gbc);

        gbc.gridx = 1; gbc.gridy = 5;
        gbc.gridwidth = 2;
        txtDescription = new JTextField(20);
        formPanel.add(txtDescription, gbc);

        rightPanel.add(formPanel, BorderLayout.CENTER);

        // Product Buttons
        JPanel productButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnNew = new JButton("New");
        JButton btnSave = new JButton("Save");
        JButton btnRemove = new JButton("Remove");

        productButtonPanel.add(btnNew);
        productButtonPanel.add(btnSave);
        productButtonPanel.add(btnRemove);

        rightPanel.add(productButtonPanel, BorderLayout.SOUTH);

        // Add panels to content
        contentPanel.add(leftPanel, BorderLayout.WEST);
        contentPanel.add(rightPanel, BorderLayout.CENTER);

        add(contentPanel, BorderLayout.CENTER);

        // EVENTS
        btnNew.addActionListener(e -> clearForm());
        btnSave.addActionListener(e -> saveProduct());
        btnRemove.addActionListener(e -> deleteProduct());

        categoryList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                filterProductsByCategory();
            }
        });
    }

    // Load categories into both list and combobox
    private void loadCategories() {
        List<Category> list = dao.getAllCategories();

        // Load into combo box
        cbCategory.removeAllItems();
        for (Category c : list) {
            cbCategory.addItem(c);
        }

        // Load into list
        categoryListModel.clear();
        for (Category c : list) {
            categoryListModel.addElement(c.getName());
        }
    }

    // Load table with all products
    private void loadTable() {
        model.setRowCount(0);

        List<SanPham> list = dao.getAll();
        for (SanPham sp : list) {
            model.addRow(new Object[]{
                sp.getProductId(),
                sp.getProductName(),
                sp.getUnitPrice(),
                sp.getQuantity(),
                sp.getDescription()
            });
        }
    }

    // Filter products by selected category
    private void filterProductsByCategory() {
        String selectedCategory = categoryList.getSelectedValue();
        if (selectedCategory == null) {
            loadTable();
            return;
        }

        // If "Tất cả mặt hàng" is selected, show all products
        if ("Tất cả mặt hàng".equals(selectedCategory)) {
            loadTable();
            return;
        }

        model.setRowCount(0);
        List<SanPham> list = dao.getAll();
        for (SanPham sp : list) {
            if (sp.getCategoryName() != null && sp.getCategoryName().equals(selectedCategory)) {
                model.addRow(new Object[]{
                    sp.getProductId(),
                    sp.getProductName(),
                    sp.getUnitPrice(),
                    sp.getQuantity(),
                    sp.getDescription()
                });
            }
        }
    }

    // Save product (Insert or Update)
    private void saveProduct() {
        try {
            if (txtId.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập Product ID!");
                return;
            }

            Category c = (Category) cbCategory.getSelectedItem();
            if (c == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn Category!");
                return;
            }

            SanPham sp = new SanPham(
                txtId.getText().trim(),
                txtName.getText().trim(),
                Float.parseFloat(txtPrice.getText().trim()),
                Integer.parseInt(txtQuantity.getText().trim()),
                txtDescription.getText().trim(),
                c.getId(),
                c.getName()
            );

            // Check if product exists
            boolean exists = false;
            String productId = txtId.getText().trim();
            List<SanPham> allProducts = dao.getAll();
            for (SanPham p : allProducts) {
                if (p.getProductId().equals(productId)) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                // Update existing product
                if (dao.update(sp)) {
                    JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật sản phẩm!");
                    return;
                }
            } else {
                // Insert new product
                if (dao.insert(sp)) {
                    JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi khi thêm sản phẩm!");
                    return;
                }
            }

            filterProductsByCategory();
            clearForm();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ! Vui lòng kiểm tra lại.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    // Delete product
    private void deleteProduct() {
        String id = txtId.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
            "Bạn có chắc muốn xóa sản phẩm này?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (dao.delete(id)) {
                JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công!");
                filterProductsByCategory();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa sản phẩm!");
            }
        }
    }

    // Fill form from selected table row
    private void fillForm() {
        int r = tblProduct.getSelectedRow();
        if (r < 0) return;

        txtId.setText(model.getValueAt(r, 0).toString());
        txtName.setText(model.getValueAt(r, 1).toString());
        txtPrice.setText(model.getValueAt(r, 2).toString());
        txtQuantity.setText(model.getValueAt(r, 3).toString());
        txtDescription.setText(model.getValueAt(r, 4).toString());
    }

    // Clear form
    private void clearForm() {
        txtId.setText("");
        txtName.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        txtDescription.setText("");
        if (cbCategory.getItemCount() > 0) {
            cbCategory.setSelectedIndex(0);
        }
    }

    // Write data to disk
    private void writeDataToDisk() {
        try {
            // Get all products from database
            List<SanPham> products = dao.getAll();
            DanhMucSanPham danhMuc = new DanhMucSanPham();
            for (SanPham sp : products) {
                danhMuc.add(sp);
            }

            // Save to file
            myFile.luuDoiTuong(danhMuc, "products.dat");
            JOptionPane.showMessageDialog(this, "Đã lưu dữ liệu vào ổ cứng thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu dữ liệu: " + e.getMessage());
        }
    }

    // Open data from disk
    private void openDataFromDisk() {
        try {
            Object obj = myFile.docDoiTuong("products.dat");
            if (obj instanceof DanhMucSanPham) {
                danhMuc = (DanhMucSanPham) obj;

                // Display products from file
                model.setRowCount(0);
                for (SanPham sp : danhMuc.getItems()) {
                    model.addRow(new Object[]{
                        sp.getProductId(),
                        sp.getProductName(),
                        sp.getUnitPrice(),
                        sp.getQuantity(),
                        sp.getDescription()
                    });
                }

                JOptionPane.showMessageDialog(this, "Đã đọc dữ liệu từ ổ cứng thành công!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi đọc dữ liệu: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SanPhamUI().setVisible(true);
        });
    }
}
