/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

/**
 *
 * @author DucPc
 */

import javax.swing.*;
import java.awt.*;
public class MenuLookDemo extends JFrame {

    public MenuLookDemo() {
        initUI();
    }

    public static void main(String[] args) {
        MenuLookDemo demo = new MenuLookDemo();
        demo.setVisible(true);
    }

    private void initUI() {
        setTitle("MenuLookDemo");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();

        JMenu menu1 = new JMenu("A Menu");

        JMenuItem textOnly = new JMenuItem("A text-only menu item");
        textOnly.setAccelerator(KeyStroke.getKeyStroke("alt 1"));
        menu1.add(textOnly);

        ImageIcon star = new ImageIcon("C:/Users/DucPc/Desktop/traidat.jpg"); 
        star = resizeImageIcon(star,20,20);
              
        JMenuItem textIcon = new JMenuItem("Both text and icon", star);
        menu1.add(textIcon);
        menu1.addSeparator();
        // ---- 
        JRadioButtonMenuItem rb1 = new JRadioButtonMenuItem("A radio button menu item");
        JRadioButtonMenuItem rb2 = new JRadioButtonMenuItem("Another one");
        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        menu1.add(rb1);
        menu1.add(rb2);

        menu1.addSeparator();
        // --
        JCheckBoxMenuItem cb1 = new JCheckBoxMenuItem("A check box menu item");
        JCheckBoxMenuItem cb2 = new JCheckBoxMenuItem("Another one");
        menu1.add(cb1);
        menu1.add(cb2);
        menu1.addSeparator();

        // ---
        JMenu submenu = new JMenu("A submenu");
        JMenuItem subItem1 = new JMenuItem("An item in the submenu");
        JMenuItem subItem2 = new JMenuItem("Another item");
        submenu.add(subItem1);
        submenu.add(subItem2);
        menu1.add(submenu);
        JMenu menu2 = new JMenu("Another Menu");

        menuBar.add(menu1);
        menuBar.add(menu2);
        setJMenuBar(menuBar);
    }
    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height){
        Image image = icon.getImage();
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}

