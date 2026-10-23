/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class myFile implements Serializable{
    //luu doi tuong
    public static void luuDoiTuong(Object obj, String fileName){
        try{
        FileOutputStream fOut=new FileOutputStream(fileName);
        ObjectOutputStream out=new ObjectOutputStream(fOut);
        out.writeObject(obj);
        out.close();
        }
        catch(Exception ex)
        {
        ex.printStackTrace();
        }
    }
    //doc doi tuong
    public static Object docDoiTuong(String fileName){
        try{
            FileInputStream fIn=new FileInputStream(fileName);
            ObjectInputStream in=new ObjectInputStream(fIn);
            Object o=in.readObject();
            in.close();
            return o;
        }
        catch(Exception ex)
        {
        ex.printStackTrace();
        }
        return null;
    }

}
