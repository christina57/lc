package lc;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		//ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		//l5.next = l6;
		reorderList(l1);
		while (l1 != null){
			System.out.print(l1.val + ",");
			l1 = l1.next;
		}
	}
	
    public static void reorderList(ListNode head) {
    	if(head == null || head.next == null){
    		return;
    	}
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode ptr1 = dummy;
        ListNode ptr2 = dummy;
        
        while(ptr2.next!= null && ptr2.next.next != null){
        	ptr1 = ptr1.next;
        	ptr2 = ptr2.next.next;
        }
        ListNode pre = ptr1;
        ptr1 = ptr1.next;
        if(ptr2.next != null){
        	ptr1 = ptr1.next;
        	pre = pre.next;
        }
        
        ListNode post = null;
        while(ptr1.next != null){
        	post = ptr1.next.next;
        	ptr1.next.next = pre.next;
        	pre.next = ptr1.next;
        	ptr1.next = post;
        }
        
        ListNode l1 = head;
        while (l1 != null){
			System.out.print(l1.val + ",");
			l1 = l1.next;
		}
        System.out.print("\n");
        
        ptr1 = head;
        ptr2 = pre.next;
        pre.next = null;
        ListNode temp1, temp2;
        
        while(ptr2 != null){
        	temp1 = ptr1.next;
        	temp2 = ptr2.next;
        	ptr1.next = ptr2;
        	ptr2.next = temp1;
        	ptr1 = temp1;
        	ptr2 = temp2;
        }
        
    }
}
