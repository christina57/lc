package lc;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<TreeNode> generateTrees(int n) {
    	
    	return helper(1, n);
    }
    
    private ArrayList<TreeNode> helper(int start, int end){
    	ArrayList<TreeNode> result = new ArrayList<TreeNode>();
    	
    	if(end<start){
    		result.add(null); //【注】加入一个空元素进去，来表示这是一颗空树，并且同时也是保证下面循环时，即使一边是空树，也让另一边继续运算。
			return result;
    	}
    	
    	for(int i = start; i<=end; i++){
    		
    		ArrayList<TreeNode> lefts = helper(start, i-1);
    		ArrayList<TreeNode> rights = helper(i+1, end);
    		
    		for(int k=0;k<lefts.size();k++){
    			for(int q=0;q<rights.size();q++){
    				TreeNode head = new TreeNode(i);
    				head.left = lefts.get(k);
    				head.right = rights.get(q);
    				result.add(head);
    			}
			}
    	}
    	return result;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; left = null; right = null; }
}
