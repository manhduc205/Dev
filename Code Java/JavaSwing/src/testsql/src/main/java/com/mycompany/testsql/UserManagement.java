/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testsql;

/**
 *
 * @author DucPc
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

/**
 *
 * @author user
 */
public class UserManagement {

    private String host = "localhost";
    private String port = "3306";
    private String dbName = "tt23";
    private String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
    private String userName = "root";
    private String password = "123456";
    Connection conn;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (conn != null && !conn.isClosed()) {
                return conn;
            }
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

   
    public List<String> getAllUser() {
        List<String> list = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            String sql = "select * from tbl_user";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String userid = rs.getString("userid");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                list.add(userid + "-" + username + "-" + email + "-" + password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void printList() {
        List<String> list = this.getAllUser();
        System.out.println("--- DANH SACH USER ---");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------------");
    }

    // insert
    public void insertUser(String userid, String username, String email, String password) {
        try {
            Connection conn = this.getConnection();
            String sql = "INSERT INTO tbl_user (userid, username, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userid);
            ps.setString(2, username);
            ps.setString(3, email);
            ps.setString(4, password);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Insert thanh cong: " + username);
            } else {
                System.out.println("Insert that bai!");
            }
        } catch (Exception e) {
            System.out.println(">> Loi Insert: " + e.getMessage());
        }
    }

    // update
    public void updateUser(String userid, String newUsername, String newEmail, String newPassword) {
        try {
            Connection conn = this.getConnection();
            String sql = "UPDATE tbl_user SET username = ?, email = ?, password = ? WHERE userid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newUsername);
            ps.setString(2, newEmail);
            ps.setString(3, newPassword);
            ps.setString(4, userid);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println(">> Update thanh cong user ID: " + userid);
            } else {
                System.out.println(">> Update that bai!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // delete
    public void deleteUser(String userid) {
        try {
            Connection conn = this.getConnection();
            String sql = "DELETE FROM tbl_user WHERE userid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userid);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println(">> Delete thanh cong user ID: " + userid);
            } else {
                System.out.println(">> Delete that bai!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserManagement manager = new UserManagement();
        Scanner sc = new Scanner(System.in);
        manager.printList();
        
        int choice = 0;
        
        do {
            System.out.println("\n=== MENU TEST (DU LIEU CUNG) ===");
            System.out.println("1. Test Insert ");
            System.out.println("2. Test Update ");
            System.out.println("3. Test Delete ");
            System.out.println("4. Xem lai danh sach");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        
                        manager.insertUser("U003", "nguyenmanhduc", "nguyenmanhduc@gmail.com", "123456");
                        manager.printList();
                        break;
                        
                    case 2:
                        
                        manager.updateUser("U003", "nguyenmanhduc_edited", "edited@gmail.com", "newpass123");
                        manager.printList();
                        break;
                        
                    case 3:
                        manager.deleteUser("U003");
                        manager.printList();
                        break;
                        
                    case 4:
                        manager.printList();
                        break;
                        
                    case 0:
                        System.out.println("Thoat chuong trinh.");
                        break;
                        
                    default:
                        System.out.println("Vui long chon tu 0-4");
                }
            } catch (Exception e) {
                System.out.println("Vui long nhap so!");
                sc.nextLine();
            }
            
        } while (choice != 0);
    }
}
