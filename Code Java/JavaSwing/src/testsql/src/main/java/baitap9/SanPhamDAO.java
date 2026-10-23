package baitap9;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    private Connection conn;

    public SanPhamDAO() {
        connect db = new connect();
        conn = db.getConnection();
    }

    public List<SanPham> getAll() {
        List<SanPham> list = new ArrayList<>();

        String sql =
            "SELECT p.*, c.name AS categoryName " +
            "FROM products p LEFT JOIN category c ON p.categoryId = c.id";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                SanPham sp = new SanPham();

                sp.setProductId(rs.getString("id"));
                sp.setProductName(rs.getString("productName"));
                sp.setUnitPrice(rs.getFloat("unitPrice"));
                sp.setQuantity(rs.getInt("quantity"));
                sp.setDescription(rs.getString("description"));
                sp.setCategoryId(rs.getInt("categoryId"));
                sp.setCategoryName(rs.getString("categoryName"));
                list.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(SanPham sp) {
        String sql = "INSERT INTO products(id, productName, unitPrice, quantity, description, categoryId) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sp.getProductId());
            ps.setString(2, sp.getProductName());
            ps.setFloat(3, sp.getUnitPrice());
            ps.setInt(4, sp.getQuantity());
            ps.setString(5, sp.getDescription());
            ps.setInt(6, sp.getCategoryId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(SanPham sp) {
        String sql = "UPDATE products SET productName=?, unitPrice=?, quantity=?, description=?, categoryId=? "
                   + "WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sp.getProductName());
            ps.setFloat(2, sp.getUnitPrice());
            ps.setInt(3, sp.getQuantity());
            ps.setString(4, sp.getDescription());
            ps.setInt(5, sp.getCategoryId());
            ps.setString(6, sp.getProductId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM products WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();

        String sql = "SELECT * FROM category ORDER BY id";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Category(rs.getInt("id"),     
                        rs.getString("name")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<SanPham> getProductsByCategoryId(int categoryId) {
        List<SanPham> list = new ArrayList<>();

        String sql =
            "SELECT p.*, c.name AS categoryName " +
            "FROM products p LEFT JOIN category c ON p.categoryId = c.id " +
            "WHERE p.categoryId = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setProductId(rs.getString("id"));
                sp.setProductName(rs.getString("productName"));
                sp.setUnitPrice(rs.getFloat("unitPrice"));
                sp.setQuantity(rs.getInt("quantity"));
                sp.setDescription(rs.getString("description"));
                sp.setCategoryId(rs.getInt("categoryId"));
                sp.setCategoryName(rs.getString("categoryName"));

                list.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
