package lc;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
    	if(root == null || root == A || root == B){
    		return root;
    	}
    	TreeNode left = lowestCommonAncestor(root.left, A, B);
    	TreeNode right = lowestCommonAncestor(root.right, A, B);
    	if (left != null && right != null) { //【注】即，left和right分别对应的是A和B(或B和A)，也就是找到了最小公共祖先
    		return root;
    	}
    	if (left != null) { //即AB都在左子树（即right == null）
    		return left;
    	}
    	if (right != null) { //即AB都在右子树（即left == null）
    		return right;
    	} 
    	return null; // 两个子树都没有 A和B的LCA，则返回null
    }
}
