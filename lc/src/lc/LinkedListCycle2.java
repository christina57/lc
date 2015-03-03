package lc;

public class LinkedListCycle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ListNode detectCycle(ListNode head) {
    	ListNode ptr1 = head;
        ListNode ptr2 = head;
        int circle = 0;
        int total = 0;
        boolean hasCycle = false;
        
        while(ptr2!=null && ptr2.next!=null && ptr2.next.next!=null){
        	ptr1 = ptr1.next;
        	ptr2 = ptr2.next.next;
        	circle++;
        	
        	if(ptr1 == ptr2){
        		hasCycle = true;
        		break;
        	}
        }
        
        if(!hasCycle){
        	return null;
        }
        
        ListNode ptr3 = head;
        while(ptr1 != ptr3){
        	ptr1 = ptr1.next;
        	ptr3 = ptr3.next;
        }
        
        return ptr3;
    }
}
