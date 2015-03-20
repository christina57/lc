package lc;

import java.util.HashMap;

public class CopyListwithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        while(cur!=null){
        	RandomListNode newcur = new RandomListNode(cur.label);
        	newcur.random = cur.random;
        	pre.next = newcur;
        	pre = newcur;
        	map.put(cur, newcur);
        	cur = cur.next;
        }
        
        RandomListNode newcur = dummy.next;
        while(newcur!=null){
        	newcur.random = map.get(newcur.random);
        	newcur = newcur.next;
        }
        return dummy.next;
    }
}


class RandomListNode {
	 int label;
	 RandomListNode next, random;
	 RandomListNode(int x) { this.label = x; }
};