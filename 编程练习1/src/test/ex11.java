package test;

import java.util.HashMap;
import java.util.Scanner;
 
public class ex11 {
 
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int num=in.nextInt();
		int []a=new int[num];
		for(int i=0;i<num;i++) {
			a[i]=in.nextInt();
		}
		int target=in.nextInt();
		int []result=twoSum(a,target);
		System.out.print(result[0]+" "+result[1]);
 
	}
	// ʹ��HashMap(���ҵ�ʱ�临�Ӷ�ΪO(1))
		// ����Ŀ����ֻ֪��һ����������������ÿ��������Ψһ�ģ����������������
		public static int[] twoSum(int[] numbers, int target) {
			if (numbers != null) {
				HashMap<Integer, Integer> num_map = new HashMap<>();
				
				for (int i = 0; i < numbers.length; i++) {
					
					if (num_map.containsKey(numbers[i])) {//��һ������������û���Ǻ�����Ҫ��Ķ���
						int index = num_map.get(numbers[i]);
						int[] result = { ++index, ++i };
						return result;
						
					} else {
						num_map.put(target - numbers[i], i);//��¼����ÿһ����ȱ�ı���
					}
					
					
				}
			}
			return null;
		}
 
 
}
 

