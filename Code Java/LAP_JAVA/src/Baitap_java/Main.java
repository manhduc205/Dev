/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Baitap_java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class Main {
    public static void main(String[] args) throws IOException {
        SinhvienHTTT h = null;
        SinhvienUTT u = null;
        File utt = new File("D:\\svutt.dat");
        File httt = new File("D:\\svhttt.dat");
        Scanner sc = new Scanner(System.in);
        while(true){
        System.out.println("Vui long chon chuc nang: ");
        System.out.println("1: Sinh vien UTT");
        System.out.println("2: Sinh vien HTTT");
        int chon;
        chon = sc.nextInt();
            switch (chon) {
                case 1:
                    u = new SinhvienUTT();
                    u.nhap();
                    FileWriter fw = new FileWriter(utt);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.write("Ma sv: " + u.getMasv() + "\n");
                    pw.write("Ho ten: " + u.getHoten() + "\n");
                    pw.write("Ngay sinh: " + u.getNgaysinh() + "\n");
                    pw.write("Gioi tinh: " + u.getGioitinh()+ "\n");
                    pw.write("DIem tb: " + u.getDiemtb()+ "\n");
                    pw.write("Don vi: " + u.getDonvi()+ "\n");
                    pw.write("Luong: " + u.getLuong() + "\n");
                    pw.close();
//                    FileOutputStream fosu = new FileOutputStream(utt);
//                    ObjectOutputStream oosu = new ObjectOutputStream(fosu);
//                    oosu.writeObject(u);
                    break;
                case 2:
                    h = new SinhvienHTTT();
                    h.nhap();
                    FileWriter fwh = new FileWriter(httt);
                    PrintWriter pwh = new PrintWriter(fwh);
                    pwh.write("Ma sv: " + h.getMasv() + "\n");
                    pwh.write("Ho ten: " + h.getHoten() + "\n");
                    pwh.write("Ngay sinh: " + h.getNgaysinh() + "\n");
                    pwh.write("Gioi tinh: " + h.getGioitinh()+ "\n");
                    pwh.write("DIem tb: " + h.getDiemtb()+ "\n");
                    pwh.write("hoc phi: " + h.getHocphi()+ "\n");
                    pwh.close();
//                    FileOutputStream fos = new FileOutputStream(httt);
//                    ObjectOutputStream oos = new ObjectOutputStream(fos);
//                    oos.writeObject(h);
                    
                    break;
                default:
                    System.out.println("Lua chọn khong hop le!");
            }
        }
    }
}
