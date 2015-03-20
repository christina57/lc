package lc;

public class SumRoottoLeafNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int sumNumbers(TreeNode root) {
    	if(root == null){
    		return 0;
    	}
    	TreeNode result = new TreeNode(0);
    	TreeNode item = new TreeNode(0);
    	helper(result, item, root);
    	return result.val;
    }
    
    private void helper(TreeNode result, TreeNode item, TreeNode root){
    	if(root==null){
    		return;
    	}
    	if(root.left == null && root.right == null){
    		result.val += (item.val*10+root.val);
    	} else {
    		item.val = item.val*10+root.val;
    		helper(result,item, root.left);
    		helper(result, item, root.right);
    		item.val  = (item.val-root.val)/10;
    	}
    }
}
