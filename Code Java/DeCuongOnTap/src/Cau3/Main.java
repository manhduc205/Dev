/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class Main {
    public static void main(String[] args) {
        File f = new File("D:\\nhanvien.dat");
        Scanner sc = new Scanner(System.in);
        ArrayList<NhanVien> p = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split("\\$");
                String hoten = data[0];
                String ngaysinh = data[1];
                String diachi = data[2];
                String gioitinh = data[3];
                String phongban = data[4];
                float hesoluong = Float.parseFloat(data[5]);
                float thamnien = Float.parseFloat(data[6]);
                float luongcoban = Float.parseFloat(data[7]);
                NhanVien nv = new NhanVien(hoten, ngaysinh, diachi, gioitinh, phongban, hesoluong, thamnien, luongcoban);
                p.add(nv);
            }
        } catch (Exception e) {
            System.out.println("Co loi khi doc file");
        }
        for(NhanVien x : p){
            x.in();
        }
    
    }
       
}
