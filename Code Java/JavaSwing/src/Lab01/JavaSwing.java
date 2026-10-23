/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Lab01;

import java.awt.Frame;
import java.util.Locale;

/**
 *
 * @author DucPc
 */
public class JavaSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frame f1 = new Frame();
        f1.setSize(800,500);
        f1.setLocale(Locale.UK);
        f1.setTitle("xin chào");
        f1.setVisible(true);
        
        Frame f2 = new Frame();
        f2.setSize(800,500);
        f2.setLocale(Locale.UK);
        f2.setTitle("xin chào");
        f2.setAlwaysOnTop(true);
        f2.setVisible(true);
    }
    
}
