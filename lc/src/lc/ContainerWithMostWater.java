package lc;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxArea(int[] height) {
        if(height==null || height.length==0){
        	return 0;
        }
        int total_max=0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
        	int max=0;
        	if(height[left]>height[right]){
        		max = Math.max(max, (right-left)*height[right]);
        		right--;
        	} else {
        		max = Math.max(max, (right-left)*height[left]);
        		left++;
        	}
        	total_max = Math.max(max, total_max);
        }
        
        return total_max;
    }
}
