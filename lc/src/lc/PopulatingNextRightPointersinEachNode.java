package lc;

public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public void connect(TreeLinkNode root) {
    	if(root == null){
    		return;
    	}
    	if(root.left != null){
    		root.left.next = root.right;
    		if(root.next != null && root.next.left != null){
    			root.right.next = root.next.left;
    		}
    		connect(root.left);
        	connect(root.right);
    	}
    }
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}
