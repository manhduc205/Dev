/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB11k_PHAN2;

/**
 *
 * @author DucPc
 */
class DevidedByZeroException extends Exception {
    public DevidedByZeroException() {
        super("Attempted to divide by zero");
    }
    
    public DevidedByZeroException(String msg) {
        super(msg);
    }
}
