package lc;

import java.util.Stack;

public class MaximalRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maximalRectangle(char[][] matrix) {
    	if(matrix== null || matrix.length==0){
    		return 0;
    	}
    	int max = 0;
        int[] height = new int[matrix[0].length];
        
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		if(matrix[i][j] == '0'){
        			height[j] = 0;
        		} else {
        			height[j]++;
        		}
        	}
        	max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }
    
    private int largestRectangleArea(int[] height) {
		if(height==null || height.length==0){
    		return 0;
    	}
		
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<=height.length;i++){
			int cur_hei = (i==height.length)? 0: height[i];
			while(!stack.isEmpty() && height[stack.peek()]>=cur_hei){
				int idx = stack.pop();
				if(stack.isEmpty()){
					max = Math.max(max, height[idx]*i);
				} else {
					max = Math.max(max, height[idx]*(i-stack.peek()-1));
				}
			}
			stack.push(i);
		}
		return max;
	}
}
