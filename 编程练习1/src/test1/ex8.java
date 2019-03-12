package test1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
public class ex8 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
     Queue<TreeNode> q= new LinkedList<TreeNode>();
     ArrayList<Integer> memory=new ArrayList<Integer>();
     q.offer(root);
     
     while(!q.isEmpty()){
    	 TreeNode meNode= q.poll();
    	 int me=meNode.val;
    	 memory.add(me);
    	 
    	 if(meNode.left!=null)q.offer(meNode.left);
    	 if(meNode.right!=null)q.offer(meNode.right);

    	 }
     return memory;
     }
    }

}
