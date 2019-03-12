package 图算法;

import java.util.ArrayList;

public class 最小生成树 {
	public int two[][]={//记录连接关系
			{0,2,1,0,0},
			{2,0,0,3,5},
			{1,0,0,0,0},
			{0,3,0,0,0},
			{0,5,0,0,0}
	};
	public int in[]={1,0,0,0,0};

	public int eachMin(int[] one) {//传入参数a[n],n是起始的结点
		int min=300,Mark=-1;
		
		for (int i = 0; i < one.length; i++) {
			if(in[i]!=1&&one[i]!=0){
				if(one[i]<min){
					min=one[i];
					Mark=i;
				}
			}
		}
		return Mark;
	}
	
	public int trueMin(int[] in){
		int Mark=-1,min=300;
		for (int i = 0; i < in.length; i++) {
			if(in[i]==1){//已经归属
				int each=eachMin(two[i]);
					if(each!=-1&&in[each]!=1&&two[i][each]<min){
						min=two[i][each];
						Mark=each;
					}
			}
		}
		return Mark;
	}
	public void printPath(){
		
		int index=0;
		for (int i = 0; i < in.length; i++) {
			index=trueMin(in);
			if(index!=-1){
				System.out.println(index);
				in[index]=1;
			}
		}
	}
	public static void main(String[] args) {
		最小生成树 tree= new 最小生成树();
		tree.printPath();
		
	}

}
