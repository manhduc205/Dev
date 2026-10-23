/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB11k_PHAN1;

/**
 *
 * @author DucPc
 */
public class Stack {
    private Object[] data;
    private int top;
    
    public Stack(int size){
        data = new Object[size];
        top = -1;
    }
    
    public Boolean empty(){
        return top == -1;
    }
    
    public Boolean full(){
        return top == data.length - 1;
    }
    
    public void put(Object data){
        if(data == null){
            throw new IllegalArgumentException("Khong the day phan tu null vao stack");
        }
        if(full()){
            throw new IllegalArgumentException("Stack da day khong the day");
        }
        this.data[++top] = data;
    }
    
    public Object get(int index){
        if(index == -1 || index > data.length - 1){
            throw new IndexOutOfBoundsException("Chi so ngoai pham vi");
        }
        if (data[index] == null) {
            throw new IllegalStateException("Phan tu la null tai vi tri " + index );
        }
        return data[index];
    }
    
    public Object pop() {
        if (empty()) {
            throw new IllegalStateException("Stack rỗng không thể lấy phần tử");
        }
        Object obj = data[top];
        data[top--] = null; // Xóa phần tử khỏi stack, giảm top
        return obj;
    }
    
}
