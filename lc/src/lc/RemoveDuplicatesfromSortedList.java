package lc;

import lc.RemoveNthNodeFromEndofList.ListNode;

public class RemoveDuplicatesfromSortedList {

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
        ListNode cur = head;
        
        while( cur!= null && cur.next != null){
        	if(cur.next.val == cur.val){
        		cur.next = cur.next.next;	
        	} else {
        		cur = cur.next;
        	}
        }
        
        return head;
    }

}
