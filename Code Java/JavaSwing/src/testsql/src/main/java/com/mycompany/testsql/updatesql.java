/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class updatesql{

    private String host;
    private String port;
    private String dbName;
    private String url;
    private String userName;
    private String password;
    Connection conn;

    public updatesql() {
        host = "localhost";
        port = "3306";
        dbName = "tt23";
        url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        userName = "root";
        password = "123456";
    }

    public updatesql(String host, String port, String dbName, String url, String username, String password) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.url = url;
        this.userName = username;
        this.password = password;
    }
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (conn != null) {
               return conn; 
            }
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public Statement getStatement() {
        Connection conn = this.getConnection();
        Statement stmt = null;
        try {
                if (conn != null) {
                stmt = conn.createStatement();
                return stmt;
            }
            conn = DriverManager.getConnection(url, userName, password);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stmt;
    }
    public boolean updateUser(String userid, String newUsername, String newEmail, String newPassword) {
    try {
        Connection conn = this.getConnection();
        String sql = "UPDATE tbl_user SET username = ?, email = ?, password = ? WHERE userid = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, newUsername);
        ps.setString(2, newEmail);
        ps.setString(3, newPassword);
        ps.setString(4, userid);
        int rows = ps.executeUpdate();
        return rows > 0;  // true nếu update thành công
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

}