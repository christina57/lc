package lc;

import java.util.Stack;

public class MaxTree {
	public static void main(String[] args){
		int[] A = {2,5,6,0,3,1};
		maxTree(A);
	}
	
    public static TreeNode maxTree(int[] A) {
        if(A==null || A.length==0){
        	return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode terminator = new TreeNode(Integer.MAX_VALUE);
        
        for(int i=0;i<=A.length;i++){
        	TreeNode cur;
        	if(i== A.length){
        		cur = terminator;
        	} else {
        		cur = new TreeNode(A[i]);
        	}
        	while(!stack.isEmpty() && cur.val >stack.peek().val){
        		TreeNode pre = stack.pop();
        		if(stack.isEmpty()){
        			cur.left=pre;
        		} else {
        			if(stack.peek().val > cur.val){
        				cur.left = pre;
        			} else {
        				stack.peek().right = pre;
        			}
        		}
        	}
        	stack.push(cur);
        }
        
        return terminator.left;
    }
}
