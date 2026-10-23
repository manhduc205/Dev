package Cau16;

import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class Person {
    private String hoten, ngaysinh, diachi, gioitinh;

    public Person() {
    }

    public Person(String hoten, String ngaysinh, String diachi, String gioitinh) {
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString() {
        return "" + "Ho ten:" + hoten + ", Ngay sinh:" + ngaysinh + ", Dia chi:" + diachi + ", Gioi tinh: " + gioitinh + '}';
    }
    
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        hoten = sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        ngaysinh = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diachi = sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        gioitinh = sc.nextLine();
    }
    public void in() {
        System.out.println("Ho ten: " + hoten);
        System.out.println("Ngay sinh: " + ngaysinh);
        System.out.println("Dia chi: " + diachi);
        System.out.println("Gioi tinh: " + gioitinh);
    }
}
