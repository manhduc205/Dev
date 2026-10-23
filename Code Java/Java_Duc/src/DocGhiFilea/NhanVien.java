/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DocGhiFilea;

/**
 *
 * @author DucPc
 */
public class NhanVien extends Person {
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
}
