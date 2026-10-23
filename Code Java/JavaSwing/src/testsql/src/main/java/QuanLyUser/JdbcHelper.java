/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyUser;

/**
 *
 * @author DucPc
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcHelper {

    private static final String USER = "root";
    private static final String PASSWORD = "123456"; 
    private static final String DB_NAME = "tt23"; 
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
}
