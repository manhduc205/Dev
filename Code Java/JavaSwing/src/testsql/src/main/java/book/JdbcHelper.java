package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcHelper {

    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static final String DB_NAME = "JavaSwing";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
   

    static {
        try {
           
             Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi tải Driver: " + e.getMessage());
        }
    }
    public static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection con = openConnection();
            if (con != null) {
                System.out.println("Kết nối thành công tới: " + DB_NAME);
                // Đóng thử luôn cho sạch
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại!");
            e.printStackTrace();
        }
    }
}