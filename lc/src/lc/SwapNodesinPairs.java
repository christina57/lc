package lc;

public class SwapNodesinPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode p1 = head;
        ListNode post = head;
        
        while(p1 != null && p1.next !=null){
        	post = p1.next.next;
        	pre.next = p1.next;
        	p1.next.next = p1;
        	p1.next = post;
        	
        	pre = p1;
        	p1 = p1.next;
        }
        return dummy.next;
    }
}
