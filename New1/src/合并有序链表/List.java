package �ϲ���������;

public class List {
	public Node first;
	public List() {
		first = new Node();
	}
	public void insertFirst(int data){
		Node node = new Node();
		//�жϷ����ڴ��Ƿ�ɹ�
		if(node==null){
			System.out.println("�ڴ����ʧ��");
			return;
		}
		node.data=data;
		node.next=first.next;
		first.next=node;
	}
	
	public void ergodic(){
		Node p = first;
		while(p.next!=null){
			p=p.next;
			System.out.println(p.data);
		}
	}

}
