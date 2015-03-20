package lc;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    public boolean isValidBST(TreeNode root) {
        if(root == null){
        	return true;
        }
        return isValidBSTHelper(root).isValid;
    }
    
    private returnType isValidBSTHelper(TreeNode root){
    	returnType result = new returnType(false, Integer.MAX_VALUE, Integer.MIN_VALUE);
    	boolean minset = false;
    	boolean maxset = false;
    	
    	if(root.left!=null){
    		returnType left = isValidBSTHelper(root.left);
    		if(!left.isValid || left.max>=root.val){
    			return result;
    		}
    		result.min = left.min;
    		minset = true;
    	}
    	if(root.right!=null){
    		returnType right = isValidBSTHelper(root.right);
    		if(!right.isValid || right.min<=root.val){
    			return result;
    		}
    		result.max = right.max;
    		maxset = true;
    	}
    	result.isValid = true;
    	if(!minset){
    		result.min = root.val;
    	}
    	if(!maxset){
    		result.max = root.val;
    	}
    	return result;
    }
    
    class returnType{
    	int min;
    	int max;
    	boolean isValid;
    	returnType(boolean isValid, int max, int min){this.isValid=isValid; this.max=max; this.min=min;}
    }
}
