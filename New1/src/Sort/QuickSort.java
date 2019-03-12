package Sort;

public class QuickSort {
	public static void quickSort(int[] a,int left,int right){
		if(left==right)return;
		int mid = middle(a,left,right);
		//System.out.println(mid);
		quickSort(a,left,mid);
		quickSort(a,mid+1,right);//这个可能出现left>right的情况
	}

	private static int middle(int[] s, int left, int right) {//配合了正确的思想
		int i = left,j=right;
		int x=s[i];
		while(i<j){
			
			while(i<j&&s[j]>=x)j--;
			if(i<j){s[i]=s[j];i++;}
				
			while(i<j&&s[i]<x)i++;
			if(i<j){s[j]=s[i];j--;}
		}
		s[i]=x;
		return j;

	}
	
	public static void main(String[] args) {
		int[] a={3,2,5,2,8,88,56,1};
		quickSort(a,0,7);
		for(int i=0;i<8;i++){
			System.out.println(a[i]);
		}

	}

}
