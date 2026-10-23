package Cau8;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class Number {
    private int value, min , max;

    public Number() {
    }

    public Number(int value, int min, int max) {
        if(min >= value || value >= max){
            throw new IllegalArgumentException("Dieu kien min < value < max khong thoa man");
        }
        this.value = value;
        this.min = min;
        this.max = max;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        do {            
            System.out.println("Nhap Value: ");
            value = sc.nextInt();
            System.out.println("Nhap Min: ");
            min = sc.nextInt();
            System.out.println("Nhap Max: ");
            max = sc.nextInt();
            if(min >= value || value >= max){
                System.out.println("Vui long nhap lai (min < value < max): ");
            }
        } while (min >= value || value >= max);
    }

    @Override
    public String toString() {
        return "" + "Value: " + value + "\nMin: " + min + "\nMax: " + max ;
    }
    
    public boolean KiemTra(){
        if(value < 2){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(value); i++){
            if(value % 2 == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File f = new File("D:\\number.dat");
        Number n = null;
        int chon=0;
        while (true) {            
            System.out.println("-----MENU-----");
            System.out.println("1.Tao moi Number");
            System.out.println("2.Luu tru");
            System.out.println("0.Thoat menu");
            System.out.println("Lua chon cua ban: ");
            
            try {
                chon = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Vui long nhap so nguyen!");
            }
            
            switch (chon) {
                case 1:
                    n = new Number();
                    n.nhap();
                    break;
                case 2:
                    if(n == null){
                        System.out.println("Ban phai khoi tao c");
                    }
                    try (PrintWriter pw = new PrintWriter(new FileWriter(f))){
                        if(n.KiemTra()){
                            pw.write(n.toString());
                            System.out.println("Luu du lieu thanh cong");
                        }
                        else{
                            System.out.println("Value khong phai la so nguyen to");
                            n.nhap();
                        }
                        
                    } catch (Exception e) {
                        System.out.println("Loi khi luu du lieu");
                    }
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh thanh cong");
                    return;
                default:
                    throw new AssertionError();
            }
            
        }
    }
}
