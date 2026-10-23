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
public class testdelete{
    public static void main(String[] args) {

        try {
        deletesql deleteDb = new deletesql();
        selectsql selectDb = new selectsql();
        boolean deleted = deleteDb.deleteUser("U002");
        if (deleted) {
            System.out.println("Delete thanh cong!");
        } else {
            System.out.println("Delete that bai!");
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
    
