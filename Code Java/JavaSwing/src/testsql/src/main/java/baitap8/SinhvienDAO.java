/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class SinhvienDAO {
    
    public List<Sinhvien> getAllSinhvien() {
        List<Sinhvien> list = new ArrayList<>();
        String sql = "SELECT * FROM sinhvien";

        try (Connection con = jdbcHelper.openConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Sinhvien s = new Sinhvien();
                s.setMsv(rs.getString("msv"));
                s.setTensv(rs.getString("tensv"));
                s.setTuoi(rs.getInt("tuoi"));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public int insert(Sinhvien s) {
        String sql = "INSERT INTO sinhvien (msv, tensv, tuoi) VALUES (?, ?, ?)";
        try (Connection con = jdbcHelper.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getMsv());
            ps.setString(2, s.getTensv());
            ps.setInt(3, s.getTuoi());

            return ps.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(Sinhvien s) {
        String sql = "UPDATE sinhvien SET tensv=?, tuoi=? WHERE msv=?";
        try (Connection con = jdbcHelper.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, s.getTensv());
            ps.setInt(2, s.getTuoi());
            ps.setString(3, s.getMsv());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(String msv) {
        String sql = "DELETE FROM sinhvien WHERE msv=?";
        try (Connection con = jdbcHelper.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, msv);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

