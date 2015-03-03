package lc;

public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		l1.next = l2;
		ListNode newHead = partition(l1, 2);
		while(newHead != null){
			System.out.print(newHead.val + ",");
			newHead = newHead.next;
		}
	}
	
    public static ListNode partition(ListNode head, int x) {
    	if(head == null){
    		return null;
    	}
    	
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        
        ListNode cur = head;
        ListNode ptr1 = dummy1;
        ListNode ptr2 = dummy2;
        
        while( cur != null){
        	if(cur.val<x){
        		ptr1.next = cur;
        		ptr1 = ptr1.next;
        	} else {
        		ptr2.next = cur;
        		ptr2 = ptr2.next;
        	}
        	cur = cur.next;
        }
        
        ptr2.next = null;
        ptr1.next = dummy2.next;
        return dummy1.next;
    }
}

class ListNode {
	int val;
	ListNode next;
    ListNode(int x) {
    	val = x;
    	next = null;
	}
}
