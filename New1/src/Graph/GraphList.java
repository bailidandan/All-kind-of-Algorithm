package Graph;

import 单链表判断环.Node;

public class GraphList {
	public GraphNode first;
	public GraphList() {
		first = new GraphNode(0);
	}
	public void insertFirst(int data){
		GraphNode node = new GraphNode(data);
		//判断分配内存是否成功
		if(node==null){
			System.out.println("内存分配失败");
			return;
		}
		GraphNode graphTail=first;
		while(graphTail.next!=null){
			graphTail=graphTail.next;
		}
		node.next=graphTail.next;
		graphTail.next=node;
	}
	
	
	public GraphNode findNodeBydata(int data){
		GraphNode p=first;
		while(p.next!=null){
			if(p.data==data)break;
			p=p.next;
			
		}
		if(p.data==data){
			return p;
		}
		return null;
	}


}
