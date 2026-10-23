/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau7;

import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class ThisinhKhoiA extends Thisinh{
    private float diemtoan, diemly, diemhoa;
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap diem toan: ");
        diemtoan = sc.nextFloat();
        System.out.println("Nhap diem Ly: ");
        diemly = sc.nextFloat();
        System.out.println("Nhap diem Hoa: ");
        diemhoa = sc.nextFloat();
    }

    public ThisinhKhoiA() {
    }

    public ThisinhKhoiA(String hoten, String ngaysinh, String diachi, float diemtoan, float diemly, float diemhoa) {
        super(hoten, ngaysinh, diachi);
        this.diemtoan = diemtoan;
        this.diemly = diemly;
        this.diemhoa = diemhoa;
    }

    @Override
    public String toString() {
       
        return super.toString() + "ThisinhKhoiA{" + "diemtoan=" + diemtoan + ", diemly=" + diemly + ", diemhoa=" + diemhoa + '}';
    }
    @Override
    public void in(){
        super.in();
        System.out.println("Diem toan: " + diemtoan);
        System.out.println("Diem ly: " + diemly);
        System.out.println("Diem hoa: " + diemhoa);
    }
    public float tongdiema(){
        return diemtoan + diemly + diemhoa;
    }
}
