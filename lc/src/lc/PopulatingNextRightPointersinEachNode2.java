package lc;

public class PopulatingNextRightPointersinEachNode2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PopulatingNextRightPointersinEachNode2 s = new PopulatingNextRightPointersinEachNode2();
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(6);
		TreeLinkNode n7 = new TreeLinkNode(7);
		TreeLinkNode n8 = new TreeLinkNode(8);
		TreeLinkNode n9 = new TreeLinkNode(9);
		TreeLinkNode n0 = new TreeLinkNode(0);
		n1.left=n2;
		n1.right=n3;
		n2.right=n4;
		n3.left=n5;
		n3.right=n6;
		n4.right=n7;
		n4.left=n0;
		n6.left=n8;
		n6.right=n9;
		s.connect(n1);
	}

    public void connect(TreeLinkNode root) {
    	if(root == null){
    		return;
    	}
    	TreeLinkNode up_cur = root, down_cur = root;
    	boolean isLeftMost = false;
    	
    	while(!isLeftMost){
    		TreeLinkNode leftmost=null;
    		isLeftMost=true;
        	while(up_cur != null){
        		
        		if(up_cur.left!=null){
        			if(isLeftMost){
        				down_cur = up_cur.left;
        				isLeftMost=false;
        				leftmost = down_cur;
        			} else {
        				down_cur.next = up_cur.left;
        				down_cur = down_cur.next;
        			}
        		}
        		if(up_cur.right!=null){
        			if(isLeftMost){
        				down_cur = up_cur.right;
        				isLeftMost=false;
        				leftmost = down_cur;
        			} else {
        				down_cur.next = up_cur.right;
        				down_cur = down_cur.next;
        			}
        		}
        		up_cur = up_cur.next;
        	}
        	up_cur = leftmost;
    	}
    }
}
