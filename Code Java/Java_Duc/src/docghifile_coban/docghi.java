/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docghifile_coban;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class docghi {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File f = new File("D:\\test.dat");
        FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(fw);
        pw.print("In vao file");
        Scanner sc = new Scanner(System.in);
        pw.println(sc.nextLine());
        pw.close();
        // đoc file
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String s = "";
        while((s= br.readLine()) != null){
            System.out.println("Doc tu file: " + s);
        }
        br.close();
        
        
        
        
    }
}
