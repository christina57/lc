package lc;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur3 = dummy;
        int carry = 0;
        
        while(cur1 != null || cur2 != null){
        	int sum = (cur1==null?0:cur1.val) + (cur2==null?0:cur2.val) + carry;
        	carry = sum/10;
        	cur3.next = new ListNode(sum%10);
        	cur1 = (cur1==null?null:cur1.next);
        	cur2 = (cur2==null?null:cur2.next);
        	cur3 = cur3.next;
        }
        if(carry != 0){
        	cur3.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
