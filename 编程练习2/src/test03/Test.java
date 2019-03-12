package test03;

import java.util.HashMap;
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Test {
    static public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
        
        return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
        
    }

	private static TreeNode preIn(int[] p, int pi, int pj, int[] n, int ni, int nj,
			HashMap<Integer, Integer> map) {
		if(pi>pj)return null;
		//condition of end;
		TreeNode head=new TreeNode(p[pi]);
		int index=map.get(p[pi]);
		//separate two option
		int option=index-ni;
		head.left=preIn(p,pi+1,pi+option,n,ni,index-1,map);
		head.right=preIn(p,pi+option+1,pj,n,index+1,nj,map);
		return head;
	}
	public static void main(String[] args) {
		int pre[]={1,2,3,4,5,6,7};
		int in[]={3,2,4,1,6,5,7};
		TreeNode root = reConstructBinaryTree(pre, in);
		rear(root);
	}
	
	static public void rear(TreeNode root){
		if(root==null)return;
		rear(root.left);
		rear(root.right);
		System.out.print(root.val+",");
	}
}