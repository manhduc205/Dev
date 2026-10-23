package Cau1;

import java.util.Scanner;

public class Person {
    protected String hoten, ngaysinh, diachi, gioitinh;

    public void nhap(Scanner sc) {
        System.out.print("Nhap ho ten: ");
        hoten = sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        ngaysinh = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diachi = sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        gioitinh = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Ho ten: " + hoten + "\nNgay sinh: " + ngaysinh + "\nDia chi: " + diachi + "\nGioi tinh: " + gioitinh;
    }

    public void in() {
        System.out.println(toString());
    }
}
