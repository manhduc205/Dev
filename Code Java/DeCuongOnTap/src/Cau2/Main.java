package Cau2;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<NhanVien> nv = new ArrayList<>();
        File f = new File("D:\\nhanvien.dat");
        int n;
        while(true){
            System.out.println("Chon chuc nang:");
            System.out.println("1.Khoi tao doi tuong");
            System.out.println("2.Luu giu lieu");
            System.out.println("0.Thoat chuong trinh");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    
                    System.out.println("Nhap so luong nhan vien: ");
                    n = sc.nextInt();
                    sc.nextLine();
                    for(int i = 0 ;  i < n; i++){
                        NhanVien a = new NhanVien();
                        a.nhap();
                        nv.add(a);
                    }
                    System.out.println("Thong tin sinh vien: ");
                    for(int i = 0; i < nv.size() ; i++){
                        nv.get(i).in();
                    }
                    break;
                case 2:
                    if(nv == null){
                        System.out.println("Ban phai khoi tao doi tuong truoc");
                    }
                    else{
                        try (PrintWriter pw = new PrintWriter(new FileWriter(f))){
                            for(int i = 0; i < nv.size(); i++){
                                pw.write(nv.get(i).toString());
                            }
                            System.out.println("Luu thong tin thanh cong!");
                        } catch (Exception e) {
                            System.out.println("Co loi khi luu!");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh thanh cong");
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
    }
}
