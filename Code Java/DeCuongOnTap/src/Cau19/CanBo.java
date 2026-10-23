package Cau19;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

    public String getPhongban() {
        return phongban;
    }

    public Float getHesoluong() {
        return hesoluong;
    }

    public Float getLuongcoban() {
        return luongcoban;
    }

    public Float getThuong() {
        return thuong;
    }

    public Float getPhat() {
        return phat;
    }

    

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
        sc.nextLine();
        System.out.println("Nhap thuong: ");
        thuong = sc.nextFloat();
        sc.nextLine();
        System.out.println("Nhap phat: ");
        phat = sc.nextFloat();
        sc.nextLine();        
    }
    public double luongthuclinh(){
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
        System.out.printf("Luong thuc linh: %-15.2f\n", luongthuclinh());
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
                    try (BufferedReader br = new BufferedReader(new FileReader(f))){
                        String line;
                        while((line = br.readLine()) != null){
                            String[] data = line.split("\\*");
                            String hoten = data[0];
                            String ngaysinh = data[1];
                            String diachi = data[2];
                            String gioitinh = data[3];
                            String phongban = data[4];
                            float hesoluong = Float.parseFloat(data[5]);
                            float luongcoban = Float.parseFloat(data[6]);
                            float thuong = Float.parseFloat(data[7]);
                            float phat = Float.parseFloat(data[8]);
                            CanBo c = new CanBo(hoten, ngaysinh, diachi, gioitinh, phongban, hesoluong, luongcoban, thuong, phat);
                            cb.add(c);
                            
                        }
                        System.out.println("Doc file thanh cong");
                    } catch (Exception e) {
                        System.out.println("Co loi khi luu file!");
                    }
                    break;
                case 2:
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-30s | %-20s | %-20s | %-20s | %-20s | %-20s |"
                            , "Ho ten" , "Ngay sinh" , "Dia chi" ,"Gioi tinh" , "Phong ban" , "he so luong" , "luong co ban" , "Thuong" , "Phat" , "Luong thuc linh");
                    System.out.println("\n--------------------------------------------------------------------------------"
                            + "-------------------------------------------------------------------------------------------");
                    for(CanBo x : cb){
                        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-30s | %-20.2f | %-20.2f | %-20.2f | %-20.2f | %-20.2f |\n"
                            , x.getHoten() , x.getNgaysinh() ,x.getDiachi() ,x.getGioitinh() , x.getPhongban() , x.getHesoluong() , x.getLuongcoban() , x.getThuong() , x.getPhat() ,(double)x.luongthuclinh());
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
