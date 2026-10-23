/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai11;

/**
 *
 * @author DucPc
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
    public Connection getConnection() {
        Connection conn = null;
        try {
            // Thay đổi thông tin database của bạn ở đây
            String dbName = "quanlysinhvien"; 
            String user = "root";
            String pass = "123456"; // Mật khẩu của bạn, thường là trống hoặc "123456"
            String url = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&characterEncoding=UTF-8";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
