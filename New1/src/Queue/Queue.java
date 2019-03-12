package Queue;

public class Queue {
	static int MAX = 10;
	private int[] queue = new int[MAX];
	int top;
	int tail;
	public Queue(){
		top=0;
		tail=0;
	}
	public boolean isEmpty(){
		if(top==tail)//�����Ͻ�������֮��ֻҪ����tail�ǲ��ҿ���top��
			return true;
		else
			return false;
	}
	public boolean isFull(){
		int t = (top+1)%10;
		if(t==tail)
			return true;
		else
			return false;
	}
	
	public boolean addQ(int data){
		if(isFull()){
			System.out.println("������");
			return false;
		}
		top = (top+1)%10;
		queue[top]=data;
		return true;
	}
	public int delQ(){
		if(isEmpty()){
			System.out.println("���п�");
			return -1;
		}
		tail = (tail+1)%10;
		return queue[tail];
	}
	public void ergodic(){
		System.out.println("��ӡ���У�");
		if(isEmpty()){
			System.out.println("���п�");
			return;
		}
		if(tail>top){
			for (int i = tail+1; i < MAX; i++) {
				System.out.println(queue[i]);
			}
			for (int i = 0; i <= top; i++) {
				System.out.println(queue[i]);
			}
		}
		else{
			for (int i = tail+1; i <= top; i++) {
				System.out.println(queue[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		Queue q = new Queue();
		q.addQ(1);
		q.delQ();
		
		q.addQ(2);
		q.delQ();
		q.addQ(3);
		q.addQ(4);
		q.addQ(5);
		q.addQ(6);
		q.addQ(7);
		q.addQ(8);
		q.addQ(9);
		//System.out.println("top:"+q.top);
		q.addQ(10);
		q.addQ(11);
		//q.delQ();
		//q.delQ();
		q.ergodic();
	}
//����һ��λ�ã�����ά��һ��һʵ��ģʽ����˲����������ֿպ���
}
