package lc;

import java.util.LinkedList;

public class BSTIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(1);
		BSTIterator q = new BSTIterator(a);
		System.out.println(q.next());
	}
	
	private LinkedList<TreeNode> path;
	private int size = 0;
    public BSTIterator(TreeNode root) {
    	path = new LinkedList<TreeNode>();
    	TreeNode cur = root;
    	while(cur != null){
    		path.addFirst(cur);
    		cur = cur.left;
    		size ++;
    	}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(size != 0){
        	return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
    	if(size != 0){
    		TreeNode cur = path.removeFirst();
    		size --;
            if(cur.right != null){
            	TreeNode tmp = cur.right;
            	while(tmp != null){
            		path.addFirst(tmp);
            		tmp = tmp.left;
            		size ++;
            	}
            }
            
        	return cur.val;
    	} else {
    		return -1;
    	}        
    }

	/**
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
}
