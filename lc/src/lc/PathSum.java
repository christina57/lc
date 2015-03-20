package lc;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null){
    		return false;
    	} 
    	
    	if((sum - root.val)==0 && root.left == null && root.right == null){
    		return true;
    	} else {
    		return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    	}
    }
}
