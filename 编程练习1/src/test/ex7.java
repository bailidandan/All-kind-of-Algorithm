package test;

import java.util.ArrayList;

public class ex7 {
	public int getPart(int[] array){
		int i=-1;
		for (i = 0; i < array.length; i++) {
			if(array[i]>array[i+1])break;
		}
		return i;
	}
	

	    public int minNumberInRotateArray(int [] array) {
	    	if(array==null)return 0;
	    	ArrayList<Integer> buffer=new ArrayList<>();
	    	int part=getPart(array);
	    	for (int i = 0; i <= part; i++) {
				buffer.add(array[i]);
			}
	    	for (int i = part+1; i < array.length; i++) {
				array[i-part-1]=array[i];
			}
	    	
	    	for (int i = 0; i <= part; i++) {
				array[array.length-1-part+i]=buffer.get(i);
			}
//	    	for (int i = 0; i < array.length; i++) {
//				System.out.print(array[i]);
//			}
	    	return array[0];
	    }
	    public static void main(String[] args) {
			int[] a={3,4,5,6,1,2};
			ex7 e=new ex7();
			System.out.println(e.minNumberInRotateArray(a));
		}
	    
	
}
