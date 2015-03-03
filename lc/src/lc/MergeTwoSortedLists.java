package lc;

public class MergeTwoSortedLists {

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
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        
        
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while(cur1!=null && cur2!=null){
        	if(cur1.val<=cur2.val){
        		ListNode cur3 = new ListNode(cur1.val);
        		pre.next = cur3;
        		pre = cur3;
        		cur1 = cur1.next;
        	} else {
        		ListNode cur3 = new ListNode(cur2.val);
        		pre.next = cur3;
        		pre = cur3;
        		cur2 = cur2.next;
        	}
        }
        
        if(cur1!=null){
        	while(cur1!=null){
        		ListNode cur3 = new ListNode(cur1.val);
        		pre.next = cur3;
        		pre = cur3;
        		cur1 = cur1.next;
        	}
        }
        
        if(cur2!=null){
        	while(cur2!=null){
        		ListNode cur3 = new ListNode(cur2.val);
        		pre.next = cur3;
        		pre = cur3;
        		cur2 = cur2.next;
        	}
        }
        return head.next;
    }
}
