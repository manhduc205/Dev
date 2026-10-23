/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab02;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

/**
 *
 * @author DucPc
 */
public class MenuDemo extends JFrame{
    JMenuBar menubar;
    public MenuDemo(){
        initFrame();
        initMenuBar();
        initToolBar();
        setVisible(true);
    }
    public static void main(String[] args) {
        MenuDemo demo = new MenuDemo();
    }
    private void initFrame(){
        this.setLayout(new BorderLayout());
        this.setSize(600,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Demo JFrame");
        
    }
    private void initMenuBar(){
        menubar = new JMenuBar();
        initMenuFile();
        this.add(menubar, BorderLayout.NORTH);
        
    }
    private void initMenuFile(){
        JMenu menuFile = new JMenu("File");
        ImageIcon icon = new ImageIcon("C:/Users/DucPc/Desktop/hai.jpg");
        icon = resizeImageIcon(icon, 16, 16);
        JMenuItem newProject = new JMenuItem("New Project",icon); 
        newProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK| InputEvent.SHIFT_DOWN_MASK));
        menuFile.add(newProject);
        //-------------
        ImageIcon icon2 = new ImageIcon("C:\\Users\\DucPc\\Desktop\\icon.png");
        icon2 = resizeImageIcon(icon, 16, 16);
        JMenuItem file1 = new JMenuItem("2 Project",icon2); 
        file1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK| InputEvent.SHIFT_DOWN_MASK));
        menuFile.add(newProject);
        menuFile.addSeparator();
        //-----
        JMenu menuOpenFile = new JMenu("open recent file");
        menuOpenFile.add(file1);
        
        menuFile.add(menuOpenFile);
        
        menubar.add(menuFile);
    }
    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height){
        Image image = icon.getImage();
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    
    private void initToolBar(){
    JToolBar toolBar = new JToolBar("Tool Bar");
    toolBar.setFloatable(false); 
    ImageIcon newIcon = new ImageIcon("C:/Users/DucPc/Desktop/hai.jpg");
    newIcon = resizeImageIcon(newIcon, 20, 20);
    JButton btnNewFile = new JButton(newIcon);
    btnNewFile.setToolTipText("Create New File (Ctrl + Shift + N)");
    toolBar.add(btnNewFile);
    toolBar.addSeparator();
    this.add(toolBar, BorderLayout.SOUTH);
    }

}
