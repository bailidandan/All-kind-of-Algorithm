package test01;

import java.util.ArrayList;
import java.util.Scanner;

public class ex10 {
	public static void main(String[] args) {
		Thread t=new Thread();
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		
		ArrayList<Integer> a=new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int e=scan.nextInt();
			a.add(e);
		}
		
		int day=1;
		
		while(true){
			int pre=0,beh=0;
			
			for (int i = a.size()-1; i >0; i--) {
				pre=a.get(i);beh=a.get(i-1);
				
				if(pre<beh)
					a.remove(i);
				//System.out.println(a);
			}
			
			if(a.size()==1)break;
			day++;
		}
		
		System.out.println(day);
		
	}
}
