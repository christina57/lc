package lc;

import java.util.LinkedList;
import java.util.List;

public class PathSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root == null){
        	return result;
        }
        List<Integer> item = new LinkedList<Integer>();
        
        helper(result, item, root, sum);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> item, TreeNode root, int sum){
    	if(root==null){
    		return;
    	}
    	
    	int subsum = sum - root.val;
    	
    	if(subsum==0 && root.left == null && root.right == null){
    		item.add(root.val);
    		List<Integer> newitem = new LinkedList<Integer>(item);
    		result.add(newitem);
    		item.remove(item.size()-1);
    	} else {
    		item.add(root.val);
    		helper(result, item, root.left, subsum);
    		helper(result, item, root.right, subsum);
    		item.remove(item.size()-1);
    	}
    }
}
