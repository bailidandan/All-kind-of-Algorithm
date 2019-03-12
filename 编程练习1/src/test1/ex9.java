package test1;

public class ex9 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)return false;
        return isTreePT(sequence,0,sequence.length-1);
}
    public boolean isTreePT(int[] sequence,int start,int end){
        if(start>=end)return true;
        int i=start;
        
        for(;i<=end;i++)if(sequence[i]>sequence[end]) break;
        
        for(int j=i;j<=end;j++)if(sequence[j]<sequence[end])return false;
        
        
        return isTreePT(sequence,start,i-1)&&isTreePT(sequence,i,end-1);
}
    public static void main(String[] args) {
    	ex9 e=new ex9();
    	int[] sequence={1,2,3};
    	e.VerifySquenceOfBST(sequence);
	}

}
