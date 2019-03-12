package test1;


import java.util.ArrayList;  
import java.util.Collections;  
import java.util.LinkedList;
import java.util.List;  
public class ex1 {  
    public static void main(String args[]) {  
        //注意List是实现Collection接口的  
        List list = new ArrayList();  
        double array[] = { 11, 12, 45, 23, 123 };  
        
        for (int i = 0; i < array.length; i++) {  
            list.add(new Double(array[i]));  
        }  
        
        Collections.sort(list);  
        LinkedList llst=new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
			llst.add(array[i]);
		}
        Collections.reverse(llst);
        Collections.rotate(llst, 2);
        for (int i = 0; i < array.length; i++) {  
            System.out.println(llst.get(i));  
        }  
    }  
}