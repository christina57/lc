package lc;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> result = new LinkedList<Integer>();
        if(root == null){
        	return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
        	TreeNode cur = stack.pop();
        	result.add(0, cur.val);
        	if(cur.left!=null){
        		stack.push(cur.left);
        	}
        	if(cur.right!=null){
        		stack.push(cur.right);
        	}
        }
        return result;
    }
}
