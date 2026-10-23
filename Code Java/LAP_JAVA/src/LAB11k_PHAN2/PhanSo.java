/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB11k_PHAN2;

/**
 *
 * @author DucPc
 */
public class PhanSo {
    private int tu;   // Tu so
    private int mau;  // Mau so
    
    // Constructor mac dinh
    public PhanSo(int n, int d) {
        if (d == 0) {
            throw new IllegalArgumentException("Mau so khong the bang 0");
        }
        this.tu = n;
        this.mau = d;
        toigian();
    }
    
    // Phuong thuc toi gian phan so
    private void toigian() {
        int gcd = gcd(tu, mau); // Tim uoc chung lon nhat
        tu /= gcd;
        mau /= gcd;
    }

    // Ham tinh uoc chung lon nhat
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Phuong thuc cong phan so
    public final PhanSo cong(final PhanSo a) {
        int newTu = this.tu * a.mau + this.mau * a.tu;
        int newMau = this.mau * a.mau;
        return new PhanSo(newTu, newMau);
    }

    // Phuong thuc tru phan so
    public final PhanSo tru(final PhanSo a) {
        int newTu = this.tu * a.mau - this.mau * a.tu;
        int newMau = this.mau * a.mau;
        return new PhanSo(newTu, newMau);
    }

    // Phuong thuc nhan phan so
    public final PhanSo nhan(final PhanSo a) {
        int newTu = this.tu * a.tu;
        int newMau = this.mau * a.mau;
        return new PhanSo(newTu, newMau);
    }

    // Phuong thuc chia phan so
    public final PhanSo chia(final PhanSo a) throws DevidedByZeroException {
        if (a.tu == 0) {
            throw new DevidedByZeroException("Attempted to divide by zero");
        }
        int newTu = this.tu * a.mau;
        int newMau = this.mau * a.tu;
        return new PhanSo(newTu, newMau);
    }

    // Phuong thuc chuyen phan so thanh chuoi
    public String toString() {
        return tu + "/" + mau;
    }

    // Phuong thuc main de thu nghiem
    public static void main(String[] args) {
        try {
            PhanSo ps1 = new PhanSo(1, 3);
            PhanSo ps2 = new PhanSo(5, 6);
            
            PhanSo psAdd = ps1.cong(ps2);
            PhanSo psSub = ps1.tru(ps2);
            PhanSo psMul = ps1.nhan(ps2);
            PhanSo psDiv = ps1.chia(ps2);
            
            System.out.println("Phan so 1: " + ps1);
            System.out.println("Phan so 2: " + ps2);
            System.out.println("Cong: " + psAdd);
            System.out.println("Tru: " + psSub);
            System.out.println("Nhan: " + psMul);
            System.out.println("Chia: " + psDiv);
        } catch (DevidedByZeroException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
