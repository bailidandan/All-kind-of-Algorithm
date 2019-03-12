package 合并有序链表;

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
	
	public void ergodic(){
		Node p = first;
		while(p.next!=null){
			p=p.next;
			System.out.println(p.data);
		}
	}

}
