package 合并有序链表;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;
public class Solution {
	int ilength;
	int jlength;
	ArrayList pass=new ArrayList();
	int [][]matrix;

    public ArrayList<Integer> printMatrix(int [][] matrix) {
    	jlength=matrix[0].length;
    	ilength=matrix.length;
		this.matrix=matrix;
		int i=0,j=0;
		pass.add(matrix[0][0]);
		getPass(i,j);
		return pass;
    }
    public boolean checkTop(int i,int j){
    	if(pass.contains(matrix[i-1][j]))
    		return false;
    	else 
    		 return true;
    }
    
    public boolean checkOutIndex(int i,int j){
    	
    	if(ilength<=i||i<0||jlength<=j||j<0)return false;
    	else return true;
    }
    public boolean checkPass(int i,int j){
    	if(pass.contains(matrix[i][j]))return false;
    	else return true;
    }
    public boolean special(int i,int j){
        if(ilength==2)return true;
    	if(i>0&&i<ilength-1&&j<=jlength/2&&checkTop(i,j))return false;
    	else return true;
    }
    public void getPass(int i,int j){
    	boolean flag=true;
    	
        if(special(i,j)&&checkOutIndex(i, j+1)&&checkPass(i, j+1)&&flag){
     	   pass.add(matrix[i][j+1]);
     	   getPass(i,j+1);
     	   flag=false;
        }
        if(checkOutIndex(i+1, j)&&checkPass(i+1, j)&&flag){
      	   pass.add(matrix[i+1][j]);
      	   getPass(i+1, j);
      	 flag=false;
        }
        if(checkOutIndex(i, j-1)&&checkPass(i, j-1)&&flag){
      	   pass.add(matrix[i][j-1]);
      	   getPass(i, j-1);
      	 flag=false;
        }
        if(checkOutIndex(i-1, j)&&checkPass(i-1, j)&&flag){
      	   pass.add(matrix[i-1][j]);
      	   getPass(i-1, j);
      	 flag=false;
        }
    }
    public static void main(String[] args) {
		int[][]matrix={
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
		};
		Solution s=new Solution();
		ArrayList l = s.printMatrix(matrix);
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i)+" ");
		}
	}
}