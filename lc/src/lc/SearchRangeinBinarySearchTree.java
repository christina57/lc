package lc;

import java.util.ArrayList;

public class SearchRangeinBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
        	return result;
        }
        boolean goLeft = false;
        boolean goRight = false;
        boolean includeRoot = false;
        
        if(root.val<k2 && root.val>k1){
        	goLeft = true;
        	goRight = true;
        	includeRoot = true;
        } else if (root.val<k1){
        	goRight = true;
        } else if(root.val==k1){
        	goRight = true;
        	includeRoot = true;
        } else if(root.val>k2){
        	goLeft = true;
        } else if(root.val==k2){
        	goLeft = true;
        	includeRoot = true;
        }
        
        ArrayList<Integer> left =null, right = null;
        
        if(root.left!=null && goLeft){
    		left = searchRange(root.left, k1, k2);
    	}
    	if(root.right!=null && goRight){
    		right = searchRange(root.right, k1, k2);
    	}
    	
    	if(left!=null){
    		result.addAll(left);
    	}
    	if(includeRoot){
    		result.add(root.val);
    	}
    	if(right!=null){
    		result.addAll(right);
    	}
		
    	return result;
    }
}
