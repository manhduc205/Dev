/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitapvenhaday5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class myConnection {
    private String host;
    private String port;
    private String dbName;
    private String url;
    private String userName;
    private String password;
    Connection conn;
    
    public myConnection(){
        host = "localhost";
        port = "3306";
        dbName = "sinhvien";
        url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        userName = "root";
        password = "123456";
    }

    public myConnection(String host, String port, String dbName, String url, String userName, String password) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.url = url;
        this.userName = userName;
        this.password = password;
    }
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if(conn != null){
                return conn;
            }
            conn = DriverManager.getConnection(url,userName,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    //CRUD SINHVIEN
    public List<String> getSinhvien(){
        List<String> list = new ArrayList<>();
        
        try {
            Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from sinhvien";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
               String id = rs.getString("id");
               String name = rs.getString("name");
               int age = rs.getInt("age");
               list.add(id+"-"+name+"-"+age);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean updatesv(String id, String name, int age){
        String sql = "update sinhvien set name = ?, age = ? where id = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, name);  
            ps.setInt(2, age);      
            ps.setString(3, id);
            return ps.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deletesv(String id) {
        String sql = "delete from sinhvien where id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean addsv(String id, String name, int age){
        String sql = "insert into sinhvien values (?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            return ps.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    // CRUD ITEMS
    public List<String> getitem(){
        List<String> listitem = new ArrayList<>();
        
        try{
            Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from sanpham";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String id = rs.getString("id");
                String category = rs.getString("category");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String description = rs.getString("description");
                listitem.add(id + "-" + category + "-" + name + "-" + price + "-" + quantity + "-" + description);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return listitem;
    }
    
    public boolean updateitem(String id,String category,String name, double price, int quantity, String description){
        String sql = "update sanpham set category = ?, name = ?, price = ?, quantity = ?, description = ? where id = ?";
        try{PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, category);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, description);
            ps.setString(6, id);
            return ps.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteitem(String id){
        String sql = "delete from sanpham where id = ?";
        try{PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
    }catch(Exception e){
        e.printStackTrace();
    }
        return false;
    }

    public boolean additem(String id,String category,String name, double price, int quantity, String description){
        String sql = "insert into sanpham(id,category,name,price,quantity,description) values(?,?,?,?,?,?)";
        try{PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, category);
            ps.setString(3, name);
            ps.setDouble(4, price);
            ps.setInt(5, quantity);
            ps.setString(6, description);
           return ps.executeUpdate() > 0;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    //CRUD CATEGORY
    public List<String> getcategory(){
        List<String> listcategory = new ArrayList<>();
        try{
            Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select category from sanpham";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                String category = rs.getString("category");
                listcategory.add(category);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listcategory;
    }
    
    public boolean updatecategory(String oldcategory, String newcategory){
        String sql = "update sanpham set category = ? where category = ?";
        try{PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1,newcategory);
            ps.setString(2, oldcategory);
            return ps.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deletecategory(String category){
        String sql = "delete from sanpham where category =?";
        try{PreparedStatement ps = getConnection().prepareStatement(sql);
        ps.setString(1, category);
        return ps.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    
    public static void main(String[] args) {
        try {
            List<String> list = new myConnection().getSinhvien();
            for (String s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
            e.printStackTrace();
        }
    }


}
