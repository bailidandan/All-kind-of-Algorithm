package 接口回调;

public class Test {
public static void main(String[] args) {
	IntCompare com=null;
	int a=3,b=4;
	com=new Cmp1();
	System.out.println(com.cmp(a, b));
	com=new Cmp2();
	System.out.println(com.cmp(a, b));
}
}
