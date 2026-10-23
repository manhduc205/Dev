/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testsql;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public class testinsert{
    public static void main(String[] args) {

        try {
        insertsql insertDb = new insertsql();
        selectsql selectDb = new selectsql();

        boolean inserted = insertDb.insertUser("U003", "nguyenmanhduc", "nguyenmanhduc@gmail.com", "123456");

        if (inserted) {
            System.out.println("Insert thành công!");
        } else {
            System.out.println("Insert thất bại!");
        }

        List<String> list = selectDb.getAllUser();
        for (String s : list) {
            System.out.println(s);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    
