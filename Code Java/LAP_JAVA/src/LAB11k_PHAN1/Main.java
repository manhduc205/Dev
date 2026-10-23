/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB11k_PHAN1;

/**
 *
 * @author DucPc
 */
public class Main {
    public static void main(String[] args) {
        // Tao stack voi kich thuoc co dinh la 5
        Stack stack = new Stack(5);

        try {
            // Day cac phan tu vao stack
            stack.put("San pham 1");
            stack.put("San pham 2");
            stack.put("San pham 3");

            // Lay va hien thi phan tu tai vi tri chi dinh
            System.out.println("Lay phan tu tai index 0: " + stack.get(0));
            System.out.println("Lay phan tu tai index 1: " + stack.get(1));
            System.out.println("Lay phan tu tai index 2: " + stack.get(2));

            // Co gang day phan tu null (se gay ngoai le)
            stack.put(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Ngoai le: " + e.getMessage());
        }

        try {
            // Day them phan tu den khi day
            stack.put("San pham 4");
            stack.put("San pham 5");

            // Co gang day phan tu khi stack da day (se gay ngoai le)
            stack.put("San pham 6");
        } catch (IllegalStateException e) {
            System.out.println("Ngoai le: " + e.getMessage());
        }

        try {
            // Lay cac phan tu ra khoi stack
            while (!stack.empty()) {
                System.out.println("Lay phan tu ra: " + stack.pop());
            }

            // Co gang lay phan tu khi stack rong (se gay ngoai le)
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Ngoai le: " + e.getMessage());
        }
    }
}

