package lc;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {
    
	private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
	private DoubleLinkedList queue = new DoubleLinkedList(new DoubleLinkedListNode(0, 0), new DoubleLinkedListNode(0, 0));
	private int size = 0;
	private int capacity = 0;
	
    public LRUCache(int capacity) {
    	this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        	DoubleLinkedListNode cur = map.get(key);
        	if(queue.head.next != cur){
        		queue.remove(cur);
        		queue.insert(queue.head, cur);
        	}
        	return cur.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
        	DoubleLinkedListNode cur = map.get(key);
        	cur.value = value;
        	queue.remove(cur);
        	queue.insert(queue.head, cur);
        }
        else {
        	if(size<capacity){
        		size++;
        	}
        	else {
        		DoubleLinkedListNode leastused = queue.tail.prev;
        		queue.remove(leastused);
        		map.remove(leastused.key);
        	}
        	DoubleLinkedListNode cur = new DoubleLinkedListNode(key, value);
    		map.put(key, cur);
    		queue.insert(queue.head, cur);
        }
    }
}

class DoubleLinkedList{
	DoubleLinkedListNode head, tail;
	DoubleLinkedList(DoubleLinkedListNode head, DoubleLinkedListNode tail){
		this.head = head;
		this.tail = tail;
		head.next = tail;
		tail.prev = head;
	}
	public void remove(DoubleLinkedListNode cur){
		DoubleLinkedListNode pre = cur.prev;
    	DoubleLinkedListNode next = cur.next;
    	pre.next= next;
    	next.prev = pre;
	}
	
	public void insert(DoubleLinkedListNode before, DoubleLinkedListNode cur){
		DoubleLinkedListNode after = before.next;
    	before.next = cur;
    	after.prev = cur;
    	cur.next = after;
    	cur.prev = before;
	}
}

class DoubleLinkedListNode{
	int key, value;
	DoubleLinkedListNode prev, next;
	DoubleLinkedListNode(int k, int v){
		key = k;
		value = v;
	}
}
