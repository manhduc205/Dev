/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docghifile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class NhanVien extends Person implements Serializable {
    private String phongban ;
    private Double luongcoban,thamnien, hesoluong;

    public NhanVien(String hoten , String ngaysinh , String diachi , String gioitinh, String phongban, Double luongcoban, Double thamnien, Double hesoluong) {
        super(hoten, ngaysinh, diachi, gioitinh);
        this.phongban = phongban;
        this.luongcoban = luongcoban;
        this.thamnien = thamnien;
        this.hesoluong = hesoluong;
        
    }
    public Double Luongthuclinh(){
        return luongcoban * hesoluong * (1 + thamnien / 100);
    }
    @Override
    public void in(){
        super.in();
        System.out.println("Phong ban: " + phongban);
        System.out.println("He So luong: "+ hesoluong);
        System.out.println("Tham Nien: " + thamnien);
        System.out.println("Luong co ban: " + luongcoban);
        System.out.printf("Luong thuc linh : %.2f \n" , Luongthuclinh());
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        File f = new File("D:\\nv.dat");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream dos = new ObjectOutputStream(fos) ;
        NhanVien nv = new NhanVien("Nguyen Van A", "01/01/1990", "Ha Noi", "Nam", "IT", 5000.0, 5.0, 2.0);
        dos.writeObject(nv);
        
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        NhanVien nvdoc = (NhanVien) ois.readObject();
        nvdoc.in();
    }
}

