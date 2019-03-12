package test;

import java.util.Stack;

public class ex6 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        toAnother(stack2, stack1);
        stack1.add(node);
    }
    
    public int pop() {
    	toAnother(stack1, stack2);
    	return stack2.pop();
    }
    
    public void toAnother(Stack<Integer> sta,Stack<Integer> end){
    	int length=sta.size();
    	int m;
    	for (int i = 0; i < length; i++) {
    		m=sta.pop();
			end.add(m);
		}
    }
    
    public static void main(String[] args) {
//		ex6 e=new ex6();
//		e.push(1);
//		e.push(2);
//		e.push(3);
//		System.out.println(e.pop());
    	Stack<Integer> sta1=new Stack<Integer>();
    	Stack<Integer> sta2=new Stack<Integer>();
    	
    	sta1.add(1);
    	sta1.add(2);
    	sta1.add(3);
    	sta1.add(4);

    	
    	System.out.println(sta2);
	}
}
