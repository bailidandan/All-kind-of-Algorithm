package BinTree;

public class BinTree {
	public Node root;
	public BinTree() {
		root = new Node();
	}
	public void insertNode(int data){
		if(root.data==-1){
			root.data=data;
			return;
		}
		Node node = new Node();
		node.data=data;
		
		Node rearNC = getRearNoChild();
		//System.out.println(rearNC.data);
		if(rearNC.lchild==null){
			rearNC.lchild=node;
		}else
		{
			rearNC.rchild=node;
		}
	}
	public Node getRearNoChild() {
		Node[] queue = new Node[100];
		int front=0,rear=-1;
		queue[++rear]=root;
		int flag=2;
		
		Node t=null;
		while(true){
			flag=0;
			t=queue[front];
			if(t.lchild!=null){queue[++rear]=t.lchild;flag++;}
			if(t.rchild!=null){queue[++rear]=t.rchild;flag++;}
			if(flag==2)
				front++;
			else
				break;
		}
		//System.out.println(front);
		return queue[front];
	}
	
	
	public static void visit(Node root){
		if(root==null)return;
		System.out.println(root.data);
		visit(root.lchild);
		visit(root.rchild);
	}
	
	
	public static void main(String[] args) {
		BinTree bt = new BinTree();
		bt.insertNode(1);
		bt.insertNode(2);
		bt.insertNode(3);
		bt.insertNode(4);
		bt.insertNode(5);
		bt.insertNode(6);
		bt.insertNode(7);
		//System.out.println(bt.root.lchild.data);
		bt.visit(bt.root);
	}

}
