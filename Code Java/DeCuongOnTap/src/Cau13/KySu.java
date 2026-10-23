/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau13;

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
    @Override
    public void in() {
        super.in();
        System.out.println("mangach : " + mangach);
        System.out.println("bacluong: " + bacluong);
        System.out.println("hesoluong: " + hesoluong);
       
    }
    public static void main(String[] args) {
        ArrayList<KySu> ks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        File f = new File("D:\\kysu.dat");
        while(true){
            System.out.println("-----MENU-----");
            System.out.println("1.Doc file ky su");
            System.out.println("2.In ra ky su");
            System.out.println("0.Thoat menu");
            System.out.println("Lua chon cua ban: ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    try (BufferedReader br = new BufferedReader(new FileReader(f))){
                        String line;
                        while((line = br.readLine()) != null){
                            String[] data = line.split("\\#");
                            String hoten = data[0];
                            String ngaysinh = data[1];
                            String diachi = data[2];
                            String gioitinh = data[3];
                            String mangach = data[4];
                            float  bacluong = Float.parseFloat(data[5]);
                            float hesoluong = Float.parseFloat(data[6]);     
                            KySu k = new KySu(hoten, ngaysinh, diachi, gioitinh, mangach, bacluong, hesoluong);
                            ks.add(k);
                        }
                        
                    } catch (Exception e) {
                        System.out.println("Co loi ki doc file");
                    }
                    break;
                case 2:
                    System.out.println("+----+----------------------+------------+--------------------------+----------+------------+-----------+--------------+");
                    System.out.printf("| %-2s | %-20s | %-10s | %-25s | %-8s | %-10s | %-9s | %-12s |\n",
                            "STT", "Họ Tên", "Ngày Sinh", "Dia chi", "Giới Tính", "Mã Ngạch", "Bậc Lương", "Hệ Số Lương");
                    System.out.println("+----+----------------------+------------+-------------------+----------+------------+-----------+--------------+");
                    int stt = 1;
                    for (KySu x : ks) {
                        System.out.printf("| %-2d | %-20s | %-10s | %-25s | %-8s | %-10s | %-9.1f | %-12.1f |\n",
                                stt++, x.getHoten(), x.getNgaysinh(), x.getDiachi(), x.getGioitinh(),
                                x.getMangach(), x.getBacluong(), x.getHesoluong());
                    }
                    System.out.println("+----+----------------------+------------+--------------------------+----------+------------+-----------+--------------+");
                    break;
                case 0:
                        
                    System.out.println("Thoat menu thanh cong");
                    return;
                default:
                    throw new AssertionError();
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
