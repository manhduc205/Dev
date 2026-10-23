package book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // Constructor - tự động tạo bảng nếu chưa có
    public BookDAO() {
        createTable();
    }

    // 1. READ (Đọc danh sách sách)
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM Book";

        try (Connection con = JdbcHelper.openConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setCategory(rs.getString("category"));
                b.setAuthor(rs.getString("author"));
                b.setPrize(rs.getDouble("prize"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. CREATE (Thêm sách mới)
    public int insert(Book b) {
        String sql = "INSERT INTO Book (name, category, author, prize) VALUES (?, ?, ?, ?)";
        try (Connection con = JdbcHelper.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, b.getName());
            ps.setString(2, b.getCategory());
            ps.setString(3, b.getAuthor());
            ps.setDouble(4, b.getPrize());

            return ps.executeUpdate(); // Trả về số dòng thêm được (1 là thành công)
        } catch (Exception e) {
            e.printStackTrace();
            return 0; // Thất bại
        }
    }

    // 3. UPDATE (Cập nhật sách theo ID)
    public int update(Book b) {
        String sql = "UPDATE Book SET name=?, category=?, author=?, prize=? WHERE id=?";
        try (Connection con = JdbcHelper.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, b.getName());
            ps.setString(2, b.getCategory());
            ps.setString(3, b.getAuthor());
            ps.setDouble(4, b.getPrize());
            ps.setInt(5, b.getId()); // Quan trọng: Phải có ID để biết sửa thằng nào

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // 4. DELETE (Xóa sách theo ID)
    public int delete(int id) {
        String sql = "DELETE FROM Book WHERE id=?";
        try (Connection con = JdbcHelper.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Phương thức tạo bảng (public để có thể gọi từ bên ngoài)
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Book ("
                + "  id INT AUTO_INCREMENT PRIMARY KEY, "
                + "  name VARCHAR(100), "
                + "  category VARCHAR(50), "
                + "  author VARCHAR(50), "
                + "  prize DOUBLE" // MySQL dùng DOUBLE hoặc DECIMAL cho tiền tệ
                + ")";

        try (Connection con = JdbcHelper.openConnection();
             Statement st = con.createStatement()) {

            st.execute(sql);
            System.out.println("Đã kiểm tra/tạo bảng Book thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
