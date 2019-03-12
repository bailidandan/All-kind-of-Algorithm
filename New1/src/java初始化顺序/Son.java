package java初始化顺序;
class Father{
	static int father=1;
	static{
		if(father==1)
		System.out.println("父静态代码块");
	}
	Father(){
		System.out.println("father构造函数");
	}
	
}

public class Son extends Father {
	Son(){
		//System.out.println("son构造函数");
	}
	public static void main(String[] args) {
		new Son();
	}
	{System.out.println(super.getClass().getSuperclass().getName());}
	
}
