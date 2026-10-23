/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab01;

import javax.swing.*;
import java.util.Random;

public class Bai1 {
    private int min;
    private int max;

    public Bai1(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean isValidRange() {
        return max >= min;
    }

    public int generate() {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        try {
            int min = Integer.parseInt(JOptionPane.showInputDialog("Nhập số thứ nhất:"));
            int max = Integer.parseInt(JOptionPane.showInputDialog("Nhập số thứ hai:"));

            Bai1 generator = new Bai1(min, max);

            if (!generator.isValidRange()) {
                JOptionPane.showMessageDialog(null,
                        "Lỗi: Số thứ hai phải lớn hơn hoặc bằng số thứ nhất!",
                        "Lỗi nhập liệu",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int randomNumber = generator.generate();

            JOptionPane.showMessageDialog(null,
                    "Số ngẫu nhiên trong khoảng [" + min + ", " + max + "]: " + randomNumber,
                    "Phát sinh số ngẫu nhiên",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Vui lòng nhập vào hai số nguyên hợp lệ!",
                    "Lỗi định dạng",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
