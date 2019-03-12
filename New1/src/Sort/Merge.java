package Sort;

public class Merge {
	public static void mergeSort(int[] a,int left,int right){
		if(left==right)return;
		
		int mid=(left+right)/2;
		mergeSort(a, left, mid);
		mergeSort(a, mid+1, right);
		//得到排序好的两个组
		merge(a,left,mid,right);
	}
	
	
	public static void merge(int[] a, int left, int mid, int right) {
		int[]m=new int[mid-left+1];//1
		int[]n=new int[right-mid];//1
		
		for (int i = left; i <= mid; i++) {
			//System.out.println(i-left);
			m[i-left]=a[i];
		}
		for (int i = mid+1; i <= right; i++) {
			n[i-mid-1]=a[i];//多出来一个位置
		}
		
		int i=0,j=0,z=left;
		
		
		while(true){
			
			if(j>=(right-mid)&&z<=right){
				a[z]=m[i];
				i++;
				z++;
			}
			else
				if(z<=right&&i<(mid-left+1)&&m[i]>n[j]){
					a[z]=m[i];
					i++;z++;
				}

				
			
			if(i>=(mid-left+1)&&z<=right){//敌方出了错误
				a[z]=n[j];
				j++;z++;
			}
			else
				if(z<=right&&j<(right-mid)&&m[i]<n[j]){//出现了下标越界
					a[z]=n[j];
					j++;z++;
				}
				
			
			
			if(i>=(mid-left+1)&&j>=(right-mid)&&z>right)break;
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] a={3,4,5,2,8,88,56,77,45};
		mergeSort(a,0,8);
		for(int i=0;i<9;i++){
			System.out.println(a[i]);
		}
	}

}
