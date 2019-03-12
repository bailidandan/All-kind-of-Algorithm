package test01;

import java.util.ArrayList;
import java.util.Scanner;

public class ex9 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int zuS=scan.nextInt();
		ArrayList<Integer> ss=new ArrayList<Integer>();
		
		for (int i = 0; i < zuS; i++) {
			int n=scan.nextInt();
			int X=scan.nextInt();
			ArrayList<Integer> a=new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				int s=scan.nextInt();
				a.add(s);
				}
			int pj=pj(a);
			int rs=0;
			int pjI=pj;
			while(true){
				int zeng=100-a.get(rs);
				pjI=(pjI*n+zeng)/n;
				if(pjI>=X)break;
				rs++;
			}
			ss.add(rs+1);
		}
		for (int i = 0; i < ss.size(); i++) {
			System.out.println(ss.get(i));
		}
		
	}

	private static int pj(ArrayList<Integer> a) {
		int sum=0;
		for (int i = 0; i < a.size(); i++) {
			sum+=a.get(i);
		}
		
		return sum/a.size();
	}

}
