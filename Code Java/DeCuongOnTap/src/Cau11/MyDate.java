/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau11;

import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class MyDate {
    private int day, month, year;

    public MyDate() {
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Day: ");
        day = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap Month: ");
        month = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap Year: ");
        year = sc.nextInt();
        sc.nextLine();
    }
    public void in(){
        System.out.println("Day: " + day);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
    }
}
