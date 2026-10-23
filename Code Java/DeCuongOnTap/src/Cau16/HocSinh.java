package Cau16;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.print.event.PrintEvent;

/**
 *
 * @author DucPc
 */
public class HocSinh extends Person {
    private String mahs , lop;
    private float diemtongket;

    public HocSinh() {
    }

    public HocSinh(String hoten, String ngaysinh, String diachi, String gioitinh,String mahs, String lop, float diemtongket) {
        super(hoten, ngaysinh, diachi, gioitinh);
        this.mahs = mahs;
        this.lop = lop;
        this.diemtongket = diemtongket;
    }
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma hoc sinh: ");
        mahs = sc.nextLine();
        System.out.println("Nhap lop: ");
        lop = sc.nextLine();
        System.out.println("Nhap diem tong ket: ");
        diemtongket = sc.nextFloat();
        sc.nextLine();
    }
    @Override
    public void in(){
        super.in();
        System.out.println("Ma hoc sinh: " + mahs);
        System.out.println("Lop: " + lop );
        System.out.println("Diem tong ket: " + diemtongket);
    }

    @Override
    public String toString() {
        return super.toString() + " " + "ma hoc sinh: " + mahs + ", Lop:" + lop + ", Diem tong ket:" + diemtongket ;
    }
    
    public static void main(String[] args) {
        ArrayList<HocSinh> hs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        File f = new File("D:\\hocsinh.dat");
        while(true){
            System.out.println("-----MENU-----");
            System.out.println("1.Them hoc sinh");
            System.out.println("2.Luu du lieu");
            System.out.println("0.Thoat menu");
            System.out.println("Lua chon cua ban: ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    System.out.println("Nhap so luong hoc sinh: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for(int i = 0; i< n ;i++){
                        HocSinh h = new HocSinh();
                        h.nhap();
                        hs.add(h);
                    }
                    for(HocSinh x: hs){
                        x.in();
                    }
                    break;
                case 2:
                    if(hs.isEmpty()){
                        System.out.println("Ban phai them hoc sinh truoc");
                    }
                    try (PrintWriter pw = new PrintWriter(new FileWriter(f))){
                        for(int i =0; i< hs.size(); i++){
                            pw.write(hs.get(i).toString());
                        }
                    } catch (Exception e) {
                        System.out.println("Co loi khi luu file");
                    }
                    break;
                case 0:
                    System.out.println("Thoat menu thanh cong!");
                    return;
                default:
                    System.out.println("Vui long nhap lua chon hop le");
            }
        }
    }
}
