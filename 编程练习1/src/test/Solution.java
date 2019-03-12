package test;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int[] pre={1,2,4,5,3,7};
	public int[ ]in ={4,2,5,1,3,7};
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

	
	
	public void printRoot(TreeNode parentP,int start,int end){
		
		if(start>end)return;
		int root=getsRIndex(start, end);
		
		//System.out.println(in[root]);
		TreeNode p=new TreeNode(in[root]);
		if(parentP!=null){
			if(parentP.left==null){
				parentP.left=p;
			}else{
				parentP.right=p;
			}
			
		}else{
			rootP=p;
		}

		printRoot(p,start, root-1);
		printRoot(p,root+1, end);
		
		
	}
	
	public static void printRea(TreeNode root){
		if(root==null)return;
		
		printRea(root.left);
		printRea(root.right);
		System.out.println(root.val);
		
	}
    
    
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        Solution e=new Solution();
        e.pre=pre;
        e.in=in;
        e.printRoot(null,0, in.length);
       // System.out.println("--------------");
        //printRea(e.rootP);
        return e.rootP;
    }
    public static void main(String[] args) {
    	Solution e=new Solution();
	}
}