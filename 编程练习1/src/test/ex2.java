package test;

import java.util.Scanner;

public class ex2 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("«Î ‰»ÎN£∫");
		int N=0;
		int sum=1;
		N=scan.nextInt();
		 for(int i=1;i<=N;i++){
			   	sum=sum*i;
			   }
		 //System.out.println(N);
		System.out.println(Math.pow(2, N-1)*sum);
	}

}
