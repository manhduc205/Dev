/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau12;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class KySu extends CanBo {
    private String mangach;
    private float bacluong, hesoluong;
    public KySu(){
        
    }

    public KySu(String hoten, String ngaysinh, String diachi, String gioitinh,String mangach, float bacluong, float hesoluong ) {
        super(hoten, ngaysinh, diachi, gioitinh);
        this.mangach = mangach;
        this.bacluong = bacluong;
        this.hesoluong = hesoluong;
    }

    @Override
    public String toString() {
        return super.toString() + "" + "mangach=" + mangach + ", bacluong=" + bacluong + ", hesoluong=" + hesoluong + '}';
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
    public void in() {
        super.in();
        System.out.println("mangach : " + mangach);
        System.out.println("bacluong: " + bacluong);
        System.out.println("hesoluong: " + hesoluong);
       
    }
    public static void main(String[] args) {
        ArrayList<KySu> cb = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        File f = new File("D:\\kysu.dat");
        while(true){
            System.out.println("-----MENU-----");
            System.out.println("1.Them ky su");
            System.out.println("2.Luu du lieu");
            System.out.println("0.Thoat menu");
            System.out.println("Lua chon cua ban: ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    
                    System.out.println("Nhap so luong canbo: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for(int i = 0; i < n; i++){
                        KySu c = new KySu();
                        c.nhap();
                        cb.add(c);
                    }
                    for(KySu x : cb){
                        x.in();
                    }
                    
                    break;
                case 2:
                    if(cb.isEmpty()){
                        System.out.println("Ban phai khoi tao truoc");
                        break;
                    }
                    try (PrintWriter pw = new PrintWriter(new FileWriter(f))){
                        for(int i = 0; i < cb.size(); i++){
                            pw.write(cb.get(i).toString());
                        }
                        
                    } catch (Exception e) {
                        System.out.println("Co loi khi luu file");
                    }
                    System.out.println("Luu du lieu thanh cong");
                    break;
                case 0:
                    System.out.println("Thoat menu thanh cong");
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
