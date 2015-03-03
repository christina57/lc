package lc;

public class ReverseNodesinkGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		ListNode head2 = reverseKGroup(l1, 2);
		while(head2 != null){
			System.out.print(head2.val + ",");
			head2 = head2.next;
		}
		
	}
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        
        int count =1;
        int order =0;
        while(cur != null){
        	if(count == k){
        		cur = cur.next;
        		dummy.next = reverseBetween(dummy.next, order*k+1, (order+1)*k);
        		count =  1;
        		order++;
        	} else {
        		cur = cur.next;
        		count ++;
        	}
        }
        return dummy.next;
    }
    
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode cur = head;
        ListNode pre = dummy;
        
        for(int i=1; i<m; i++){
        	cur = cur.next;
        	pre = pre.next;
        }
        
        ListNode post = null;
        for(int i=0; i<(n-m); i++){
        	if(cur.next != null){
        		post = cur.next.next;
        	}
        	cur.next.next = pre.next;
        	pre.next = cur.next;
        	cur.next = post;
        }
        
        return dummy.next;
    }

}
