/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau3;

import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class NhanVien extends Cau2.Person {
    private String phongban;
    private float hesoluong ,thamnien ,luongcoban;
    public NhanVien(){
        
    }

    public NhanVien(String hoten, String ngaysinh, String diachi, String gioitinh, String phongban, float hesoluong, float thamnien, float luongcoban) {
        super(hoten, ngaysinh, diachi, gioitinh);
        this.phongban = phongban;
        this.hesoluong = hesoluong;
        this.thamnien = thamnien;
        this.luongcoban = luongcoban;
    }
    public float luongthuclinh(){
        return luongcoban*hesoluong*(1 + thamnien/100);
    }
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap phong ban: ");
        phongban = sc.nextLine();
        System.out.println("Nhap he so luong: ");
        hesoluong = sc.nextFloat();
        sc.nextLine();
        System.out.println("Nhap tham nien: ");
        thamnien = sc.nextFloat();
        sc.nextLine();
        System.out.println("Nhap luong co ban: ");
        luongcoban = sc.nextFloat();
        sc.nextLine();
        
    }
    @Override
    public void in(){
        super.in();
        System.out.println("He so luong: " + hesoluong);
        System.out.println("Tham nien: " + thamnien);
        System.out.println("Luong co ban: " + luongcoban);
        java.text.DecimalFormat df = new java.text.DecimalFormat("#,##0.00");
        System.out.println("Luong thuc linh: " + df.format(luongthuclinh()));
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "phongban=" + phongban + "\n hesoluong=" + hesoluong + "\n thamnien=" + thamnien + "\n luongcoban=" + luongcoban + "\nLuong thuc linh: " + luongthuclinh() ;
    }
}
