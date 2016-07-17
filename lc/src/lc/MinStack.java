package lc;

import java.util.LinkedList;

class MinStack {

	private Stack<Integer> s;
	private int min;

	/** initialize your data structure here. */
	public MinStack() {
		s = new Stack<Integer>();
		min = Integer.MAX_VALUE;
	}

	public void push(int x) {
		if(x <= min){
			s.push(min);
			min = x;
		}
		s.push(x);
	}

	public void pop() {
		if(s.peek() == min){
			s.pop();
			min = s.pop();
		} else {
			s.pop();
		}
	}

	public int top() {
		return (int)s.peek();
	}

	public int getMin() {
		return min;
	}
}

