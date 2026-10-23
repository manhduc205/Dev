package Cau1;

import java.util.Scanner;

public class Student extends Person {
    protected String masv, email;
    protected float diemtongket;

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap ma sinh vien: ");
        masv = sc.nextLine();
        System.out.print("Nhap email: ");
        email = sc.nextLine();
        System.out.print("Nhap diem tong ket: ");
        diemtongket = sc.nextFloat();
        sc.nextLine();
    }

    @Override
    public String toString() {
        return super.toString() + "\nMa SV: " + masv + "\nEmail: " + email + "\nDiem tong ket: " + diemtongket;
    }

    @Override
    public void in() {
        super.in();
        System.out.println("Ma SV: " + masv);
        System.out.println("Email: " + email);
        System.out.println("Diem tong ket: " + diemtongket);
    }
}
