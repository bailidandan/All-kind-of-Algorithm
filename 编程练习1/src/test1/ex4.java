package test1;

import java.util.ArrayList;

public class ex4 {
	public static void main(String[] args) {
		ex4 e=new ex4();
		int[] array={1,2,3,4,5,6,7};
		e.reOrderArray(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		
	}
    public void reOrderArray(int [] array) {
    	int part=getOddNum(array);
    	int [] res=new int[array.length];
    	inOdd(array,res);
    	inEven(array,res,part);
  
    	for (int j = 0; j < array.length; j++) {
			array[j]=res[j];
		}
    	
    }
    private void inEven(int[] array, int[] res, int part) {
    	int append=part;
		for (int i = 0; i < array.length; i++) {
			if(array[i]%2!=1){
				res[append]=array[i];
				append++; 
			}
		}
		
	}
	private void inOdd(int[] array, int[] res) {
		int resIndex=0;
		for (int i = 0; i < array.length; i++) {
			if(array[i]%2==1){
				res[resIndex]=array[i];
				resIndex++;
			}
		}
		
	}
	public int getOddNum(int [] array){
    	int count=0;
    	for (int i = 0; i < array.length; i++) {
			if(array[i]%2==1)count++;
		}
    	return count;
    }
    
}
