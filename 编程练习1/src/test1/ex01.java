package test1;

import java.util.ArrayList;

public class ex01 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
    	if(root==null)return arr;
    	ArrayList<Integer> a1=new ArrayList<Integer>();
    	int sum=0;
    	findTreePath(root,arr,target,a1,sum);
    	return arr;
    }

	private void findTreePath(TreeNode root,ArrayList<ArrayList<Integer>> arr, int target,
			ArrayList<Integer> a1,int sum) {
		if(root==null)return;
		
		sum+=root.val;
		if(root.left==null&&root.right==null){
			if(sum==target){
				a1.add(root.val);
				arr.add(a1);
				a1.remove(a1.size()-1);
			}
		}
		a1.add(root.val);
		findTreePath(root.left,arr,target,a1,sum);
		findTreePath(root.right,arr,target,a1,sum);
		a1.remove(a1.size()-1);
		
		
	}
	public static void main(String[] args) {
		ex01 e=new ex01();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(2);
		
		System.out.println(e.FindPath(root, 3).get(0));
	}

}
