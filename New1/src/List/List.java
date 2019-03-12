package List;

import java.util.Scanner;

public class List {
	public Node first;
	public static int NODE_COUNT=0;
	public List() {
		first = new Node();
	}
	public Node findTail(){//����β���
		Node p = first;
		while(p.next!=null){
			p=p.next;
		}
		return p;
	}
	public void topInsert(String data){//ͷ�巨
		Node node = new Node(data);
		if(node==null){
			System.out.println("�ڴ����ʧ��");
		}
		node.next = first.next;
		first.next = node;
		NODE_COUNT++;
	}
	public void tailInsert(String data){//β�巨
		Node node = new Node(data);
		if(node==null){
			System.out.println("�ڴ����ʧ��");
		}
		Node tail = findTail();
		tail.next = node;
		NODE_COUNT++;
	}
	public Node searchPreNodeByData(String data){//ͨ��������ָ��ǰһ�����
		Node p = first;
		Node pre = null;
		while(p.next!=null){
			pre = p;
			p=p.next;
			if(p.data==data){
				return pre;
			}
		}
		return null;//����null��ʾδ�ҵ�
	}
	public Node searchPreNodeByIndex(int index){//ͨ��λ����ָ��ǰһ�����
		if(index>NODE_COUNT||index<=0){
			return null;
		}
		Node p = first;
		Node pre = null;
		int i = 0;
		while(p.next!=null){
			pre=p;
			p=p.next;
			i++;
			if(i==index){
				return pre;
			}
		}
		return null;//����null��ʾδ�ҵ�
	}
	public void deleteNodeByData(String data){//ɾ��ָ�����ݵĽ��
		Node p = searchPreNodeByData(data);
		if(p==null){
			System.out.println("�ý�㲻����");
			return;
		}
		p.next = p.next.next;//p.next���û�����ã����Զ�����
	}
	public void deleteNodeByIndex(int index){//ɾ��ָ��λ�õĽڵ�
		Node p = searchPreNodeByIndex(index);
		if(p==null){
			System.out.println("�ý�㲻����");
			return;
		}
		p.next = p.next.next;//p.next���û�����ã����Զ�����
	}
	public void updateNode(int index,String data){
		Node p = searchPreNodeByIndex(index);
		p.next.data = data;
		
	}
	public void ergodic(){//��������
		Node p = first;
		while(p.next!=null){
			p=p.next;
			System.out.println(p.data);
		}
	}
	public static void main(String[] args) {
		List list = new List();
//		Scanner scan = new Scanner(System.in);
//		while(true){
//			String s =scan.next();
//			if(s.equals("end"))
//				break;
//			list.tailInsert(s);
//		}
//		list.ergodic();
		list.topInsert("1");
		list.topInsert("2");
		list.topInsert("3");
		list.topInsert("4"); 
//		Node searchNode = list.searchPreNodeByData("3");
//		if(searchNode!=null){
//			System.out.println("�ҵ���");
//		}else{
//			System.out.println("δ�ҵ���");
//		}
//		list.deleteNodeByData("3");
//		list.ergodic();
//		list.deleteNodeByIndex(3);
		list.updateNode(3, "9");
		list.ergodic();
	}

}
