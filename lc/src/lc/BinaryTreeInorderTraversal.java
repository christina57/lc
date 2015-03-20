package lc;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode n3 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		n3.left = n1;
		n1.right = n2;
		List<Integer> result = inorderTraversal(n3);
		for(Integer i:result){
			System.out.println(i);
		}
	}
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if(root == null){
        	return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        boolean goLeft =true;
        stack.push(root);
        
        while(!stack.isEmpty()){
        	TreeNode cur = stack.peek();
        	
        	if(goLeft){
	        	while(cur.left != null){
	        		stack.push(cur.left);
	        		cur = cur.left;
	        	} 
        	}

        	cur = stack.pop();
    		result.add(cur.val);
    		if(cur.right!=null){
    			stack.push(cur.right);
    			goLeft=true;
    		} else {
    			goLeft=false;
    		}
        }
        
        return result;
    }
}
