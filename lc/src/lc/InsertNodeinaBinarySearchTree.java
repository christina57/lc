package lc;

public class InsertNodeinaBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		if(root==null){
        	return node;
        }
		TreeNode cur = root;
		while(true){
			if(node.val > cur.val && cur.right != null){
	        	cur = cur.right;
	        } else if(node.val > cur.val){
	        	cur.right = node;
	        	break;
	        } else if(node.val < cur.val && cur.left != null){
	        	cur = cur.left;
	        } else if(node.val < cur.val){
	        	cur.left = node;
	        	break;
	        }
		}
		return root;
	}
	
	public TreeNode insertNode2(TreeNode root, TreeNode node) {
		if(root==null){
        	return node;
        }
		insertNodeHelper(root, node);
		return root;
	}
	
    private void insertNodeHelper(TreeNode root, TreeNode node) {
        if(node.val > root.val && root.right != null){
        	insertNode(root.right, node);
        } else if(node.val > root.val){
        	root.right = node;
        } else if(node.val < root.val && root.left != null){
        	insertNode(root.left, node);
        } else if(node.val < root.val){
        	root.left = node;
        }
    }
}
