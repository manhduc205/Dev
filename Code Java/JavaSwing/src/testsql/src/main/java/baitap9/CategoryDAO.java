/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap9;

/**
 *
 * @author ADMIN
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private Connection conn;

    public CategoryDAO() {
        connect db = new connect();
        conn = db.getConnection();
    }

    public List<String> getAllCategoryNames() {
        List<String> categories = new ArrayList<>();

        String sql = "SELECT name FROM category ORDER BY name";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                categories.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return categories;
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT * FROM category ORDER BY name";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                categories.add(new Category(
                    rs.getInt("id"),
                    rs.getString("name")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return categories;
    }

    public boolean addCategory(String name) {
        String sql = "INSERT INTO category(name) VALUES (?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateCategory(String oldName, String newName) {
        String sql = "UPDATE category SET name = ? WHERE name = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newName);
            ps.setString(2, oldName);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteCategory(String name) {
        String checkSql = "SELECT COUNT(*) FROM products p JOIN category c ON p.categoryId = c.id WHERE c.name = ?";
        try (PreparedStatement ps = conn.prepareStatement(checkSql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {               
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        String sql = "DELETE FROM category WHERE name = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Category getCategoryByName(String name) {
        String sql = "SELECT * FROM category WHERE name = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Category(
                    rs.getInt("id"),
                    rs.getString("name")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

