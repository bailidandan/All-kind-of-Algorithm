package �������жϻ�;



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
	public void buildRing(){//���ڲ���
		Node tail=first,p3=null;
		while(tail.next!=null){
			tail=tail.next;
		}
		p3 = first.next.next.next;
		tail.next=p3;
	}
	public void ergodic(){
		Node p = first;
		while(p.next!=null){
			p=p.next;
			System.out.println(p.data);
		}
	}

}
