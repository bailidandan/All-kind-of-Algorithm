package Graph;

public class Graph {
	GraphList inter;
	public Graph(){
		inter=new GraphList();
	}
	public void insertNode(int data){
		inter.insertFirst(data);

	}
	public void insertLine(GraphLine line){//插入连线
		GraphNode begin=inter.findNodeBydata(line.begin);
		
		if(begin==null){
			System.out.println("找不到以begin："+begin+"的结点");
			return;
			}
		
		if(begin.child==null)
		begin.child=new GraphList();
		
		
		begin.child.insertFirst(line.end);
		
		GraphNode beginChild=begin.child.findNodeBydata(line.end);
		GraphNode trueNode=inter.findNodeBydata(line.end);//在begin结点中创建一个虚拟end结点，指向真正end结点
		
		beginChild.to=trueNode;
	}
	
	
	public static void ergodic(GraphNode trueNode){//深度优先遍历
		if(trueNode.child==null)return;
		GraphNode p=trueNode.child.first;
		while(p.next!=null){
			p=p.next;
			System.out.println(p.data);
			ergodic(p.to);
		}
	}
	
	public static void main(String[] args) {
		Graph gra=new Graph();
		GraphLine line1=new GraphLine(0, 3, 3);
		GraphLine line2=new GraphLine(3, 1, 2);
		GraphLine line3=new GraphLine(3, 4, 2);
		
		GraphLine line4=new GraphLine(4, 5, 2);
		GraphLine line5=new GraphLine(5, 7, 2);
		GraphLine line6=new GraphLine(7, 8, 2);
		GraphLine line7=new GraphLine(7, 9, 2);
		GraphLine line8=new GraphLine(7, 10, 2);
		
		gra.insertNode(3);
		gra.insertNode(1);
		gra.insertNode(4);
		gra.insertNode(5);
		gra.insertNode(7);
		gra.insertNode(8);
		gra.insertNode(9);
		gra.insertNode(10);
		
		gra.insertLine(line1);
		gra.insertLine(line2);
		gra.insertLine(line3);
		gra.insertLine(line4);
		gra.insertLine(line5);
		gra.insertLine(line6);
		gra.insertLine(line7);
		gra.insertLine(line8);
		
		gra.ergodic(gra.inter.first);
	}
}
