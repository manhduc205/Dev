/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

/**
 *
 * @author DucPc
 */
public class Main {
    public static void main(String[] args) {
        int a, b, c;
        a = 5;
        b = 10; 
        c = 15;
        My_Stack st = new My_Stack();
        st.push(a);
        st.push(b);
        st.push(c);
        st.in();
        st.pop();
        System.out.println("Sau khi pop");
        st.in();
        
    }
}
