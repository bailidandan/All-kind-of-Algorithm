package List;

import java.util.Scanner;

public class List {
	public Node first;
	public static int NODE_COUNT=0;
	public List() {
		first = new Node();
	}
	public Node findTail(){//查找尾结点
		Node p = first;
		while(p.next!=null){
			p=p.next;
		}
		return p;
	}
	public void topInsert(String data){//头插法
		Node node = new Node(data);
		if(node==null){
			System.out.println("内存分配失败");
		}
		node.next = first.next;
		first.next = node;
		NODE_COUNT++;
	}
	public void tailInsert(String data){//尾插法
		Node node = new Node(data);
		if(node==null){
			System.out.println("内存分配失败");
		}
		Node tail = findTail();
		tail.next = node;
		NODE_COUNT++;
	}
	public Node searchPreNodeByData(String data){//通过数据找指定前一个结点
		Node p = first;
		Node pre = null;
		while(p.next!=null){
			pre = p;
			p=p.next;
			if(p.data==data){
				return pre;
			}
		}
		return null;//返回null表示未找到
	}
	public Node searchPreNodeByIndex(int index){//通过位置找指定前一个结点
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
		return null;//返回null表示未找到
	}
	public void deleteNodeByData(String data){//删除指定数据的结点
		Node p = searchPreNodeByData(data);
		if(p==null){
			System.out.println("该结点不存在");
			return;
		}
		p.next = p.next.next;//p.next结点没有引用，被自动回收
	}
	public void deleteNodeByIndex(int index){//删除指定位置的节点
		Node p = searchPreNodeByIndex(index);
		if(p==null){
			System.out.println("该结点不存在");
			return;
		}
		p.next = p.next.next;//p.next结点没有引用，被自动回收
	}
	public void updateNode(int index,String data){
		Node p = searchPreNodeByIndex(index);
		p.next.data = data;
		
	}
	public void ergodic(){//遍历链表
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
//			System.out.println("找到！");
//		}else{
//			System.out.println("未找到！");
//		}
//		list.deleteNodeByData("3");
//		list.ergodic();
//		list.deleteNodeByIndex(3);
		list.updateNode(3, "9");
		list.ergodic();
	}

}
