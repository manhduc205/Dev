package Cau10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class GiangVien {
    private String hoten , magv ,diachi ,gioitinh ,khoa;

    public GiangVien() {
    }

    public GiangVien(String hoten, String magv, String diachi, String gioitinh, String khoa) {
        this.hoten = hoten;
        this.magv = magv;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.khoa = khoa;
    }
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ho ten: ");
        hoten = sc.nextLine();
        System.out.println("Nhap Ma giang vien: ");
        magv = sc.nextLine();
        System.out.println("Nhap Dia chi: ");
        diachi = sc.nextLine();
        System.out.println("Nhap gioi tinh: ");
        gioitinh = sc.nextLine();
        System.out.println("Nhap khoa: ");
        while (true) {
            khoa = sc.nextLine();
            if (khoa.equals("DTVT") || khoa.equals("CNTT") || khoa.equals("HTTT") || khoa.equals("CNM") || khoa.equals("CNPM")) {
                break;
            } else {
                System.out.println("Khoa khong hop le, vui long nhap lai (DTVT, CNTT, HTTT, CNM, CNPM): ");
            }
        }
    }
    public void LuuTru(String tenfile){
        try(PrintWriter pw = new PrintWriter(new FileWriter(tenfile))) {
            pw.write("Ho ten: " + hoten + "\n");
            pw.write("Ma gv: " + magv + "\n");
            pw.write("Dia chi: " + diachi + "\n");
            pw.write("Gioi tinh: " + gioitinh+ "\n");
            pw.write("khoa: " + khoa+ "\n");
            System.out.println("Da luu vao file");
        } catch (Exception e) {
            System.out.println("Loi khi luu giu lieu");
        }
    }
    public static void SaoLuu(String tenfile1, String tenfile2){
        try(BufferedReader br = new BufferedReader(new FileReader(tenfile1)); 
            BufferedWriter bw = new BufferedWriter(new FileWriter(tenfile2))) {
            String line;
            while((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Du lieu da duoc sao luu");
        } catch (Exception e) {
            System.out.println("Loi khi sao luu");
        }
    }
    public static void XoaFile(String tenfile){
        File f = new File(tenfile);
        if(f.exists()){
            f.delete();
            System.out.println("Da Xoa File thanh cong");
        }
        else{
            System.out.println("File khong ton tai");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GiangVien gv = new GiangVien();
        gv.nhap();
        while(true){
            System.out.println("-----MENU-----");
            System.out.println("1.Luu tru");
            System.out.println("2.Xoa file");
            System.out.println("0.Thoat chuong trinh");
            System.out.println("Nhap lua chon cua ban: ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    
                    gv.LuuTru("D:\\giangvien.dat");
                    break;
                case 2:
                    SaoLuu("D:\\giangvien.dat", "D:\\giangvien_backup.dat");
                    XoaFile("D:\\giangvien.dat");
                    break;
                
                case 0:
                    System.out.println("Thoat chuong trinh thanh cong");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
