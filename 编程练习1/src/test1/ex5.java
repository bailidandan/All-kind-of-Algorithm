package test1;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class ex5 {
	public static void main(String[] args) {
		ex5 e=new ex5();
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		e.FindKthToTail(head, 1);
	}
	
	   public ListNode FindKthToTail(ListNode head,int k) {
	    	int total=getTotal(head);
	    	//System.out.println(total);
	        if(total<k)return null;
	    	ListNode node=getArtNode(head,total-k+1);
	        System.out.println(node.val);
	    	return node;
	    }

		private ListNode getArtNode(ListNode head, int place) {
			ListNode p=head;
			int i=0;
			for (; p!=null;p=p.next ) {
				i++;
				if(i==place)return p;
			}
			return null;
		}

		private int getTotal(ListNode head) {
	        if(head==null)return -1;
			ListNode p=head;
			int count=0;
			while(p!=null){
				count++;
				p=p.next;
			}
			return count;
			
		}
    
}
