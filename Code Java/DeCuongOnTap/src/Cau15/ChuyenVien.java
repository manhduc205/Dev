/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
            System.out.println("1.Doc file");
            System.out.println("2.Hien thi danh sach");
            System.out.println("0.Thoat menu");
            System.out.println("Lua chon cua ban: ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    try (BufferedReader br = new BufferedReader(new FileReader(f))){
                        String line;
                        while((line = br.readLine()) != null){
                            String[] data = line.split("\\$");
                            String hoten = data[0];
                            String ngaysinh = data[1];
                            String diachi = data[2];
                            String gioitinh = data[3];
                            String mangach = data[4];
                            float  bacluong = Float.parseFloat(data[5]);
                            float hesoluong = Float.parseFloat(data[6]);
                            ChuyenVien c= new ChuyenVien(hoten, ngaysinh, diachi, gioitinh, mangach, bacluong, hesoluong);
                            cv.add(c);
                        }
                    } catch (Exception e) {
                        System.out.println("co loi khi doc file!");
                    }
                    break;
                case 2:
                    System.out.printf("| %-20s | %-10s | %-25s | %-10s | %-8s | %-8s | %-8s\n" , "Ho ten" , "Ngay sinh" , "Dia chi" , "Gioi tinh" , "Ma Ngach", "Bac Luong" , "He so luong");
                    for(ChuyenVien x : cv){
                        System.out.printf("| %-20s | %-10s | %-25s | %-10s | %-8.2s | %-8.2f | %-8.2f\n" ,
                                x.getHoten() , x.getNgaysinh() , x.getDiachi() , x.getGioitinh() , x.getMangach(), x.getBacluong() , x.getHesoluong());
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

    public String getMangach() {
        return mangach;
    }

    public float getBacluong() {
        return bacluong;
    }

    public float getHesoluong() {
        return hesoluong;
    }
}
