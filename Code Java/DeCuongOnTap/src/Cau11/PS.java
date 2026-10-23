/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau11;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class PS {
    private int tu, mau;

    public PS(int tu) {
        this.tu = tu;
    }

    @Override
    public String toString() {
        return "PS{" + tu + " / " + mau + '}';
    }

    public PS(int tu, int mau) {
        if(mau == 0){
            throw new IllegalAccessError("Mau so khong duoc = 0");
        }
        this.tu = tu;
        this.mau = mau;
    }
    public PS cong(PS ps2){
        int tu = this.tu * ps2.mau + this.mau * ps2.tu;
        int mau = this.mau * ps2.mau;
        return new PS(tu ,mau);
    }

    public PS() {
        this.tu = 0;
        this.mau = 1;
    }
    public PS tru(PS ps2){
        int tu = this.tu * ps2.mau - this.mau * ps2.tu;
        int mau = this.mau * ps2.mau;
        return new PS(tu ,mau);
    }
    public PS nhan(PS ps2){
        int tu = this.tu * ps2.tu;
        int mau = this.mau * ps2.mau;
        return new PS(tu ,mau);
    }
    public PS chia(PS ps2){
        int tu = this.tu * ps2.mau ;
        int mau = this.mau * ps2.tu;
        return new PS(tu ,mau);
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tu so: ");
        tu = sc.nextInt();
        System.out.println("Nhap mau so: ");
        mau = sc.nextInt();
    }
    public void in(){
        System.out.println(tu + " / " + mau);
    }
    public static void main(String[] args) {
        ArrayList<PS> ar = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        File f = new File("D:\\phanso.dat");
//        PS ps1 = new PS();
//        PS ps2 = new PS();
        while(true){
            System.out.println("-----MENU-----");
            System.out.println("1.Tinh Tong");
            System.out.println("2.Luu giu lieu");
            System.out.println("Lua chon cua ban: ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    System.out.println("Nhap so luong phan so: ");
                    int n  = sc.nextInt();
                    sc.nextLine();
                    for(int i = 0 ; i< n; i++){
                        PS ps1= new PS();
                        ps1.nhap();
                        ar.add(ps1);
                    }
                    PS sum = new PS();
                    for(int i = 0 ; i< n - 1; i++){
                        
                        sum = ar.get(i).cong(ar.get(i + 1));
                    }
                    System.out.println("Tong cac phan so: " + sum);
                    break;
                case 2:
                    try (PrintWriter pw = new PrintWriter(new FileWriter(f))){
                        for(int i = 0; i < ar.size(); i++){
                            pw.write(ar.get(i).toString());
                        }
                        
                    } catch (Exception e) {
                        System.out.println("co loi khi luu file");
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}

