package test2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class genericParadigm {
	public static void main(String[] args) {
		ArrayList<Integer> ai=new ArrayList<Integer>();
		ArrayList a=new ArrayList<Integer>();//�����ˣ���������ȡ�õ�ʱ��ȴû�����������������Ѿ���Ǯ�ˣ����û�мӵĻ������ڰװ׻�Ǯ��
		ai.add(1);
		a.add(1);
		int m=(int)a.get(1);
		
		System.out.println(ai.toString());
		System.out.println(a.toString());
	}
}
