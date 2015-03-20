package lc;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	if(root==null){
    		return result;
    	}
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level =0;
        
        while(queue.size()!=0){
        	List<Integer> line = new LinkedList<Integer>();
        	int cur_size = queue.size();
        	
        	for(int i=0;i<cur_size;i++){
        		TreeNode cur = queue.poll();
        		if(level%2==0){
        			line.add(cur.val);
        		} else {
        			line.add(0, cur.val);
        		}
        		if(cur.left!=null){
        			queue.add(cur.left);
        		}
        		if(cur.right!=null){
        			queue.add(cur.right);
        		}
        	}
        	level++;
        	result.add(line);
        }
        return result;
    }
}
