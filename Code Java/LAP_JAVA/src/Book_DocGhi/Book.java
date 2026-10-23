/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Book_DocGhi;

import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class Book {
    private String id ,authors , title , category ;

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }
    public String getId(){
        return id;
    }
    public void nhap(){
        System.out.println("Nhap ID: ");
        Scanner sc = new Scanner(System.in);
        id = sc.nextLine();
        System.out.println("Nhap Authors: ");
        authors = sc.nextLine();
        System.out.println("Nhap Title: ");
        title = sc.nextLine();
    }
    
}
