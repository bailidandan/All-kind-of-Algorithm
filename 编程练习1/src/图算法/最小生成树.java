package ͼ�㷨;

import java.util.ArrayList;

public class ��С������ {
	public int two[][]={//��¼���ӹ�ϵ
			{0,2,1,0,0},
			{2,0,0,3,5},
			{1,0,0,0,0},
			{0,3,0,0,0},
			{0,5,0,0,0}
	};
	public int in[]={1,0,0,0,0};

	public int eachMin(int[] one) {//�������a[n],n����ʼ�Ľ��
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
			if(in[i]==1){//�Ѿ�����
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
		��С������ tree= new ��С������();
		tree.printPath();
		
	}

}
