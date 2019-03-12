package 单链表判断环;



public class List {
	public Node first;
	public List() {
		first = new Node();
	}
	public void insertFirst(int data){
		Node node = new Node();
		//判断分配内存是否成功
		if(node==null){
			System.out.println("内存分配失败");
			return;
		}
		node.data=data;
		node.next=first.next;
		first.next=node;
	}
	public void buildRing(){//用于测试
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
