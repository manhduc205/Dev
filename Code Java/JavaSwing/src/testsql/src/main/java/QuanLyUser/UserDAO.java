/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyUser;

/**
 *
 * @author DucPc
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public UserDAO() {
       
    }

    // READ
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_user";

        try (Connection con = JdbcHelper.openConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User u = new User();
                u.setUserid(rs.getString("userid"));
                u.setUsername(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm User
    public int insert(User u) {
        String sql = "INSERT INTO tbl_user (userid, username, email, password) VALUES (?, ?, ?, ?)";
        try (Connection con = JdbcHelper.openConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getUserid());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPassword());

            return ps.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
            return 0; 
        }
    }

    // update user
    public int update(User u) {
        String sql = "UPDATE tbl_user SET username=?, email=?, password=? WHERE userid=?";
        try (Connection con = JdbcHelper.openConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getUsername());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getUserid());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int delete(String userid) {
        String sql = "DELETE FROM tbl_user WHERE userid=?";
        try (Connection con = JdbcHelper.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, userid);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
