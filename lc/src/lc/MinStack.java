package lc;

import java.util.LinkedList;

class MinStack {
	
	private LinkedList<Integer> stack = new LinkedList<Integer>();
	private LinkedList<Integer> minstack = new LinkedList<Integer>();
	
    public void push(int x) {
    	stack.add(x);
    	if(minstack.isEmpty() || x <= minstack.getLast()){
    		minstack.add(x);
    	}
    }

    public void pop() {
    	if(stack.isEmpty()){
    		return;
    	}
        int num = stack.removeLast();
        if(minstack.getLast() == num){
        	minstack.removeLast();
        }
    }

    public int top() {
    	if(stack.isEmpty()){
    		return Integer.MIN_VALUE;
    	}
        return stack.getLast();
    }

    public int getMin() {
    	if(minstack.isEmpty()){
    		return Integer.MIN_VALUE;
    	}
        return minstack.getLast();
    }
}

