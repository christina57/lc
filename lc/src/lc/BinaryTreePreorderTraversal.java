package lc;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if(root == null){
        	return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
        	TreeNode cur = stack.pop();
        	result.add(cur.val);
        	if(cur.right!=null){
        		stack.push(cur.right);
        	}
        	if(cur.left!=null){
        		stack.push(cur.left);
        	}
        }
        
        return result;
    }
}
