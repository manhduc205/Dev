/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bai_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class connect{
    private Connection conn;

    public connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        String host = "localhost";
        String port = "3306";
        String dbName = "product";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        String username = "root";
        String password = "742005";
        try {
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public Connection getConnection() {
        return conn;
    }
}
