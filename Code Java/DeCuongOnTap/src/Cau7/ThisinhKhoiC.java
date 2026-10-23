package Cau7;

import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class ThisinhKhoiC extends Thisinh {
    private float diemvan , diemsu , diemdia ;
    public ThisinhKhoiC(){
        
    }
    public ThisinhKhoiC(float diemvan, float diemsu, float diemdia, String hoten, String ngaysinh, String diachi) {
        super(hoten, ngaysinh, diachi);
        this.diemvan = diemvan;
        this.diemsu = diemsu;
        this.diemdia = diemdia;
    }
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap diem van: ");
        diemvan = sc.nextFloat();
        System.out.println("Nhap diem su: ");
        diemsu = sc.nextFloat();
        System.out.println("Nhap diem dia: ");
        diemdia = sc.nextFloat();
    }
    @Override
    public void in(){
        super.in();
        System.out.println("Diem van: " + diemvan);
        System.out.println("Diem su: " + diemsu);
        System.out.println("Diem dia: " + diemdia);
    }

    @Override
    public String toString() {
        
        return super.toString() + "ThisinhKhoiC{" + "diemvan=" + diemvan + ", diemsu=" + diemsu + ", diemdia=" + diemdia + '}';
    }
    public float tongdiemc(){
        return diemvan + diemsu + diemdia;
    }
    
}
