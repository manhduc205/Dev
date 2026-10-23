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

public class SinhVienDAO {
    private Connection conn;

    public SinhVienDAO() {
        connect db = new connect();
        conn = db.getConnection();
    }

    // Lấy sinh viên theo mã lớp (Để hiển thị khi click vào Tree)
    public List<SinhVien> getSinhVienByLop(String maLop) {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM sinhvien WHERE ma_lop = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maLop);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SinhVien(
                    rs.getString("ma_sv"),
                    rs.getString("ho_ten"),
                    rs.getInt("tuoi"),
                    rs.getString("ma_lop")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean insert(SinhVien sv) {
        String sql = "INSERT INTO sinhvien(ma_sv, ho_ten, tuoi, ma_lop) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getHoTen());
            ps.setInt(3, sv.getTuoi());
            ps.setString(4, sv.getMaLop());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(SinhVien sv) {
        String sql = "UPDATE sinhvien SET ho_ten = ?, tuoi = ? WHERE ma_sv = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sv.getHoTen());
            ps.setInt(2, sv.getTuoi());
            ps.setString(3, sv.getMaSV());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(String maSV) {
        String sql = "DELETE FROM sinhvien WHERE ma_sv = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maSV);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}