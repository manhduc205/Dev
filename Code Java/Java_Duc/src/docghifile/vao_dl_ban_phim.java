/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docghifile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author DucPc
 */
public class vao_dl_ban_phim {
    public static void main(String[] args) throws IOException {
        
        File myFile = new File("D:\\tt23.txt");
        FileWriter fw = new FileWriter(myFile);
        PrintWriter pw = new PrintWriter(fw);
        pw.println("HI HI HA HA");
        pw.println("HO HO");
        pw.close();
        FileReader fr = new FileReader(myFile);
        BufferedReader br = new BufferedReader(fr);
        String s = "";
        while((s = br.readLine()) != null){
            System.out.println("Doc tu file: " + s);
        }
        br.close();
        
    }
}
