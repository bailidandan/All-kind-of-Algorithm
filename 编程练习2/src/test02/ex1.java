package test02;

public class ex1 {

	public static void main(String[] args) {
		int[] a={0,1,2,3,4,5,6,7,8,9};
		int[] mk={0,0,0,0,0,0,0,0,0,0};
		int i=1,n=10,p=0;
		while(true){
			if(allVisit(mk))break;//all be visited
			p=findParnet(i);
			if(mk[i]==0)//no visited
				System.out.println(i);
			mk[i]=1;//mark visited
			if(2*i>=n||a[2*i]==0||mk[2*i]==1){
				if((2*i+1)>=n||a[2*i+1]==0||mk[2*i+1]==1){
					i=p;
				}else{i=2*i+1;continue;} 
			}else{i=2*i;continue;} 
		}
	}
	private static boolean allVisit(int[] mk) {
		for (int i = 1; i < mk.length; i++) {
			if(mk[i]==0)
				return false;
		}
		return true;
	}
	private static int findParnet(int i) {
		if(i%2==0)
			return  i/2;
		else return (i-1)/2;
	}

}
