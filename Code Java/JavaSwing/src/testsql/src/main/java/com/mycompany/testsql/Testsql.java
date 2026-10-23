/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author user
 */
public class Testsql {
    public static void main(String[] args) {
        try {
            List<String> list = new selectsql().getAllUser();
            for (String s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
            e.printStackTrace();
        }
    }
}