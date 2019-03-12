package Stack;

public class Stack {
	static int MAX=100;
	private int [] stack = new int[MAX];
	public int top;//0ÎªÕ»¿Õ£¬-1ÎªÕ»Âú
	public Stack(){
		top=-1;
	}
	public boolean isEmpty(){
		if(top==-1)
			return true;
		else
			return false;
	}
	public boolean isFull(){
		if(top>MAX-1)
			return true;
		else
			return false;
	}
	public boolean push(int data){//push½øÕ»
		if(isFull()){
			System.out.println("Õ»ÒÑ¾­Âú");
			return false;
		}
		stack[++top]=data;
		return true;
	}

	public int pop(){
		if(isEmpty()){
			return -1;
		}
		
		return stack[top--];
	}
	public void ergodic(){
		if(isEmpty()){
			System.out.println("Õ»¿Õ");
			return;
		}
		for (int i = 0; i <= top; i++) {
			System.out.println(stack[i]);
		}
	}
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.pop();
		stack.ergodic();
	}
	
}
