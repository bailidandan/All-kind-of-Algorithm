package test;

import java.util.HashSet;
import java.util.Scanner;
 
public class ex10 {
 
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int num=in.nextInt();
		int []a=new int[num];
		HashSet<Integer> set=new HashSet<Integer>();
		for(int i=0;i<num;i++) {
			a[i]=in.nextInt();
			set.add(a[i]);
		}
		for(int i=1;i<=num;i++) {
			if(set.add(i)) {//返回true的时候，才能成功打印（不能插入重复的，所以在插入重复的数的时候，是一直报出false的，直到出现3的时候，才会出现true）
				System.out.println(i);
				break;
			}
			
		}
	}
 
}

