package test1;

import java.util.Stack;

public class ex6 {

    public Stack stack=new Stack<>();
    public Stack stackPre=new Stack<>();
    public int swap(int x,int y){
    	return x;
    }
    public void push(int node) {
    	
        stack.push(node);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return (int)stack.peek();
    }
    
    public int min() {
        int min=500;
        int pop=0;
        int prepare=0;
        System.out.println("stackSize:"+stack.size());
        
        for (int i = 0; i <= stack.size(); i++) {//这里面的size的数值是不断变化的，随着进栈和出栈不断的变化
        	pop=(int) stack.pop();
            prepare=pop;
            System.out.println("prepare:"+prepare);
			if(pop<min){
				pop=swap(min,min=pop);
			}
            stackPre.push(prepare);
		}
        
        
        System.out.println("stackPresize:"+stackPre.size());
        
        for (int i = stackPre.size(); i >0; i--) {
        	
			stack.push(stackPre.pop());
		}
        
        return min;
    }
    
    public static void main(String[] args) {
		ex6 e=new ex6();
		e.push(3);
		e.push(4);
		System.out.println(e.min());
		//e.pop();
		System.out.println(e.stack);
	}
}
