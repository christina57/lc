package lc;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaximumPathSum q = new BinaryTreeMaximumPathSum();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left=n2;
		n1.right=n3;
		System.out.println(q.maxPathSum(n1));
	}
    public int maxPathSum(TreeNode root) {
    	if(root == null){
    		return 0;
    	}
    	returnType result = maxPathSumHelpr(root);
    	return result.maxsum;
    }
    
    private returnType maxPathSumHelpr(TreeNode root){
    	returnType result = new returnType(0,0);
    	if(root.left==null && root.right==null){
    		result.maxsum=root.val;
    		result.maxsumfromroot=root.val;
    	} else {
    		returnType result1,result2;
    		
    		if(root.left != null && root.right != null){
    			result1 = maxPathSumHelpr(root.left);
    			result2 = maxPathSumHelpr(root.right);
    			result.maxsumfromroot = Math.max(Math.max(result1.maxsumfromroot, result2.maxsumfromroot), 0)+root.val;
    			result.maxsum = Math.max( Math.max(result1.maxsum, result2.maxsum), Math.max(result1.maxsumfromroot+result2.maxsumfromroot+root.val,result.maxsumfromroot));	
    		}
    		else if(root.left != null){
    			result1 = maxPathSumHelpr(root.left);
    			result.maxsumfromroot = Math.max(result1.maxsumfromroot, 0) +root.val;
    			result.maxsum = Math.max(result1.maxsum, result.maxsumfromroot);
    			
    		}
    		else if(root.right != null){
    			result2 = maxPathSumHelpr(root.right);
    			result.maxsumfromroot = Math.max(result2.maxsumfromroot, 0) +root.val;
    			result.maxsum = Math.max(result2.maxsum, result.maxsumfromroot);
    			
    		}
    	}
    	return result;
    }
    
    class returnType{
    	int maxsumfromroot;
    	int maxsum;
    	returnType(int maxsumfromroot, int maxsum) { this.maxsumfromroot = maxsumfromroot; this.maxsum = maxsum;}
    }
}
