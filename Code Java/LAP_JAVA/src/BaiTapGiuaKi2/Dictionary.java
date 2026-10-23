package BaiTapGiuaKi2;

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
        System.out.println("Nhap So Luong tu: ");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++){
            System.out.println("Nhap ID: ");
            String id = sc.nextLine();
            System.out.println("Nhap EN: ");
            String en = sc.nextLine();
            System.out.println("Nhap VN: ");
            String vn = sc.nextLine() ;
            Word w = new Word(id, en, vn);
            tudien.add(w);
        }
    }
    
    public boolean binarySearchEN(String tucantim) {
        Collections.sort(tudien, Comparator.comparing(Word::getEn));
        int l = 0, r = tudien.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            Word s = tudien.get(m);
            if (s.getEn().equalsIgnoreCase(tucantim)) {
                System.out.println("Tim thay tu:");
                System.out.println("Tieng Anh: " + s.getEn());
                System.out.println("Nghia tieng Viet: " + s.getVn());
                return true;
            } else if (s.getEn().compareToIgnoreCase(tucantim) < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

    
    public boolean binarySearchVN(String tucantim) {
        Collections.sort(tudien, Comparator.comparing(Word::getVn));
        int l = 0, r = tudien.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            Word s = tudien.get(m);
            if (s.getVn().equalsIgnoreCase(tucantim)) {
                System.out.println("Tim thay tu:");
                System.out.println("Tieng Viet: " + s.getVn());
                System.out.println("Nghia tieng Anh: " + s.getEn());
                return true;
            } else if (s.getVn().compareToIgnoreCase(tucantim) < 0) { // khi s.getVn nho hon tucantim
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner sc = new Scanner(System.in);
        dictionary.khoitaotudien();
        while(true){
            System.out.println("Vui long nhap lua chon:");
            System.out.println("1.Nhap Tu Dien");
            System.out.println("2.Tim kiem");
            System.out.println("3.Thoat chuong trinh");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    dictionary.nhaptudien();
                    
                    break;
                case 2:
                    System.out.println("Nhap tu can tim (Tieng Anh): ");
                    String tucantim = sc.nextLine().trim();
                    if (!dictionary.binarySearchEN(tucantim) && !dictionary.binarySearchVN(tucantim)) {
                        System.out.println("Khong tim thay tu nay trong tu dien.");
                        System.out.print("Ban co muon them tu nay vao tu dien khong (y/n): ");
                        String choice = sc.nextLine();
                        if (choice.equalsIgnoreCase("y")) {
                            System.out.print("Nhap ID: ");
                            String id = sc.nextLine();
                            System.out.print("Nhap tu Tieng Viet: ");
                            String vn = sc.nextLine();
                            Word newWord = new Word(id, tucantim, vn);
                            dictionary.tudien.add(newWord);
                            System.out.println("Da them moi vao tu dien.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thoat chuong trinh thanh cong!");
                    return;             
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
        
    }
}
