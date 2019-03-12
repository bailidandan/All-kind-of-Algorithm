package test;


  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class ex5 {
	public int[] pre={1,2,3,4};
	public int[] in ={1,2,3,4};
	public TreeNode rootP;
	
	
	public int getIndex(int sonPreS,int inS,int inE){//�ҵ�ĳ�����������������inS��inE��Χ�ڵ�λ��
		for (int i = inS; i <= inE; i++) {
			if(pre[sonPreS]==in[i])return i;
		}
		return -1;
	}
	
	public int getsRIndex(int inS,int inE){//�ҵ���inS��inE֮��ĸ����
		int preS=0,preE=0;
		int time=0;
		
		for (int i = 0; i < pre.length; i++) {//����ǰ���
			for (int j = inS; j <= inE; j++) {//���������
				if(time==0&&in[j]==pre[i]){//�ҵ���ǰ��ͷ
					preS=i;
					time++;
				}
				if(in[j]!=pre[i]){//�ҵ���ǰ���β
					preE=i-1;
				}
				
			}
		}
		
		int rootIndex=getIndex(preS, inS, inE);
		return rootIndex;
	}

	
	
	public void printRoot(int rootIndex,TreeNode parentP,int start,int end){
		
		if(start>end)return;
		int root=getsRIndex(start, end);//�м����������
		
		//System.out.println(in[root]);
		TreeNode p=new TreeNode(in[root]);
		
		if(parentP!=null){
			
			if(root<=rootIndex&&parentP.left==null){
				parentP.left=p;
			}else{
				parentP.right=p;
			}
			
		}else{
			rootP=p;
		}

		printRoot(root,p,start, root-1);
		printRoot(root,p,root+1, end);
		
		
	}
	
	public static void printRea(TreeNode root){
		if(root==null)return;
		
		System.out.print(" ( ");
		printRea(root.left);
		System.out.print(" ) ");
		
		System.out.print(root.val);
		
		System.out.print(" ( ");
		printRea(root.right);
		System.out.print(" ) ");
		
	}
	
public static void main(String[] args) {
	ex5 e=new ex5();
	e.printRoot(9,null,0, 3);
	System.out.println("--------------");
//	printRea(e.rootP);
	TreeNode p=e.rootP;
	
	System.out.println(p.val);
	System.out.println(p.right.val);
	System.out.println(p.right.right.val);
}

}
