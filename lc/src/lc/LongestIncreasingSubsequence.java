package lc;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int longestIncreasingSubsequence(int[] nums) {
        int len = nums.length;
        
        if(len==0){
        	return 0;
        }
        int[] result = new int[len];
        result[0] =1;
        int max =1;
        
        for(int i=1;i<len;i++){
        	result[i] = 1;
        	for(int j=0;j<i;j++){
        		if(nums[j]<=nums[i]){
        			result[i] = Math.max(result[i], result[j]+1);
        		}
        	}
        	max= Math.max(max, result[i]);
        }
        return max;
    }
}
