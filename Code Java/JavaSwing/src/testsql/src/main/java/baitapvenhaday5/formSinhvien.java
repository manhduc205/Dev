    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package baitapvenhaday5;

    import javax.swing.*;
    import java.awt.*;
    import javax.swing.table.DefaultTableModel;
    

    /**
     *
     * @author Admin
     */
    public class formSinhvien extends JFrame {
        private JList<String> listSinhVien;
        private DefaultListModel<String> listModel = new DefaultListModel<>();
        private java.util.List<String> fullData = new java.util.ArrayList<>();
        private DefaultTableModel model;
        private JTextField txtId, txtName, txtAge;
        private JButton btnAdd, btnRemove, btnUpdate, btnClear;
        private myConnection mc = new myConnection();

        public formSinhvien(){
            setTitle("Quản lý Sinh Viên");
            setSize(600,400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            initUI();
            loadData();
            setVisible(true);

        }

        private void initUI() {

            JLabel lblTitle = new JLabel("THONG TIN SINH VIEN", SwingConstants.CENTER);
            lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
            lblTitle.setForeground(Color.red);
            add(lblTitle, BorderLayout.NORTH);
            add(listform(), BorderLayout.CENTER);
            add(button(), BorderLayout.SOUTH);
        }

        private JSplitPane listform(){
            listSinhVien = new JList<>(listModel);
            JScrollPane scrollList = new JScrollPane(listSinhVien);
            scrollList.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red),"Danh sach sinh vien"));
            listSinhVien.getSelectionModel().addListSelectionListener(e -> fillform());
            
            JPanel thongtin = new JPanel( new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.anchor = GridBagConstraints.FIRST_LINE_START;

            txtId = new JTextField(20);
            txtName = new JTextField(20);
            txtAge = new JTextField(20);

            JLabel lblmsv = new JLabel("Ma sinh vien: ");
            lblmsv.setFont(new Font("Arial",Font.BOLD,13));
            lblmsv.setForeground(Color.red);
            gbc.gridx = 0; gbc.gridy = 0;
            thongtin.add(lblmsv, gbc);

            gbc.gridx = 1; 
            thongtin.add(txtId, gbc);


            gbc.gridx = 0; gbc.gridy = 1;
            thongtin.add(new JLabel("Ho va ten: "), gbc);

            gbc.gridx = 1;
            thongtin.add(txtName, gbc);

            gbc.gridx = 0; gbc.gridy = 2;
            thongtin.add(new JLabel("Tuoi: "), gbc);

            gbc.gridx = 1;
            thongtin.add(txtAge, gbc);
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            thongtin.add(new JLabel(), gbc);

            JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollList, thongtin);

            sp.setDividerLocation(180);
            sp.setResizeWeight(0.3);



            return sp;
        }

        private JPanel button(){
            JPanel b = new JPanel( new FlowLayout());

            btnAdd = new JButton("Add");
            btnRemove = new JButton("Remove");
            btnUpdate = new JButton("Update");
            btnClear = new JButton("Clear");

            b.add(btnAdd);
            b.add(btnRemove);
            b.add(btnUpdate);
            b.add(btnClear);

            btnAdd.addActionListener(e -> addSV());
            btnRemove.addActionListener(e -> removeSV());
            btnUpdate.addActionListener(e -> updateSV());
            btnClear.addActionListener(e -> cleardata());
            return b;
        }

        private void fillform(){
            int index =  listSinhVien.getSelectedIndex();
            if(index >= 0){
                String data = fullData.get(index);  // lấy dòng được chọn

            String[] parts = data.split("-");    // tách theo dấu -

            txtId.setText(parts[0].trim());
            txtName.setText(parts[1].trim());
            txtAge.setText(parts[2].trim());
            
            }
        }

        private void loadData() {
            listModel.clear(); // xoá dữ liệu cũ
            fullData.clear();
        for (String sv : mc.getSinhvien()) { 
            fullData.add(sv);
            String[] parts = sv.split("-");
            String name = parts[1].trim();
            listModel.addElement(name);  
        }
        }

        private void addSV() {       
            if (txtId.getText().isEmpty() || txtName.getText().isEmpty() || txtAge.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống!");
            return;
    }
            String id = txtId.getText();
            String name = txtName.getText();
            int age = Integer.parseInt(txtAge.getText());

            boolean ok = mc.addsv(id, name, age);
            if (ok){
                JOptionPane.showMessageDialog(this, "Them thanh cong!");
                loadData();
            }else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
            }
        }

        private void updateSV(){
            if(txtId.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
                return;
            }
            boolean ok = mc.updatesv(
                    txtId.getText(),
                    txtName.getText(),
                    Integer.parseInt(txtAge.getText())
            );
            if (ok) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            loadData();
            cleardata();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
    }
        }

        private void removeSV(){
            if(txtId.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Chon dong can xoa");
                return;
            }
            
           String id =  txtId.getText();
        boolean ok = mc.deletesv(id);
        if (ok) {
        JOptionPane.showMessageDialog(this, "Xoa thanh cong");
        loadData();
        cleardata();
    } else {
        JOptionPane.showMessageDialog(this, "Xoa that bai");
    }
        }

        private void cleardata(){
            txtId.setText("");
            txtName.setText("");
            txtAge.setText("");
            listSinhVien.clearSelection();
        }

        public static void main(String[] args) {
            new formSinhvien();
        }


    }
