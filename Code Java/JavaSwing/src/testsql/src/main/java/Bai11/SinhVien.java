/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai11;

/**
 *
 * @author DucPc
 */


public class SinhVien {
    private String maSV;
    private String hoTen;
    private int tuoi;
    private String maLop;

    public SinhVien() {}

    public SinhVien(String maSV, String hoTen, int tuoi, String maLop) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.maLop = maLop;
    }

    // Getters Setters
    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public int getTuoi() { return tuoi; }
    public void setTuoi(int tuoi) { this.tuoi = tuoi; }

    public String getMaLop() { return maLop; }
    public void setMaLop(String maLop) { this.maLop = maLop; }

    @Override
    public String toString() {
        return hoTen; // Hiển thị tên trên JList
    }
}
