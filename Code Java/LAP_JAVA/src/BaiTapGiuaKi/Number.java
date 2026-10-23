
package BaiTapGiuaKi;

import java.util.Scanner;

/**
 *
 * @author DucPc
 */
public class Number {
    private int value, min, max;

    public int getValue() {
        return value;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
    public Number(){
        
    }
    public Number(int value, int min, int max){
        if (min >= value || value >= max) {
            throw new IllegalArgumentException("Dieu kien khong hop le: (min < value < max)");
        }
        this.min = min;
        this.value = value;
        this.max = max;
    }
    
    public void nhap(){
        do {            
            System.out.println("Nhap min: ");
            Scanner sc = new Scanner(System.in);
            min = sc.nextInt();
            System.out.println("Nhap value: ");
            value = sc.nextInt();
            System.out.println("Nhap max: ");
            max= sc.nextInt();
            if(min >= value || value >= max){
                System.out.println("Vui long nhap lai (min < value < max): ");
            }
        } while (min >= value || value >= max);
            
        
    }
    public void in(){
        System.out.println("Min : " + min);
        System.out.println("Value: " + value);
        System.out.println("Max: " + max);
    }
    public Boolean ktraNT(){
        if(value < 2){
            return false;
        }
        for(int i = 2; i < value; i++){
            if(value % i == 0){
                return false;
            }  
        }
        return true;
    }
    
}
