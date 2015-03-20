package lc;

import java.util.LinkedList;
import java.util.Stack;

public class LargestRectangleinHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestRectangleinHistogram q = new LargestRectangleinHistogram();
		int[] height = {1};
		/*int[] height = new int[30000];
		for (int i = 0; i < height.length; i++) {
			height[i] = 1;
		}*/
		System.out.println(q.largestRectangleArea(height));
	}

	public int largestRectangleArea(int[] height) {
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
	
    public int largestRectangleArea2(int[] height) {

    	if(height==null || height.length==0){
    		return 0;
    	}
    	
    	boolean isduplicate = true;
    	for(int i=0;i<height.length;i++){
    		if(height[i] != height[0]){
    			isduplicate = false;
    		}
    	}
    	if(isduplicate){
    		System.out.println("AAAAAAAAAAAAAA");
    		return height[0]*height.length; 
    	}
        int max = 0;
        
        for(int i=0;i<height.length;i++){
        	int width=0;
        	int j;
        	if(i>=1){
	        	for(j=i-1; j>=0;j--){
	        		if(height[j]<height[i]){
	        			break;
	        		}
	        	}
	        	width += (i-j);
        	}
        	if(i+1<height.length){
	        	for(j=i+1; j<height.length;j++){
	        		if(height[j]<height[i]){
	        			break;
	        		}
	        	}
	        	width += (j-i-1);
        	}
        	max = Math.max(max, width*height[i]);
        }
        return max;
    }
}
