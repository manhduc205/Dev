/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai11;

/**
 *
 * @author DucPc
 */


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LopHocDAO {
    private Connection conn;

    public LopHocDAO() {
        connect db = new connect();
        conn = db.getConnection();
    }

    public List<LopHoc> getAllLopHoc() {
        List<LopHoc> list = new ArrayList<>();
        String sql = "SELECT * FROM lophoc";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new LopHoc(
                    rs.getString("ma_lop"),
                    rs.getString("ten_lop")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    // Bạn có thể thêm các hàm insert/update/delete LopHoc ở đây nếu cần
}
