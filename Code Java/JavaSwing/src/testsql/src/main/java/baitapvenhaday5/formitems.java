/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitapvenhaday5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class formitems extends JFrame{
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private List<String> fullData = new ArrayList<>();
    private JList<String> listSP = new JList<>(listModel);

    private DefaultTableModel modelTable;
    private JTable table;

    private JComboBox<String> cbo;
    private JTextField txtId, txtName, txtGia, txtSlg;
    private JTextArea txtMota;

    private myConnection mc = new myConnection();
    private MyFile filee = new MyFile();

    public formitems() {
        initJFrame();
        initLayout();
        loadDanhMuc();
        loadTable();
        setVisible(true);
    }

    private void initJFrame() {
        this.setTitle("Quản lý sản phẩm!");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    private void initLayout() {
        
        JPanel tong = new JPanel(new BorderLayout());
        add(tong);
        
        //menubar
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        JMenu file = new JMenu("File");
        
        
        JMenuItem write = new JMenuItem("Write Data to disk");
        file.add(write);
        write.addActionListener(e -> write());
        
        JMenuItem open = new JMenuItem("Open Data from disk");
        file.add(open);
        open.addActionListener(e -> open());
        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);
        exit.addActionListener(e -> {
            System.exit(0);
        });
        
        menu.add(file);
        
        //tieu de
        JLabel tieude = new JLabel("Quản lý sản phẩm" , SwingConstants.CENTER);
        tieude.setFont(new Font("Times New Romen", Font.BOLD, 30));
        tieude.setForeground(Color.blue);
        tong.add(tieude, BorderLayout.NORTH);
        
        //trai JList
        JPanel trai = new JPanel( new BorderLayout());
        listSP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Danh mục sản phẩm"));
        trai.add(listSP, BorderLayout.CENTER);
        
        JPanel nut = new JPanel(new FlowLayout());
        JButton btnNewDm = new JButton("New");
        nut.add(btnNewDm);
        btnNewDm.addActionListener(e -> newCategory());
        JButton btnUpdateDm = new JButton("Update");
        nut.add(btnUpdateDm);
        btnUpdateDm.addActionListener(e -> updateCategory());
        JButton btnRemoveDm = new JButton("Remove");
        nut.add(btnRemoveDm);
        btnRemoveDm.addActionListener(e -> removeCategory());
        
        trai.add(nut, BorderLayout.SOUTH);
        
        //phai
        JPanel phai = new JPanel( new BorderLayout());
        
        modelTable = new DefaultTableModel( new String[] {"ProductID", "ProductName","UnitPrice", "Quantity", "Description"}, 0);
        table = new JTable(modelTable);
        JScrollPane sc = new JScrollPane(table);
        sc.setPreferredSize(new Dimension(400, 200));
        phai.add(sc, BorderLayout.NORTH);
        table.getSelectionModel().addListSelectionListener(e -> fillForm());
        
        JPanel nhap = new  JPanel(new GridBagLayout());
        GridBagConstraints vtri = new GridBagConstraints();
        vtri.insets = new Insets(5, 10, 5, 10);
        vtri.anchor = GridBagConstraints.CENTER;
        vtri.fill= GridBagConstraints.HORIZONTAL;
        //danhmuc
        vtri.gridx = 0;
        vtri.gridy = 0;
        nhap.add(new JLabel("Category:"), vtri);
        
        vtri.gridx =1;
        cbo = new JComboBox<>();
        nhap.add(cbo, vtri);
        //id
        vtri.gridx = 0;
        vtri.gridy = 1;
        nhap.add(new JLabel("Product ID:"), vtri);
        
        vtri.gridx =1;
        txtId = new JTextField();
        nhap.add(txtId, vtri);
        //ten
        vtri.gridx = 0;
        vtri.gridy = 2;
        nhap.add(new JLabel("Product Name:"), vtri);
        
        vtri.gridx =1;
        txtName = new JTextField();
        nhap.add(txtName, vtri);
        //gia
        vtri.gridx = 0;
        vtri.gridy = 3;
        nhap.add(new JLabel("Unit Price:"), vtri);
        
        vtri.gridx =1;
        txtGia = new JTextField();
        nhap.add(txtGia, vtri);
        // Slg
        vtri.gridx = 0;
        vtri.gridy = 4;
        nhap.add(new JLabel("Quantity:"), vtri);
        
        vtri.gridx =1;
        txtSlg= new JTextField();
        nhap.add(txtSlg, vtri);
        //Mota
        vtri.gridx = 0;
        vtri.gridy = 5;
        nhap.add(new JLabel("Description:"), vtri);
        
        vtri.gridx =1;
        txtMota = new JTextArea(5, 23);
        nhap.add(new JScrollPane(txtMota), vtri);
        phai.add(nhap, BorderLayout.CENTER);
        
        JPanel btn = new JPanel(new FlowLayout());
        JButton btnNew = new JButton("New");
        btn.add(btnNew);
        btnNew.addActionListener(e -> New());
        
        JButton btnSave = new JButton("Save");
        btn.add(btnSave);
        btnSave.addActionListener(e -> Save());
        
        JButton btnRemove = new JButton("Remove");
        btn.add(btnRemove);
        btnRemove.addActionListener(e -> Remove());
        phai.add(btn, BorderLayout.SOUTH);
        
        JSplitPane split = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                trai,
                phai
        );
        tong.add(split, BorderLayout.CENTER);
        split.setDividerLocation(270);
        split.setResizeWeight(0.3);
        
    }
    private void loadTable(){
        fullData =  mc.getitem();
        modelTable.setRowCount(0);

    for (String sp : mc.getitem()) {

        String[] parts = sp.split("-");

        modelTable.addRow(new Object[] {
                parts[0].trim(),
                parts[2].trim(),
                parts[3].trim(),
                parts[4].trim(),
                parts[5].trim()
        });
    }

    }
    
    private void loadDanhMuc() {
        listModel.clear();
        cbo.removeAllItems();

        for (String dm : mc.getcategory()) {
            listModel.addElement(dm);
            cbo.addItem(dm);
        }
}


    private void fillForm() {
        int index = table.getSelectedRow(); if(index >= 0){ 
        String data = fullData.get(index); // lấy dòng được chọn 
        String[] parts = data.split("-"); // tách theo dấu - 
        txtId.setText(parts[0].trim()); 
        cbo.setSelectedItem(parts[1].trim()); 
        txtName.setText(parts[2].trim()); 
        txtGia.setText(parts[3].trim()); 
        txtSlg.setText(parts[4].trim()); 
        txtMota.setText(parts[5].trim()); }
        }


    private void write() {
       
       filee.luuDoiTuong(mc.getitem(), "sanpham.dat");
       
       JOptionPane.showMessageDialog(this, "Đã lưu thành công");

    }
    
    private void open() {
        Object data = filee.docDoiTuong("sanpham.dat");

        if (data instanceof List) {
            List<String> ds = (List<String>) data;

            modelTable.setRowCount(0);

            for (String sp : ds) {
                String[] p = sp.split("-");
                modelTable.addRow(new Object[]{
                    p[0].trim(),
                    p[2].trim(),
                    p[3].trim(),
                    p[4].trim(),
                    p[5].trim()
                });
            }

            JOptionPane.showMessageDialog(this, "Đọc dữ liệu file thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Không đọc được dữ liệu!");
        }
    }

    private void newCategory() {
String name = JOptionPane.showInputDialog(this, "Nhập tên danh mục:");
        
        if( name == null || name.trim().isEmpty())
            return;
        listModel.addElement(name);
        cbo.addItem(name);
        JOptionPane.showMessageDialog(this, "Thêm danh mục thành công!");
    }

    private void updateCategory() {
        String oldName = listSP.getSelectedValue();
        if (oldName == null ){
            JOptionPane.showMessageDialog(this, "Chọn danh mục cần sửa!");
            return;
        }
        String newName = JOptionPane.showInputDialog(this, "Tên mới:", oldName);
        if (newName == null || newName.trim().isEmpty())
            return;
        
        mc.updatecategory(oldName, newName);
        
        listModel.set(listSP.getSelectedIndex(), newName);
        
        cbo.removeItem(oldName);
        cbo.addItem(newName);
        JOptionPane.showMessageDialog(this, "Cập nhật danh mục thành công!");

    }

    private void removeCategory() {
        String values = listSP.getSelectedValue();

    if (values == null) {
        JOptionPane.showMessageDialog(this, "Chọn danh mục cần xóa!");
        return;
    }

    boolean ok = mc.deletecategory(values);

    if (ok) {
        JOptionPane.showMessageDialog(this, "Xóa thành công!");
        loadDanhMuc();
    } else {
        JOptionPane.showMessageDialog(this, "Xóa thất bại!");
    }
    }

    private void New() {
        if (txtId.getText().isEmpty() || 
        txtName.getText().isEmpty() || 
        txtGia.getText().isEmpty() || 
        txtSlg.getText().isEmpty()) {

        JOptionPane.showMessageDialog(this, "Không được để trống!");
        return;
    }


    String id = txtId.getText();
    String category = cbo.getSelectedItem().toString();
    String name = txtName.getText();
    double price = Double.parseDouble(txtGia.getText());
    int quantity = Integer.parseInt(txtSlg.getText());
    String mota = txtMota.getText();

    boolean ok = mc.additem(id, category, name, price, quantity, mota);


    if (ok){
        JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!");
        loadTable();
    } else {
        JOptionPane.showMessageDialog(this, "Thêm thất bại!");
    }
    }

    private void Save() {
        if (txtId.getText().isEmpty() || txtName.getText().isEmpty()
            || txtGia.getText().isEmpty() || txtSlg.getText().isEmpty()) {

        JOptionPane.showMessageDialog(this, "Không được để trống!");
        return;
    }


    String id = txtId.getText().trim();
    String category = cbo.getSelectedItem().toString();
    String name = txtName.getText().trim();
    double price = Double.parseDouble(txtGia.getText());
    int quantity = Integer.parseInt(txtSlg.getText());
    String mota = txtMota.getText().trim();

    boolean ok = mc.updateitem(id, category, name, price, quantity, mota);


    if (ok) {
        JOptionPane.showMessageDialog(this, "Lưu thành công!");
        loadTable();
    } else {
        JOptionPane.showMessageDialog(this, "Lưu thất bại!");
    }
}
    

    private void Remove() {
        String id = txtId.getText().trim();


    boolean ok = mc.deleteitem(id);


    if (ok) {
        JOptionPane.showMessageDialog(this, "Xóa thành công!");
        loadTable();
    } else {
        JOptionPane.showMessageDialog(this, "Xóa thất bại!");
    }
    }

    public static void main(String[] args) {
        new formitems();
    }

}
