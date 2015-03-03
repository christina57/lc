package lc;

import lc.RemoveDuplicatesfromSortedList.ListNode;

public class RemoveDuplicatesfromSortedList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class ListNode {
		int val;
		ListNode next;
	    ListNode(int x) {
	    	val = x;
	    	next = null;
		}
	}
	
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null){
    		return null;
    	}
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre = dummy;
        ListNode cur = head;
        int value = cur.val;
        int count =0;
        
        while( cur!= null){
        	if(cur.val == value){
        		count++;
        		cur = cur.next;
        	} else {
        		if(count>1){
        			pre.next = cur;
        			value = cur.val;
        			count = 0;
        		} else {
        			pre = pre.next;
        			value = cur.val;
        			count = 0;
        		}
        	}
        	
        }
        
        if(count>1){
			pre.next = cur;
		}
        
        return dummy.next;
    }
}
