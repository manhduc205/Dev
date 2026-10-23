package Cau18;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class CanBo extends Person {
    private String phongban;
    private Float hesoluong, luongcoban, thuong, phat;

    public CanBo() {
    }

    public CanBo(String hoten, String ngaysinh, String diachi, String gioitinh ,String phongban, Float hesoluong, Float luongcoban, Float thuong, Float phat) {
        super(hoten, ngaysinh, diachi, gioitinh);
        this.phongban = phongban;
        this.hesoluong = hesoluong;
        this.luongcoban = luongcoban;
        this.thuong = thuong;
        this.phat = phat;
    }
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap phong ban: ");
        phongban = sc.nextLine();
        while(true){
            if(phongban.equalsIgnoreCase("Dao tao") || phongban.equalsIgnoreCase("To chuc can bo") || phongban.equalsIgnoreCase("Van phong khoa CNTT")){
                break;
            }
            else{
                System.out.println("Vui long nhap lai phong ban: ");
                phongban = sc.nextLine();
            }
        }
        System.out.println("Nhap he so luong: ");
        hesoluong = sc.nextFloat();
        sc.nextLine();
        System.out.println("Nhap luong co ban: ");
        luongcoban = sc.nextFloat();
        System.out.println("Nhap thuong: ");
        thuong = sc.nextFloat();
        System.out.println("Nhap phat: ");
        phat = sc.nextFloat();
        
    }
    public float luongthuclinh(){
        return luongcoban*hesoluong + thuong - phat;
    }
    @Override
    public void in(){
        super.in();
        System.out.println("Phong ban: " + phongban);
        System.out.println("He so luong: " + hesoluong);
        System.out.println("Luong co ban: " + luongcoban);
        System.out.println("Thuong: " + thuong);
        System.out.println("Phat: " + phat);
        System.out.println("Luong thuc linh: " + luongthuclinh());
    }

    @Override
    public String toString() {
        return super.toString() + " " + "phongban=" + phongban + ", hesoluong=" + hesoluong + ", luongcoban=" + luongcoban + ", thuong=" + thuong + ", phat=" + phat + "Luong thuc linh: " + luongthuclinh() ;
    }
    public static void main(String[] args) {
        ArrayList<CanBo> cb = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        File f = new File("D:\\canbo.dat");
        while(true){
            System.out.println("-----MENU-----");
            System.out.println("1.Them can bo");
            System.out.println("2.Luu du lieu");
            System.out.println("0.Thoat menu");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    System.out.println("Nhap so luong can bo: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for(int i = 0; i <n; i++){
                        CanBo c = new CanBo();
                        c.nhap();
                        cb.add(c);
                    }
                    for (CanBo x : cb){
                        x.in();
                    }
                    break;
                case 2:
                    if(cb.isEmpty()){
                        System.out.println("Vui long them can bo truoc");
                    }
                    try (PrintWriter pw = new PrintWriter(new FileWriter(f))){
                        for(int i = 0; i < cb.size(); i++){
                            pw.write(cb.get(i).toString());
                        }
                        System.out.println("Luu file thanh cong!");
                    } catch (Exception e) {
                        System.out.println("Co loi khi luu file");
                    }
                    break;
                case 0:
                    System.out.println("Thoat menu thanh cong!");
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
