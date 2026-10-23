/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class selectsql {

    private String host;
    private String port;
    private String dbName;
    private String url;
    private String userName;
    private String password;
    Connection conn;

    public selectsql() {
        host = "localhost";
        port = "3306";
        dbName = "tt23";
        url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        userName = "root";
        password = "123456";
    }

    public selectsql(String host, String port, String dbName, String url, String username, String password) {
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
    public List<String> getAllUser() {
        List<String> list = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from tbl_user";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String userid = rs.getString("userid");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                list.add(userid+"-"+username+"-"+email+"-"+password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}