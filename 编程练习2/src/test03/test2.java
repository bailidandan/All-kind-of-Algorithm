package test03;

public class test2 {
	static public void f(int n,char A,char B,char C){
		if(n==1){
			System.out.println("move:"+A+"->"+B);
			return;
		}
		f(n-1,A,C,B);
		f(1,A,B,C);
		f(n-1,C,B,A);
	}
	public static void main(String[] args) {
		int n=4;
		f(n,'a','b','c');
	}
}
