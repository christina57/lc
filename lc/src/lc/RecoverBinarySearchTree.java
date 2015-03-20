package lc;

import java.util.LinkedList;
import java.util.List;

public class RecoverBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void recoverTree(TreeNode root) {
		if(root == null){
			return;
		}
		TreeNode[] wronglist = new TreeNode[2];
		wronglist[0] = null;
		wronglist[1] = null;
		LinkedList<TreeNode> pre = new LinkedList<TreeNode>();
		
		inOrderTraverse(root, pre, wronglist);
		if(wronglist[0] != null && wronglist[1] != null){
        	int temp = wronglist[0].val;
        	wronglist[0].val = wronglist[1].val;
        	wronglist[1].val = temp;
        }
	}
	
	private void inOrderTraverse(TreeNode root, LinkedList<TreeNode> pre, TreeNode[] wronglist){
		if(root.left!=null){
			inOrderTraverse(root.left, pre, wronglist);
		}
		
		if(wronglist[0]==null && !pre.isEmpty() && pre.getFirst().val>root.val){
			wronglist[0] = pre.getFirst();
			wronglist[1] = root;
		}
		
		if(wronglist[0] != null && !pre.isEmpty() && pre.getFirst().val>root.val){
			wronglist[1] = root;
		}
		
		pre.addFirst(root);
		if(root.right!=null){
			inOrderTraverse(root.right, pre, wronglist);
		}
	}
	
    public void recoverTree2(TreeNode root) {
        
        if(root == null){
        	return;
        }
        TreeNode wrong1=null, wrong2=null, pre = new TreeNode(Integer.MIN_VALUE);
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        boolean goLeft =true;
        stack.push(root);
        
        while(!stack.isEmpty()){
        	TreeNode cur = stack.peek();
        	
        	if(goLeft){
	        	while(cur.left != null){
	        		stack.push(cur.left);
	        		cur = cur.left;
	        	} 
        	}

        	cur = stack.pop();
    		if(wrong1 == null && cur.val < pre.val){
    			wrong1 = pre;
    		}
    		if(wrong1 != null && wrong2 == null){
    			if(cur.val < wrong1.val && (cur.right==null && stack.isEmpty())){
    				wrong2 = cur;
    				break;
    			}
    			if(cur.val > wrong1.val){
    				wrong2 = pre;
    				break;
    			}
    		}
    		pre = cur;
    		if(cur.right!=null){
    			stack.push(cur.right);
    			goLeft=true;
    		} else {
    			goLeft=false;
    		}
    		
        }
        
        if(wrong1 != null && wrong2 != null){
        	int temp = wrong1.val;
        	wrong1.val = wrong2.val;
        	wrong2.val = temp;
        }
    }
}
