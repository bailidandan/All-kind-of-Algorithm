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
			if(set.add(i)) {//����true��ʱ�򣬲��ܳɹ���ӡ�����ܲ����ظ��ģ������ڲ����ظ�������ʱ����һֱ����false�ģ�ֱ������3��ʱ�򣬲Ż����true��
				System.out.println(i);
				break;
			}
			
		}
	}
 
}

