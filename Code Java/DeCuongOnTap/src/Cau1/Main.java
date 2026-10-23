package Cau1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> listsv = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        File file = new File("D:\\sinhvien.dat");

        while (true) {
            System.out.println("1. Nhap thong tin sinh vien");
            System.out.println("2. Luu thong tin vao file");
            System.out.println("0. Ket thuc chuong trinh");
            System.out.print("Lua chon cua ban: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    nhapDanhSachSinhVien(listsv, sc);
                    break;
                case 2:
                    luuThongTin(file, listsv);
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void nhapDanhSachSinhVien(ArrayList<Student> listsv, Scanner sc) {
        System.out.print("Nhap so luong sinh vien: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1) + ":");
            Student student = new Student();
            student.nhap(sc);
            listsv.add(student);
        }

        System.out.println("Danh sach sinh vien vua nhap:");
        for (Student st : listsv) {
            st.in();
        }
    }

    private static void luuThongTin(File file, ArrayList<Student> listsv) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (Student st : listsv) {
                pw.println(st);
            }
            System.out.println("Luu thong tin thanh cong vao file: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Loi xay ra khi luu file: " + e.getMessage());
        }
    }
}
