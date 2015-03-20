package lc;

import java.util.ArrayList;

public class ConvertSortedListtoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null){
			return null;
		}
		return helper(head);
	}
	
	private TreeNode helper(ListNode head){
		ListNode preslow = null;
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next!=null && fast.next.next!=null){
			preslow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		TreeNode root = new TreeNode(slow.val);
		
		if(preslow != null){
			preslow.next = null;
			root.left = helper(head); 
		}
		
		if(slow.next != null){
			ListNode secondhead = slow.next;
			root.right = helper(secondhead);
		}
		return root;
	}
	
    public TreeNode sortedListToBST2(ListNode head) {
    	if(head==null){
    		return null;
    	}
    	ArrayList<Integer> num = new ArrayList<Integer>();
        ListNode cur = head;
        while(cur!=null){
        	num.add(cur.val);
        	cur = cur.next;
        }
        
    	return helper(num, 0, num.size()-1);
    }
    
    private TreeNode helper(ArrayList<Integer> num, int begin, int end){
    	if(begin>end){
    		return null;
    	}
    	int idx = (begin+end)/2;
    	TreeNode root = new TreeNode(num.get(idx));
    	root.left = helper(num, begin, idx-1);
    	root.right = helper(num, idx+1, end);
    	return root;
    }
}
