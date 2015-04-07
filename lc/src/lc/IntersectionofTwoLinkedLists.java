package lc;

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1=0;
        ListNode cur1 = headA;
        while(cur1 != null){
        	cur1 = cur1.next;
        	len1++;
        }
        
        int len2=0;
        ListNode cur2 = headB;
        while(cur2 != null){
        	cur2 = cur2.next;
        	len2++;
        }
        
        cur1 = headA;
        cur2 = headB;
        int diff = Math.abs(len1-len2);
        
        if(len1>=len2){
        	for(int i=0;i<diff;i++){
            	cur1 = cur1.next;
            }
        } else {
        	for(int i=0;i<diff;i++){
            	cur2 = cur2.next;
            }
        }
        
        while(cur1 != null){
        	if(cur1 == cur2){
        		return cur1;
        	} else {
        		cur1 = cur1.next;
        		cur2 = cur2.next;
        	}
        }
        return null;
    }
}
