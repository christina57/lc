package lc;

public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode sortList(ListNode head) {
    	if(head == null){
    		return null;
    	}
    	if(head.next == null){
    		return head;
    	}
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast != null && fast.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode head1 = sortList(head);
        head2 = sortList(head2);
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode cur = dummy;
        
        while(cur1 != null && cur2 != null){
        	if(cur1.val<cur2.val){
        		cur.next = cur1;
        		cur = cur.next;
        		cur1 = cur1.next;
        		cur.next = null;
        	} else {
        		cur.next = cur2;
        		cur = cur.next;
        		cur2 = cur2.next;
        		cur.next = null;
        	}
        }
        if(cur1 != null){
        	cur.next = cur1;
        }
        if(cur2 != null){
        	cur.next = cur2;
        }
        return dummy.next;
    }
}
