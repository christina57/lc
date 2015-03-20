package lc;

import java.util.LinkedList;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        
        for(int i=0;i<s.length();i++){
        	char c = s.charAt(i);
        	if(c == '(' || c == '{' || c == '['){
        		stack.add(c);
        	} else if(c == ')'){
        		if(!stack.isEmpty() && stack.getLast()=='('){
        			stack.removeLast();
        		} else {
        			return false;
        		}
        	} else if(c == '}'){
        		if(!stack.isEmpty() && stack.getLast()=='{'){
        			stack.removeLast();
        		} else {
        			return false;
        		}
        	}  else if(c == ']'){
        		if(!stack.isEmpty() && stack.getLast()=='['){
        			stack.removeLast();
        		} else {
        			return false;
        		}
        	}  else {
        		return false;
        	}
        }
        
        if(stack.isEmpty()){
        	return true;
        }
        return false;
    }
}
