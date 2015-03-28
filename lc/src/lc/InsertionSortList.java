package lc;

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l3.next = l2;
		l2.next = l1;
		
		ListNode head2 = insertionSortList(l3);
		while(head2 != null){
			System.out.print(head2.val + ",");
			head2 = head2.next;
		}
	}
    public static ListNode insertionSortList(ListNode head) {
    	if(head == null){
    		return null;
    	}
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        
    	while(cur != null){
    		ListNode compare = dummy;
    		boolean set = false;
    		while(compare.next != cur && compare.next != null){
    			if(compare.next.val>cur.val){
    				ListNode tmp1 = compare.next;
    				ListNode tmp2 = cur.next;
    				compare.next = cur;
    				cur.next = tmp1;
    				pre.next = tmp2;
    				cur = tmp2;
    				set = true;
    				break;
    			} else {
    				compare = compare.next;
    			}
    		}
    		if(!set){
    			pre = cur;
    			cur = cur.next;
    		}
    	}
    	return dummy.next;
    }
}
