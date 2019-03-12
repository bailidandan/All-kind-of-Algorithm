package test01;

class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
}
public class ex8 { 
    public int bestC;
    public boolean IsBalanced_Solution(TreeNode root) {
        
         if(judgeOneN(root)!=0){
        	 TreeNode other=findOther(root);
        	 if(other==null||judgeOneGeneric(other))
        		 return true;
        	 else 
        		 return false;
         }
        findBottle(root.left,0);
        int bestL=bestC;
        findBottle(root.right,0);
        int bestR=bestC;
        int merge=Math.abs(bestL-bestR);
        
         return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right)&&(merge<=1);
    }
    
    
    public void findBottle(TreeNode root,int count){
        if(root==null){
            if(count>bestC)
                bestC=count;
        }
        int copy=count;
        if(root.left!=null){
            count++;
            findBottle(root.left,count);
            findBottle(root.right,count);
        }
        if(root.right!=null){
            copy++;
            findBottle(root.left,copy);
            findBottle(root.right,copy);
        }
        count++;
        if(count>bestC)
           bestC=count;

    }
    
    
    
    public int judgeOneN(TreeNode root){
    	if(root.left==null)return 1;
    	if(root.right==null)return 2;
    	return 0;
    }
    public TreeNode findOther(TreeNode root){
    	if(judgeOneN(root)==2)return root.left;
    	if(judgeOneN(root)==1)return root.right;
    	return null;
    }
    public boolean judgeOneGeneric(TreeNode root){
        if(root.left==null&&root.right==null)
            return true;
        else 
            return false;
    }

}
