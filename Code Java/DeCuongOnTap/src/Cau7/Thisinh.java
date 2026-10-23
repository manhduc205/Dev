package Cau7;

import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class Thisinh {
    private String hoten, ngaysinh, diachi;

    public Thisinh() {
    }

    public Thisinh(String hoten, String ngaysinh, String diachi) {
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
    }
    public void nhap(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        hoten = sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        ngaysinh = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diachi = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Thisinh{" + "hoten=" + hoten + ", ngaysinh=" + ngaysinh + ", diachi=" + diachi + '}';
    }
    public void in(){
        System.out.println("HO ten: " + hoten);
        System.out.println("Ngay sinh: " + ngaysinh);
        System.out.println("Dia chi: " + diachi);
    }
}
