package lc;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length==0){
        	return null;
        }
        return buildHelper(preorder, inorder, 0, 0, preorder.length);
    }
    
    private TreeNode buildHelper(int[] preorder, int[] inorder, int begin1, int begin2, int len){
    	if(len == 1){
    		return new TreeNode(preorder[begin1]);
    	}
    	
    	TreeNode root = new TreeNode(preorder[begin1]);
    	int i;
    	for(i=begin2;i<(begin2+len);i++){
    		if(inorder[i] == preorder[begin1]){
    			break;
    		}
    	}
    	if(i-1>=begin2){
    		root.left = buildHelper(preorder, inorder, begin1+1, begin2, i-begin2);
    	}
    	if((begin2+len-1)>=i+1){
    		root.right = buildHelper(preorder, inorder, begin1-begin2+i+1, i+1, begin2+len-1-i);
    	}
    	return root;
    }
    
    
}
