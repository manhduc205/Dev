package Lab4;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.KeyEvent;

public class bai_2 extends JFrame {

    public bai_2() {
        initUI();
    }

    private void initUI() {
        setTitle("MenuSample Example");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        
        fileMenu.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("File Menu Changed");
            }
        });
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        bai_2 demo = new bai_2();
        demo.setVisible(true);
    }
}