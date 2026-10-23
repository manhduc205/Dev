package Cau9;

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
public class Book {
    private String id , authors , title , category;

    public Book() {
    }

    public Book(String id, String authors, String title, String category) {
        this.id = id;
        this.authors = authors;
        this.title = title;
        this.category = category;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID: ");
        id = sc.nextLine();
        System.out.println("Nhap Authors: ");
        authors = sc.nextLine();
        System.out.println("Nhap Title: ");
        title = sc.nextLine();
        System.out.println("Nhap Category: " );
        while(true){
            category = sc.nextLine();
            if(category.equals("tap chi") || category.equals("KHXH") || category.equals("KHTN") || category.equals("luan van")){
                break;
            }
            else{
                System.out.println("Category khong hop le, Vui long nhap lai(tap chi, KHXH, KHTN, luan van");
            }
        }
    }
    
    public void LuuFile(String tenfile){
        try(PrintWriter pw = new PrintWriter(new FileWriter(tenfile))) {
            pw.write("ID: " + id + "\n");
            pw.write("Authors: " + authors + "\n");
            pw.write( "Title" + title+ "\n");
            pw.write("Category: " + category + "\n");
        } catch (Exception e) {
            System.out.println("Co loi khi luu file");
        }
    }
    
    public static void SaoLuu(String tenfile1, String tenfile2){
        try (BufferedReader br = new BufferedReader(new FileReader(tenfile1));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tenfile2))){
            String line;
            while((line =br.readLine()) != null){
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Co loi xay ra khi sao luu file");
        }
    }
    public static void XoaFile(String tenfile){
        File f = new File(tenfile);
        if(f.exists()){
            f.delete();
            System.out.println("Xoa File thanh cong!");
        }
        else {
            System.out.println("Khong tim thay file");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book b = new Book();
        b.nhap();
        while(true){
            System.out.println("-----MENU-----");
            System.out.println("1.Them Sach");
            System.out.println("2.Xoa File");
            System.out.println("Lua chon cua ban: ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    b.LuuFile("D:\\books.dat");
                    break;
                case 2:
                    SaoLuu("D:\\books.dat", "D:\\books_backup.dat");
                    XoaFile("D:\\books.dat");
                    break;
                case 3:
                    System.out.println("Thoat chuong trinh thanh cong");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
        
    }
}

