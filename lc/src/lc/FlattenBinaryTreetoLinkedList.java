package lc;

import java.util.LinkedList;

public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		FlattenBinaryTreetoLinkedList q = new FlattenBinaryTreetoLinkedList();
		q.flatten(root);
		
	}
    public void flatten(TreeNode root) {
    	flattenHelper(root);
    }
    
    private TreeNode flattenHelper(TreeNode root){
    	if(root == null){
    		return null;
    	}
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	root.left = null;
    	root.right = left;
    	
    	TreeNode last1 = flattenHelper(left);
    	if(last1 == null){
    		last1 = root;
    	}
    	last1.left = null;
    	last1.right = right;
    	
    	TreeNode last2 = flattenHelper(right);
    	if(last2 == null){
    		last2 = last1;
    	}
    	
    	return last2;
    }
}
