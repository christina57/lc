package lc;

import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len<2){
            return 0;
        }
        int result = 0;

        Stack<Integer> idx = new Stack<Integer>();
        idx.push(-1);

        for(int i=0;i<len;i++){
            if(s.charAt(i) == '('){
                idx.push(i);
            } else {
                if(idx.size()>1 && s.charAt(idx.peek()) == '('){
                    idx.pop();
                    result = Math.max(result, i - idx.peek());
                } else {
                    idx.push(i);
                }
            }
        }
        return result;
    }
}
