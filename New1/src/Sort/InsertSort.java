package Sort;

public class InsertSort{
	
	public static void insertSort(int[] a){
		System.out.println("length:"+a.length);//
		for(int i=1;i<a.length;i++){
		intsert(a,i-1,a[i]);
	}
}
	public static void intsert(int[] a, int end, int data) {
		if(end==0){//最开始的情况
			if(a[0]>data){
				//移数（倒过来），插入
				for(int j=1;j>0;j--)a[j]=a[j-1];
				a[0]=data;
			}
			return;}
		
		for(int i=0;i<=end;i++){
			if(a[i]>data){
				//移数（倒过来），插入
				for(int j=end+1;j>i;j--)a[j]=a[j-1];
				a[i]=data;
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] a={3,2,5,2,8,88,56,1};
		insertSort(a);
		for(int i=0;i<8;i++){
			System.out.println(a[i]);
		}
	}
	
}