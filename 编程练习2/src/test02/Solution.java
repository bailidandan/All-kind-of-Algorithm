package test02;

public class Solution {
    static public boolean Find(int target, int [][] array) {
    	if(array==null||array.length==0||(array.length==1&&array[0].length==0)) return false;    	int length =array.length;
    	int width=array[0].length;
    	if(length==0&&width==0)return false;
    	boolean tell=false;
    	int i=0;
    	while (i<length&&array[i][i]<=target) {
			i++;
		}
    	int j=0,j2=0;
    	for (j=0; j < length; j++) {
			for (j2=0; j2 < width; j2++) {
				if(array[j][j2]==target||j>=i&&j2>=i)break;
			}
			if(j<length&&j2<width&&array[j][j2]==target){
				tell=true;break;
				}
		}
    	return tell;
    }
    public static void main(String[] args) {
    	int array[][]={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}}
;
    	int arr[][]=null;
 
	System.out.println(Find(7,arr));
	}
}