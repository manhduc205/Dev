
package Cau6;

import java.util.ArrayList;
import java.util.Collection;
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
        System.out.println("Nhap so luong tu: ");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++){
            Word w = new Word();
            w.nhap();
            tudien.add(w);
        }
    }
    public boolean TimKiem(String tucantim){
        Collections.sort(tudien, Comparator.comparing(Word::getVn));
        int l = 0; int r = tudien.size() - 1;
        while(l <= r){
            int m = (l + r) /2;
            Word s = tudien.get(m);
            if(s.getVn().equalsIgnoreCase(tucantim)){
                System.out.println("Da tim thay tu: " + tucantim);
                System.out.println("Nghia tieng anh: " + s.getEn());
                return true;
            }
            else if (s.getVn().compareToIgnoreCase(tucantim) < 0){
                l = m + 1;
            }
            else{
                r = m - 1;
            }
            
        }
        return false;
    }
    public boolean TimKiemEN(String tucantim){
        Collections.sort(tudien, Comparator.comparing(Word::getEn));
        int l = 0; int r = tudien.size() - 1;
        while(l <= r){
            int m = (l + r)/2;
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
                r = m - 1;
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
            System.out.println("1.Nhap tu dien");
            System.out.println("2.Tim kiem tu dien");
            System.out.println("0.Thoat menu");
            System.out.println("Lua chon cua ban: ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    dictionary.nhaptudien();
                    break;
                case 2:
                    String tucantim;
                    System.out.println("Nhap tu can tim: ");
                    tucantim = sc.nextLine();
                    if(dictionary.TimKiem(tucantim)!= true && dictionary.TimKiemEN(tucantim) != true ){
                        System.out.println("Khong tim thay tu can tim!");
                        System.out.println("Ban co muon them vao tu dien?(y/n)");
                        String choice = sc.nextLine();
                        if(choice.equalsIgnoreCase("y")){
                            System.out.println("Nhap Id: ");
                            String id = sc.nextLine();
                            System.out.println("Nhap nghia tieng anh: ");
                            String en = sc.nextLine();
                            System.out.println("Nhap nghia tieng viet: ");
                            String vn = sc.nextLine();
                            Word wordadd = new Word(id, en, vn);
                            dictionary.tudien.add(wordadd);
                            System.out.println("Da them moi vao tu dien.");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Thoat menu thanh cong!");
                    return;
                default:
                    System.out.println("Vui long nhap lua chon hop le");
            }
        }
    }
}
