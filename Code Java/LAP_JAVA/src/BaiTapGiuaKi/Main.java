package BaiTapGiuaKi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Number n = null;
        Scanner sc = new Scanner(System.in);
        int min = 0, max = 0, value = 0;
        File f = new File("D:\\giuaki.dat");
            do {
                System.out.println("Nhap Value:");
                value = sc.nextInt();
                System.out.println("Nhap Min:");
                min = sc.nextInt();
                System.out.println("Nhap Max:");
                max = sc.nextInt();
                if (min >= value || value >= max) {
                    System.out.println("Dieu kien khong hop le (min < value < max) Vui long nhap lai!");
                }
            } while (min >= value || value >= max);
        while (true) {
            System.out.println("Vui long chon chuc nang: ");
            System.out.println("1: Khoi Tao");
            System.out.println("2: Luu tru");
            System.out.println("0: Thoat chuong trinh");
            int chon = sc.nextInt();
            switch (chon) {
                case 1: 
                    try {
                        n = new Number(value, min, max);
                        System.out.println("Khoi tao thanh cong");
                    } catch (Exception e) {
                        System.out.println("Co loi khi khoi tao" +e.getMessage());
                    }
                    break;
                case 2:
                    if (n == null) {
                        System.out.println("Ban can khoi tao truoc!");
                    } else if (n.ktraNT()) {
                        try (PrintWriter pw = new PrintWriter(new FileWriter(f))) {
                            pw.write("Min: " + n.getMin() + "\n");
                            pw.write("Value: " + n.getValue() + "\n");
                            pw.write("Max: " + n.getMax() + "\n");
                            System.out.println("Luu thong tin thanh cong!");
                        } catch (IOException e) {
                            System.out.println("Loi khi luu file: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Gia tri cua value khong phai so nguyen to! Khong the luu tru");
                    }
                    break;

                 case 0: 
                    System.out.println("Ket thuc chuong trinh!");
                    return;

                 default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
