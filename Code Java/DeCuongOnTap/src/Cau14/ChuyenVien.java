/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau14;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class ChuyenVien extends CanBo {
    private String mangach;
    public float bacluong, hesoluong;

    public ChuyenVien() {
    }

    @Override
    public String toString() {
        return super.toString() + "ChuyenVien{" + "mangach=" + mangach + ", bacluong=" + bacluong + ", hesoluong=" + hesoluong + '}';
    }

    public ChuyenVien(String hoten, String ngaysinh, String diachi, String gioitinh, String mangach, float bacluong, float hesoluong ) {
        super(hoten, ngaysinh, diachi, gioitinh);
        this.mangach = mangach;
        this.bacluong = bacluong;
        this.hesoluong = hesoluong;
    }
    @Override
    public void in(){
        super.in();
        System.out.println("mangach : " + mangach);
        System.out.println("bacluong: " + bacluong);
        System.out.println("hesoluong: " + hesoluong);
    }
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Ma ngach: ");
        mangach = sc.nextLine();
        System.out.println("Nhap bac luong: ");
        bacluong = sc.nextFloat();
        System.out.println("Nhap he so luong: ");
        hesoluong = sc.nextFloat();
    }
    public static void main(String[] args) {
        ArrayList<ChuyenVien> cv = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        File f = new File("D:\\chuyenvien.dat");
        while(true){
            System.out.println("-----MENU-----");
            System.out.println("1.Them chuyen vien");
            System.out.println("2.Luu du lieu");
            System.out.println("0.Thoat menu");
            System.out.println("Lua chon cua ban: ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    System.out.println("Nhap so luong chuyen vien: ");
                    int n = sc.nextInt();
                    for(int i = 0; i < n; i++){
                        ChuyenVien a = new ChuyenVien();
                        a.nhap();
                        cv.add(a);
                        
                    }
                    for(ChuyenVien x : cv){
                        x.in();
                    }
                    break;
                case 2:
                    if(cv.isEmpty()){
                        System.out.println("Ban phai khoi tao truoc");
                    }
                    try (PrintWriter pw = new PrintWriter(new FileWriter(f))){
                        for(int i = 0; i < cv.size(); i++){
                            pw.write(cv.get(i).toString());
                        }
                    } catch (Exception e) {
                        System.out.println("Co loi khi luu file");
                    }
                    break;
                case 0:
                    System.out.println("Thoat menu thanh cong");
                    return;
                default:
                    System.out.println("Vui long nhap lai lua chon hop le");
            }
        }
    }
}

