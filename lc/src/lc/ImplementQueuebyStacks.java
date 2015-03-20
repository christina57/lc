package lc;

import java.util.Stack;

public class ImplementQueuebyStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueuebyStacks() {
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        if(stack2.isEmpty()){
        	while(!stack1.isEmpty()){
        		stack2.push(stack1.pop());
        	}
        }
        return stack2.pop();
    }

    public int top() {
    	if(stack2.isEmpty()){
        	while(!stack1.isEmpty()){
        		stack2.push(stack1.pop());
        	}
        }
        return stack2.peek();
    }
}
