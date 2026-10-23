/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau6;

import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class Word {
    private String id , en , vn ;

    public String getId() {
        return id;
    }

    public String getEn() {
        return en;
    }

    public String getVn() {
        return vn;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }
    public Word(){
        
    }
    public Word(String id , String en , String vn){
        this.id = id;
        this.en = en;
        this.vn = vn;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID: ");
        id= sc.nextLine();
        System.out.println("Nhap EN: ");
        en = sc.nextLine();
        System.out.println("Nhap VN: ");
        vn = sc.nextLine();
    }
    public void in(){
        System.out.println("ID: " + id);
        System.out.println("EN: " + en);
        System.out.println("VN: " + vn);
    }
    @Override
    public String toString() {
        return "ID: " + id + ", English: " + en + ", Vietnamese: " + vn;
    }
    
}
