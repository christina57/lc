package lc;

public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int maxDepth(TreeNode root) {
    	if(root == null){
    		return 0;
    	}
    	int left =0;
    	if(root.left != null){
    		left = maxDepth(root.left);
    	}
    	int right =0;
    	if(root.right != null){
    		right = maxDepth(root.right);
    	}
        return Math.max(left, right)+1;
    }
}
