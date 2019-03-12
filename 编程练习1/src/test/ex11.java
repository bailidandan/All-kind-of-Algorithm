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
	// 使用HashMap(查找的时间复杂度为O(1))
		// 由题目假设知只有一对数满足该情况，故每个数都是唯一的，不存在重数的情况
		public static int[] twoSum(int[] numbers, int target) {
			if (numbers != null) {
				HashMap<Integer, Integer> num_map = new HashMap<>();
				
				for (int i = 0; i < numbers.length; i++) {
					
					if (num_map.containsKey(numbers[i])) {//看一看接下来，有没有吻合我们要求的东西
						int index = num_map.get(numbers[i]);
						int[] result = { ++index, ++i };
						return result;
						
					} else {
						num_map.put(target - numbers[i], i);//记录下来每一个残缺的备份
					}
					
					
				}
			}
			return null;
		}
 
 
}
 

