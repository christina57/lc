package lc;

import java.util.LinkedList;

public class ImplementIteratorofBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private TreeNode cur;
	boolean goLeft = true;
	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	
    //@param root: The root of binary tree.
    public ImplementIteratorofBinarySearchTree(TreeNode root) {
        cur = root;
        if(cur!=null){
        	stack.push(cur);
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
    	if(stack.isEmpty()){
    		return null;
    	}
    	cur = stack.peek();
        if(goLeft){
        	while(cur.left!=null){
        		cur = cur.left;
            	stack.push(cur);
        	}
        }
        
        cur = stack.pop();
        
		if(cur.right!=null){
			stack.push(cur.right);
			goLeft=true;
		} else {
			goLeft=false;
		}
        return cur;
    }
}
