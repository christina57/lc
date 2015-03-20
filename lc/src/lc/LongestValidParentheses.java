package lc;

import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int longestValidParentheses(String s) {
        if(s==null || s.length()==0){
        	return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0;i<s.length();i++){
        	char c = s.charAt(i);
        	if(c == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '('){
        		stack.pop();
        	} else {
        		stack.push(i);
        	}
        }
        
        int max =0;
        stack.push(s.length());
        int cur = 0;
        while(!stack.isEmpty()){
        	cur = stack.pop();
        	if(!stack.isEmpty()){
        		int pre = stack.peek();
        		max = Math.max(max, cur-pre-1);
        	}
        }
        max = Math.max(max, cur);
        return max;
    }
}
