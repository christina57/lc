package lc;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isBalanced(TreeNode root) {
    	returnType ret = isBalancedHelper(root);
    	return ret.balanced;
    }
    
    private returnType isBalancedHelper(TreeNode root){
    	if(root == null){
    		return new returnType(true, 0);
    	}
    	returnType left_ret, right_ret;
    	
    	if(root.left==null){
    		left_ret = new returnType(true, 0);
    	} else {
    		left_ret = isBalancedHelper(root.left);
    	}
    	if(root.right==null){
    		right_ret = new returnType(true, 0);
    	} else {
    		right_ret = isBalancedHelper(root.right);
    	}
    	
    	int diff = left_ret.height - right_ret.height;
    	if(diff<=1 && diff>=-1){
    		return new returnType((left_ret.balanced && right_ret.balanced), Math.max(left_ret.height, right_ret.height)+1);
    	} else {
    		return new returnType(false, Math.max(left_ret.height, right_ret.height)+1);
    	}
    }
    
    class returnType{
    	boolean balanced;
    	int height;
    	returnType(boolean balanced, int height) { this.balanced = balanced; this.height = height;}
    }
    
}