package Cau7;

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
        File f = new File("D:\\thisinh.txt");
        ArrayList<ThisinhKhoiA> khoiA = new ArrayList<>();
        ArrayList<ThisinhKhoiC> khoiC = new ArrayList<>();
        int n;
        
        System.out.println("Nhap so luong thi sinh: ");
        n = sc.nextInt();
        for(int i = 0 ;i < n; i++){
            System.out.println("-----MENU-----");
            System.out.println("1.Nhap thong tin cho hoc sinh khoi A");
            System.out.println("2.Nhap thong tin cho hoc sinh khoi C");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    ThisinhKhoiA ka = new ThisinhKhoiA();
                    ka.nhap();
                    khoiA.add(ka);
                    break;
                case 2:
                    ThisinhKhoiC kc = new ThisinhKhoiC();
                    kc.nhap();
                    khoiC.add(kc);
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
        System.out.println("Danh sach thi sinh trung tuyen (diem > 20): ");
        for(int i = 0 ; i < khoiA.size() ;i++){
            if(khoiA.get(i).tongdiema() > 20){
                khoiA.get(i).in();
               
                System.out.println("Tong diem: " +  khoiA.get(i).tongdiema());
            }
        }
        for(int i = 0; i < khoiC.size(); i++){
            if(khoiC.get(i).tongdiemc() > 20){
                khoiC.get(i).in();
                System.out.println("Tong diem: " + khoiC.get(i).tongdiemc());
            }
            
        }
        for(int i = 0; i < khoiA.size(); i++){
            try (PrintWriter pw = new PrintWriter(new FileWriter(f, true))){
                pw.println(khoiA.get(i).toString());
               
            } catch (Exception e) {
                System.out.println("Co loi khi ghi file!");
            }
        }
        for(int i = 0; i < khoiC.size(); i++){
            try (PrintWriter pw = new PrintWriter(new FileWriter(f, true))){
                pw.println(khoiC.get(i).toString());
            } catch (Exception e) {
                System.out.println("Co loi khi ghi file!");
            }
        }
    }
}
