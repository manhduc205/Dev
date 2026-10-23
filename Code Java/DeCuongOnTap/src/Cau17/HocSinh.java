/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau17;

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
public class HocSinh extends Person {
    private String mahs , lop;
    private float diemtongket;

    public HocSinh() {
    }

    public HocSinh(String hoten, String ngaysinh, String diachi, String gioitinh,String mahs, String lop, float diemtongket) {
        super(hoten, ngaysinh, diachi, gioitinh);
        this.mahs = mahs;
        this.lop = lop;
        this.diemtongket = diemtongket;
    }
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma hoc sinh: ");
        mahs = sc.nextLine();
        System.out.println("Nhap lop: ");
        lop = sc.nextLine();
        System.out.println("Nhap diem tong ket: ");
        diemtongket = sc.nextFloat();
        sc.nextLine();
    }
    @Override
    public void in(){
        super.in();
        System.out.println("Ma hoc sinh: " + mahs);
        System.out.println("Lop: " + lop );
        System.out.println("Diem tong ket: " + diemtongket);
    }

    @Override
    public String toString() {
        return super.toString() + " " + "ma hoc sinh: " + mahs + ", Lop:" + lop + ", Diem tong ket:" + diemtongket ;
    }

    public String getMahs() {
        return mahs;
    }

    public String getLop() {
        return lop;
    }

    public float getDiemtongket() {
        return diemtongket;
    }
    
    
    public static void main(String[] args) {
        ArrayList<HocSinh> hs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        File f = new File("D:\\hocsinh.dat");
        while(true){
            System.out.println("-----MENU-----");
            System.out.println("1.Doc file hoc sinh");
            System.out.println("2.Hien thi");
            System.out.println("0.Thoat menu");
            System.out.println("Lua chon cua ban: ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    try (BufferedReader br = new BufferedReader(new FileReader(f))){
                        String line;
                        while((line = br.readLine()) != null){
                            String[] data = line.split("\\&");
                            String hoten = data[0];
                            String ngaysinh = data[1];
                            String diachi = data[2];
                            String gioitinh = data[3];
                            String mahs = data[4];
                            String lop = data[5];
                            float diemtongket = Float.parseFloat(data[6]);
                            HocSinh h = new HocSinh(hoten, ngaysinh, diachi, gioitinh, mahs, lop, diemtongket);
                            hs.add(h);
                        }
                        System.out.println("Doc file thanh cong!");
                    } catch (Exception e) {
                        System.out.println("Co loi khi doc file");
                    }
                    break;
                case 2:
                    System.out.printf("| %-10s | %-10s | %-20s | %-10s | %-10s | %-10s | %-10s |\n",
                            "Ho ten","Ngay sinh", "Dia chi", "Gioi tinh" , "Ma hs", " Lop ", "Diem tong ket");
                    System.out.println("--------------------------------------------------------------------"
                            + "---------------------------------------------------");
                    for(HocSinh x : hs){
                        System.out.printf("| %-10s | %-10s | %-20s | %-10s | %-10s | %-10s | %-10.2f |\n",
                            x.getHoten(),x.getNgaysinh(), x.getDiachi(), x.getGioitinh() , x.getMahs(), x.getLop(), x.getDiemtongket());
                    }
                    break;
                case 0:
                    System.out.println("Thoat menu thanh cong!");
                    return;
                default:
                    System.out.println("Vui long nhap lua chon hop le");
            }
        }
    }
}
