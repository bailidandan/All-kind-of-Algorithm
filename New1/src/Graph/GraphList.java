package Graph;

import �������жϻ�.Node;

public class GraphList {
	public GraphNode first;
	public GraphList() {
		first = new GraphNode(0);
	}
	public void insertFirst(int data){
		GraphNode node = new GraphNode(data);
		//�жϷ����ڴ��Ƿ�ɹ�
		if(node==null){
			System.out.println("�ڴ����ʧ��");
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
