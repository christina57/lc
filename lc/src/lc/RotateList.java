package lc;

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		l1.next = l2;
		
		ListNode head = rotateRight(l1, 1);
		while (head != null){
			System.out.print(head.val + ",");
			head = head.next;
		}
	}
	
    public static ListNode rotateRight(ListNode head, int n) {
    	if(head == null){
    		return null;
    	}
    	
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        
        int len =0;
        
        while(ptr1 != null){
        	ptr1 = ptr1.next;
        	len++;
        }
        
        int bias = n%len;
        
        if(bias == 0){
        	return head;
        }
        
        ptr1 = head;
        
        for(int i=1;i<bias;i++){
        	ptr1 = ptr1.next;
        }
        
        while(ptr1.next != null){
        	ptr1 = ptr1.next;
        	ptr2 = ptr2.next;
        	pre = pre.next;
        }
        
        dummy.next = ptr2;
        ptr1.next = head;
        pre.next = null;
        return dummy.next;
    }
}
