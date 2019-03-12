package test;

import java.util.ArrayList;


   class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

public class ex4 {
	
	
	    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	    	if(listNode==null)return null;
	        ArrayList<Integer> lst=new ArrayList<Integer>();
	        ArrayList<Integer> rlst=new ArrayList<Integer>();
	        ListNode p=listNode;
	        while(true){

	        	lst.add(p.val);
	        	p=p.next;
	        	if(p==null)break;
	        }
	        for (int i = lst.size()-1; i >= 0; i--) {
				rlst.add(lst.get(i));
			}
	        return rlst;
	    }
    
    public static void main(String[] args) {
    	ex4 e = new ex4();
    	ListNode one=new ListNode(3);
    	ListNode two=new ListNode(4);
    	one.next=two;
    	System.out.println(e.printListFromTailToHead(one));
    }

}
