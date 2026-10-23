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
public class SinhvienHTTT extends Sinhvien {
    private float hocphi;

    public float getHocphi() {
        return hocphi;
    }
    public SinhvienHTTT(){
        
    }
    @Override
    public void in(){
        super.in();
        System.out.println("Hoc phi: " + hocphi);
    }
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap hoc phi: ");
        hocphi = sc.nextFloat();
       
    }
}
