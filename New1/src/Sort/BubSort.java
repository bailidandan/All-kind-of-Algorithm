package Sort;

public class BubSort {
	public static void bubSort(int[] a,int end){
		int t=0;
		while(end>1){
			for (int i = 0; i < end; i++) {
				if(a[i+1]<a[i]){
					t=a[i];//swap
					a[i]=a[i+1];
					a[i+1]=t;
				}
			}
			end--;
		}
	}

	public static void main(String[] args) {
		int[] a={3,4,5,2,8,88,56,77};
		bubSort(a,7);
		for(int i=0;i<8;i++){
			System.out.println(a[i]);
		}
	}
}
