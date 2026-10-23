
package docghifile;

import java.io.Serializable;

/**
 *
 * @author DucPc
 */
public class Person implements Serializable{
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
