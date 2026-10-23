/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DocGhiFilea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Filer;

/**
 *
 * @author DucPc
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<NhanVien> nv = new ArrayList<>();
        File myFile = new File("D:\\nhanvien.dat");
        FileReader fr = new FileReader(myFile);
        BufferedReader br = new BufferedReader(fr);
        String line ;
        while((line = br.readLine()) != null){
            String[] data = line.split("\\$");
            String name = data[0];
            String ngaysinh = data[1];
            String diachi = data[2];
            String gt = data[3];
            String phongban = data[4];
            Double luongcoban = Double.parseDouble(data[5]);
            Double thamnien = Double.parseDouble(data[6]);
            Double hesl = Double.parseDouble(data[7]);
            NhanVien nhanvien = new NhanVien(name, ngaysinh, diachi, gt, phongban, luongcoban, thamnien, hesl);
            nv.add(nhanvien);
            
            
        }
        
        for(NhanVien nhanvien : nv){
            nhanvien.in();
        }
        
    }
}
