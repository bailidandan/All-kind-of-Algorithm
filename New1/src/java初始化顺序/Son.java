package java��ʼ��˳��;
class Father{
	static int father=1;
	static{
		if(father==1)
		System.out.println("����̬�����");
	}
	Father(){
		System.out.println("father���캯��");
	}
	
}

public class Son extends Father {
	Son(){
		//System.out.println("son���캯��");
	}
	public static void main(String[] args) {
		new Son();
	}
	{System.out.println(super.getClass().getSuperclass().getName());}
	
}
