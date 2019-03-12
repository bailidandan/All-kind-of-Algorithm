package test2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class genericParadigm {
	public static void main(String[] args) {
		ArrayList<Integer> ai=new ArrayList<Integer>();
		ArrayList a=new ArrayList<Integer>();//存在了，但是我们取用的时候，却没有用它，但是我们已经花钱了，如果没有加的话，等于白白花钱了
		ai.add(1);
		a.add(1);
		int m=(int)a.get(1);
		
		System.out.println(ai.toString());
		System.out.println(a.toString());
	}
}
