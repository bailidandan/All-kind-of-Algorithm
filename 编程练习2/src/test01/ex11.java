package test01;

import java.util.Scanner;

public class ex11 {
	public static void main(String [] args){
    	Scanner scan=new Scanner(System.in);
      	String history=scan.nextLine();
      	String sky=scan.nextLine();
      	char[] h=history.toCharArray();
      	for (int i = 0; i < h.length; i++) {
			if(h[i] >= 'A' && h[i] <= 'Z' || h[i] >= 'a' && h[i] <= 'z' || h[i] >= '0' && h[i] <= '9')
				h[i]='1';
			else
				h[i]='0';
		}
      	char[] s=sky.toCharArray();
      	int sum=h.length;
      	Integer equal=0;
      	
      	
      	for (int i = 0; i < sum; i++) {
      		char hh,ss;
      		hh=h[i];
      		ss=s[i];
      		if(hh==ss)
      			equal++;
		}
      	
      	double com=(double)equal/sum;
      	 System.out.printf("%.2f%%",(double)com*100.0);

    }

}
