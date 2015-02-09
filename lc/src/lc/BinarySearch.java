package lc;

public class BinarySearch {
	public int binarySearch(int[] nums, int target) {
		int start =0;
		int end = nums.length-1;
		
		while(start+1<end){
			int mid = start + (end-start)/2;
			if(nums[mid]==target){
				end=mid;
			} else if (nums[mid]<target){
				start=mid;
			}else{
				end=mid;
			}
		}
		if(nums[start]==target){
			return start;
		} else if (nums[end]==target){
			return end;
		} else {
			return -1;
		}
	}
}
