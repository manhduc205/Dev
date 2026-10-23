/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau6_lamlai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class Dictionary {
    ArrayList<Word> tudien = new ArrayList<>();
    public void khoitaotudien() {
        tudien.add(new Word("1", "apple", "quả táo"));
        tudien.add(new Word("2", "banana", "quả chuối"));
        tudien.add(new Word("3", "cat", "con mèo"));
        tudien.add(new Word("4", "dog", "con chó"));
        tudien.add(new Word("5", "elephant", "con voi"));
        tudien.add(new Word("6", "fish", "con cá"));
        tudien.add(new Word("7", "grape", "quả nho"));
        tudien.add(new Word("8", "house", "ngôi nhà"));
        tudien.add(new Word("9", "ice", "băng"));
        tudien.add(new Word("10", "jungle", "rừng rậm"));
    }  
    public void nhaptudien(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so tu: ");
        int n = sc.nextInt();
        for(int i = 0 ;i < n; i++){
            System.out.println("Nhap ID: ");
            String id = sc.nextLine();
            System.out.println("Nhap EN: ");
            String en = sc.nextLine();
            System.out.println("Nhap VN");
            String vn = sc.nextLine();
            Word w = new Word(id, en, vn);
            tudien.add(w);
        }
    }
    public boolean TimKiemEN(String tucantim){
        Collections.sort(tudien, Comparator.comparing(Word::getEn));
        int l = 0; int r = tudien.size() -1;
        while(l <= r){
            int m = (l + r) /2;
            Word s = tudien.get(m);
            if(s.getEn().equalsIgnoreCase(tucantim)){
                System.out.println("Da tim thay tu: " + tucantim);
                System.out.println("Nghia tieng Viet: " + s.getVn());
                return true;
            }
            else if (s.getEn().compareToIgnoreCase(tucantim) < 0){
                l = m + 1;
            }
            else{
                r = m -1;
            }
            
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();
        dictionary.khoitaotudien();
        while(true){
            System.out.println("-----MENU-----");
            System.out.println("1.Khoi tao tu dien");
            System.out.println("2.Tim kiem tu dien");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    
                    dictionary.nhaptudien();
                    break;
                case 2:
                    System.out.println("Nhap tu can tim: ");
                    String tucantim = sc.nextLine();
                    if(dictionary.TimKiemEN(tucantim) == false){
                        System.out.println("Khong tim thay tu can tim ");
                        System.out.println("Ban co muon them vao tu dien khong (y/n): ");
                        String choice = sc.nextLine();
                        if(choice.equals("y")){
                            System.out.println("Nhap ID: ");
                            String id = sc.nextLine();
                            System.out.println("Nhap Nghia tieng Viet: ");
                            String vn = sc.nextLine();
                            Word newword = new Word(id, tucantim, vn);
                            dictionary.tudien.add(newword);
                            System.out.println("Them moi thanh cong!");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Thoat menu thanh cong");
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
