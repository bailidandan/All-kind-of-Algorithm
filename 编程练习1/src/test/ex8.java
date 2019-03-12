package test;

public class ex8 {
    static int i=0;
    static int last;
    static int n;
    public static void sum(int pre1,int pre2,int i){
        if(i==(n-1))return;
        last=pre1+pre2;
        sum(pre2,last,++i);
    }
    public int Fibonacci(int n) {
    	 if(n==0)return 0;
    	 if(n==1)return 1;
        this.n=n;
        sum(0,1,i);
        return last;
    }
    public static void main(String[] args) {
		ex8 e=new ex8();
		System.out.println(e.Fibonacci(3));
	}

}
