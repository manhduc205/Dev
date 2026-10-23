/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DocGhiFilea;

/**
 *
 * @author DucPc
 */
public class Person {
    private String hoten , ngaysinh , diachi , gioitinh;

    public Person(String hoten , String ngaysinh , String diachi , String gioitinh) {
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }
    
    public void in(){
        System.out.println("Ho va ten: " + hoten);
        System.out.println("Ngay sinh: " + ngaysinh);
        System.out.println("Dia chi: " + diachi);
        System.out.println("Gioi tinh: " + gioitinh);
        
    }
    
}
