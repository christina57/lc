package lc;

public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode sortedArrayToBST(int[] num) {
    	if(num.length==0){
    		return null;
    	}
    	return helper(num, 0, num.length-1);
    }
    
    private TreeNode helper(int[] num, int begin, int end){
    	if(begin>end){
    		return null;
    	}
    	int idx = (begin+end)/2;
    	TreeNode root = new TreeNode(num[idx]);
    	root.left = helper(num, begin, idx-1);
    	root.right = helper(num, idx+1, end);
    	return root;
    }
}
