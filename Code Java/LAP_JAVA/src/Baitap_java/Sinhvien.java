/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Baitap_java;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class Sinhvien implements Serializable {
    private String masv , hoten , ngaysinh , gioitinh ;

    public String getMasv() {
        return masv;
    }

    public String getHoten() {
        return hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public float getDiemtb() {
        return diemtb;
    }
    private float diemtb;
    public Sinhvien(){
    }
    public Sinhvien(String masv , String hoten , String ngaysinh , String gioitinh, float diemtb ){
        this.masv = masv;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diemtb = diemtb;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma sinh vien: ");
        masv = sc.nextLine();
        System.out.println("Nhap ho ten: ");
        hoten = sc.nextLine();
        System.out.println("Nhap ngay sinh: ");
        ngaysinh = sc.nextLine();
        System.out.println("Nhap gioi tinh: ");
        gioitinh = sc.nextLine();
        System.out.println("Nhap diem tb: ");
        diemtb = sc.nextFloat();
    }
    public void in(){
        System.out.println("ma sinh vien: " + masv);
        System.out.println("Ho va ten: " + hoten);
        System.out.println("ngay sinh: " + ngaysinh);
        System.out.println("gioi tinh: " + gioitinh);
        System.out.println("diem trung bình" + diemtb);
    }
}
