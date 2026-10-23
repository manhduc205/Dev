
package Interface;

import java.util.ArrayList;

/**
 *
 * @author DucPc
 */
public class My_Stack implements Stack {
    ArrayList<Object> ar = new ArrayList<>();
    @Override
    public void push(Object d){
        ar.addFirst(d);
    }
    @Override
    public void pop(){
        ar.removeFirst();
    }
    
    public void in(){
        for(int i = 0; i < ar.size(); i++){
            System.out.println(ar.get(i));
        }
    }
}
