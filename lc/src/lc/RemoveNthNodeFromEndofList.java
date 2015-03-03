package lc;

import lc.MergeTwoSortedLists.ListNode;

public class RemoveNthNodeFromEndofList {

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
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
        ListNode ptr1 = head;
        
        for(int i=1;i<n;i++){
        	if(ptr1 != null){
        		ptr1 = ptr1.next;
        	} else {
        		return head;
        	}
        }
        ListNode ptr2 = head;
        ListNode pre = dummy;
        while(ptr1.next != null){
        	ptr1 = ptr1.next;
        	ptr2 = ptr2.next;
        	pre = pre.next;
        }
        
        pre.next = ptr2.next;
        
        return dummy.next;
        
    }
}
