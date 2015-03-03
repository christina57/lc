package lc;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        int size = lists.size();
        ListNode[] ptrs = new ListNode[size];
        PriorityQueue<ListNode> minheap = new PriorityQueue<ListNode>(10, new Comparator<ListNode>(){
    		@Override
    		public int compare(ListNode node1, ListNode node2){
    			return node1.val - node2.val;
    		}
    	});
        
        for(int i=0; i<size;i++){
        	ptrs[i] = lists.get(i);
        	if(ptrs[i]!= null){
        		minheap.add(ptrs[i]);
        	}
    	}
        
        ListNode minnode;
        
        while(minheap.size()>0){
        	minnode = minheap.poll();
        	cur.next = minnode;
        	cur = cur.next;
        	if(minnode.next != null){
        		minheap.add(minnode.next);
        	}
        }
        return dummy.next;
    }
}
