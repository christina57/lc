package lc;

public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean hasCycle(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        
        while(ptr2!=null && ptr2.next!=null && ptr2.next.next!=null){
        	ptr1 = ptr1.next;
        	ptr2 = ptr2.next.next;
        	
        	if(ptr1 == ptr2){
        		return true;
        	}
        }
        return false;
    }
}

