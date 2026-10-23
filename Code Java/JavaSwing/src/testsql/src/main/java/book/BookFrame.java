package book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class BookFrame extends JFrame {
    private JTextField txtId, txtName, txtCategory, txtAuthor, txtPrize;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnAdd, btnUpdate, btnDelete, btnClear, btnRefresh;

    private BookDAO bookDAO;

    public BookFrame() {
        bookDAO = new BookDAO();
        initComponents();
        loadTableData();
    }

    private void initComponents() {
        setTitle("Quản Lý Sách - CRUD");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Thông Tin Sách"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        txtId = new JTextField(20);
        txtId.setEditable(false);
        inputPanel.add(txtId, gbc);

        // Name
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Tên Sách:"), gbc);
        gbc.gridx = 1;
        txtName = new JTextField(20);
        inputPanel.add(txtName, gbc);

        // Category
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Thể Loại:"), gbc);
        gbc.gridx = 1;
        txtCategory = new JTextField(20);
        inputPanel.add(txtCategory, gbc);

        // Author
        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Tác Giả:"), gbc);
        gbc.gridx = 1;
        txtAuthor = new JTextField(20);
        inputPanel.add(txtAuthor, gbc);

        // Prize
        gbc.gridx = 0; gbc.gridy = 4;
        inputPanel.add(new JLabel("Giá:"), gbc);
        gbc.gridx = 1;
        txtPrize = new JTextField(20);
        inputPanel.add(txtPrize, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btnAdd = new JButton("Thêm Mới");
        btnAdd.setBackground(new Color(46, 204, 113));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFocusPainted(false);
        btnAdd.addActionListener(e -> addBook());

        btnUpdate = new JButton("Cập Nhật");
        btnUpdate.setBackground(new Color(52, 152, 219));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFocusPainted(false);
        btnUpdate.addActionListener(e -> updateBook());

        btnDelete = new JButton("Xóa");
        btnDelete.setBackground(new Color(231, 76, 60));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFocusPainted(false);
        btnDelete.addActionListener(e -> deleteBook());

        btnClear = new JButton("Làm Mới");
        btnClear.setBackground(new Color(149, 165, 166));
        btnClear.setForeground(Color.WHITE);
        btnClear.setFocusPainted(false);
        btnClear.addActionListener(e -> clearFields());

        btnRefresh = new JButton("Tải Lại");
        btnRefresh.setBackground(new Color(241, 196, 15));
        btnRefresh.setForeground(Color.WHITE);
        btnRefresh.setFocusPainted(false);
        btnRefresh.addActionListener(e -> loadTableData());

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnRefresh);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(inputPanel, BorderLayout.CENTER);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        String[] columns = {"ID", "Tên Sách", "Thể Loại", "Tác Giả", "Giá"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho edit trực tiếp trên table
            }
        };
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);

        // Khi click vào dòng trong bảng, hiển thị lên form
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    displayBookToForm(selectedRow);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Danh Sách Sách"));

        // ===== THÊM VÀO JFRAME =====
        add(leftPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
    }

    // ===== LOAD DỮ LIỆU TỪ DATABASE VÀO BẢNG =====
    private void loadTableData() {
        tableModel.setRowCount(0); // Xóa dữ liệu cũ
        List<Book> books = bookDAO.getAllBooks();
        for (Book book : books) {
            Object[] row = {
                book.getId(),
                book.getName(),
                book.getCategory(),
                book.getAuthor(),
                book.getPrize()
            };
            tableModel.addRow(row);
        }
    }

    // ===== HIỂN THỊ THÔNG TIN SÁCH LÊN FORM KHI CLICK VÀO BẢNG =====
    private void displayBookToForm(int rowIndex) {
        txtId.setText(tableModel.getValueAt(rowIndex, 0).toString());
        txtName.setText(tableModel.getValueAt(rowIndex, 1).toString());
        txtCategory.setText(tableModel.getValueAt(rowIndex, 2).toString());
        txtAuthor.setText(tableModel.getValueAt(rowIndex, 3).toString());
        txtPrize.setText(tableModel.getValueAt(rowIndex, 4).toString());
    }

    // ===== THÊM MỚI SÁCH =====
    private void addBook() {
        try {
            // Validate dữ liệu
            if (txtName.getText().trim().isEmpty() || txtPrize.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Tạo đối tượng Book
            Book book = new Book();
            book.setName(txtName.getText().trim());
            book.setCategory(txtCategory.getText().trim());
            book.setAuthor(txtAuthor.getText().trim());
            book.setPrize(Double.parseDouble(txtPrize.getText().trim()));

            // Gọi DAO để thêm vào database
            int result = bookDAO.insert(book);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Thêm sách thành công!", "Thành Công", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sách thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá phải là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===== CẬP NHẬT SÁCH =====
    private void updateBook() {
        try {
            // Kiểm tra xem đã chọn sách chưa
            if (txtId.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần cập nhật!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Tạo đối tượng Book với ID
            Book book = new Book();
            book.setId(Integer.parseInt(txtId.getText().trim()));
            book.setName(txtName.getText().trim());
            book.setCategory(txtCategory.getText().trim());
            book.setAuthor(txtAuthor.getText().trim());
            book.setPrize(Double.parseDouble(txtPrize.getText().trim()));

            // Gọi DAO để cập nhật
            int result = bookDAO.update(book);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật sách thành công!", "Thành Công", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật sách thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===== XÓA SÁCH =====
    private void deleteBook() {
        try {
            // Kiểm tra xem đã chọn sách chưa
            if (txtId.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Xác nhận trước khi xóa
            int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn xóa sách này?",
                "Xác Nhận",
                JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(txtId.getText().trim());
                int result = bookDAO.delete(id);

                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa sách thành công!", "Thành Công", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                    loadTableData();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa sách thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===== XÓA SẠCH CÁC TRƯỜNG NHẬP LIỆU =====
    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtCategory.setText("");
        txtAuthor.setText("");
        txtPrize.setText("");
        table.clearSelection();
    }

    // ===== CHẠY ỨNG DỤNG =====
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookFrame frame = new BookFrame();
            frame.setVisible(true);
        });
    }
}
