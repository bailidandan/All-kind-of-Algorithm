package TestQuestion;
class Queue{//¼ò»¯°æ
	public int[] q;
	public int front=0;
	public int rear=0;
	
	public Queue(){
		q=new int[100];
	}
	public int get(){
		return q[front++];
	}
	
	public void add(int data){
		q[rear++]=data;
	}
}


public class ex2_LevelOutput {
	public  Queue q;
	public int[] a;
	int length=7;
	
	public ex2_LevelOutput(){
		q=new Queue();
	}
	
	public  void levelOutput(){
		int i=1,front=0;
		q.add(a[0]);
		while(i<length){
			front=q.get();
			if(front!=-1)
				System.out.println(front);
			
			addQ(i);
			i++;
		}
		
	}
	public void addQ(int p) {
		int left = 2*p;
		int right=left+1;
		if(left<length)q.add(a[left-1]);
		if(right<length)q.add(a[right-1]);
		
	}
	
	public static void main(String[] args) {
		int[] a={1,3,2,-1,-1,4,-1};
		ex2_LevelOutput level = new ex2_LevelOutput();
		level.a=a;
		level.levelOutput();
	}
	 
}
