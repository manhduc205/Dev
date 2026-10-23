/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai11;

/**
 *
 * @author DucPc
 */

public class LopHoc {
    private String maLop;
    private String tenLop;

    public LopHoc() {}

    public LopHoc(String maLop, String tenLop) {
        this.maLop = maLop;
        this.tenLop = tenLop;
    }

    // Getters and Setters
    public String getMaLop() { return maLop; }
    public void setMaLop(String maLop) { this.maLop = maLop; }

    public String getTenLop() { return tenLop; }
    public void setTenLop(String tenLop) { this.tenLop = tenLop; }

    // Quan trọng: Override toString để hiển thị tên lớp trên JTree
    @Override
    public String toString() {
        return this.maLop + " - " + this.tenLop;
    }
}
