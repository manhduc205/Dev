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
public class testupdate{
    public static void main(String[] args) {

        try {
        updatesql updateDb = new updatesql();
        selectsql selectDb = new selectsql();
        boolean updated = updateDb.updateUser("U003", "nguyenmanhduc", "nguyenmanhduc@gmail.com", "123");
        if (updated) {
            System.out.println("Update thanh cong!");
        } else {
            System.out.println("Update that bai!");
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
    
