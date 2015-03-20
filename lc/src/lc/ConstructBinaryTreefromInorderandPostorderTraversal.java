package lc;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0){
        	return null;
        }
        return buildHelper(inorder, postorder, 0, 0, postorder.length);
    }
    
    private TreeNode buildHelper(int[] inorder, int[] postorder, int begin1, int begin2, int len){
    	if(len == 1){
    		return new TreeNode(inorder[begin1]);
    	}
    	
    	TreeNode root = new TreeNode(postorder[begin2+len-1]);
    	int i;
    	for(i=begin1;i<(begin1+len);i++){
    		if(inorder[i] == postorder[begin2+len-1]){
    			break;
    		}
    	}
    	if(i-1>=begin1){
    		root.left = buildHelper(inorder, postorder, begin1, begin2, i-begin1);
    	}
    	if((begin1+len-1)>=i+1){
    		root.right = buildHelper(inorder, postorder, i+1, begin2-begin1+i, begin1+len-1-i);
    	}
    	return root;
    }
}
