package lc;

public class RemoveNodeinBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.right=n2;
		n2.right=n3;
		n3.right=n4;
		n4.right=n5;
		RemoveNodeinBinarySearchTree q = new RemoveNodeinBinarySearchTree();
		q.removeNode(n1, 3);
	}
	
    public TreeNode removeNode(TreeNode root, int value) {
    	if(root == null){
    		return null;
    	}
    	
    	boolean exist = false;
    	TreeNode cur = root;
    	TreeNode parent = null;
    	boolean isLeftChild = false;
    	while(cur!=null){
    		if(cur.val == value){
    			exist = true;
    			break;
    		} else if (cur.val > value){
    			parent = cur;
    			isLeftChild = true;
    			cur = cur.left;
    		} else if(cur.val < value){
    			parent = cur;
    			isLeftChild = false;
    			cur = cur.right;
    		}
    	}
    	
    	if(exist){
    		if(cur.left == null && cur.right == null){
    			if(parent == null){
    				return null;
    			}
    			if(isLeftChild){
    				parent.left = null;
    			} else {
    				parent.right = null;
    			}
    		} else if(cur.left == null){
    			TreeNode rightmin = cur.right;
    			TreeNode rightminparent = cur;
    			while(rightmin.left!=null){
    				rightminparent = rightmin;
    				rightmin = rightmin.left;
    			}
    			cur.val = rightmin.val;
    			if(rightminparent.left!=null && rightminparent.left.val == rightmin.val){
    				rightminparent.left = rightmin.right;
    			} else {
    				rightminparent.right = rightmin.right;
    			}
    		} else {
    			TreeNode leftmax = cur.left;
    			TreeNode leftmaxparent = cur;
    			while(leftmax.right!=null){
    				leftmaxparent = leftmax;
    				leftmax = leftmax.right;
    			}
    			cur.val = leftmax.val;
    			if(leftmaxparent.left!=null && leftmaxparent.left.val == leftmax.val){
    				leftmaxparent.left = leftmax.left;
    			} else {
    				leftmaxparent.right = leftmax.left;
    			}
    		}
    	}
    	return root;
    }
}
