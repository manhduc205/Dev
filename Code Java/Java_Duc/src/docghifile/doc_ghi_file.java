/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docghifile;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author DucPc
 */
public class doc_ghi_file {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File f = new File("D:\\GhiFile.dat");
        FileOutputStream fos = new FileOutputStream(f);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeInt(10);
        dos.writeUTF("HI hi ha ha");
        dos.close();
        
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        System.out.println("Doc tu file: " + dis.readInt());
        System.out.println("Doc tu file: " + dis.readUTF());
        dis.close();
    }
}
