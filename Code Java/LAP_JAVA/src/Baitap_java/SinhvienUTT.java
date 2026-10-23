/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Baitap_java;

import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class SinhvienUTT extends Sinhvien {
    private float donvi, luong;

    public float getDonvi() {
        return donvi;
    }

    public float getLuong() {
        return luong;
    }
    public SinhvienUTT(){
        
    }
    @Override
    public void in(){
        super.in();
        System.out.println("Don vi: " + donvi);
        System.out.println("Luong: " + luong);
    }
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap don vi: ");
        donvi = sc.nextFloat();
        System.out.println("Nhap luong: ");
        luong = sc.nextFloat();
        
    }
}
