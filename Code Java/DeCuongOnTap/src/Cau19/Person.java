/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau19;

import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class Person {
    protected String hoten, ngaysinh, diachi, gioitinh;

    public Person() {
    }
    public String getHoten() {
        return hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getGioitinh() {
        return gioitinh;
    }
    public Person(String hoten, String ngaysinh, String diachi, String gioitinh) {
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ho ten: ");
        hoten = sc.nextLine();
        System.out.println("Nhap ngay sinh: ");
        ngaysinh = sc.nextLine();
        System.out.println("Nhap dia chi: ");
        diachi = sc.nextLine();
        System.out.println("Nhap gioi tinh: ");
        gioitinh = sc.nextLine();
       
    }
    public void in(){
        System.out.println("Ho ten: " + hoten);
        System.out.println("Ngay sinh: " + ngaysinh);
        System.out.println("Dia chi: " + diachi);
        System.out.println("Gioi tinh " + gioitinh);        
    }

    @Override
    public String toString() {
        return "\n" + "hoten=" + hoten + ", ngaysinh=" + ngaysinh + ", diachi=" + diachi + ", gioitinh=" + gioitinh ;
    }
    
}
