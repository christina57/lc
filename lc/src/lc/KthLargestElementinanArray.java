package lc;

/**
 * Created by zzren on 7/15/2016.
 */
public class KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if(len ==0 || k > len){
            return 0;
        }
        return select(nums, 0, len-1, k-1);
    }

    private int select(int[] nums, int start, int end, int k){
        if(start == end){
            return nums[start];
        }

        int pivotIdx = start + (int)Math.floor(Math.random() * (end - start + 1));
        int curIdx = partition(nums, start, end, pivotIdx);
        if(curIdx == k){
            return nums[k];
        } else if(curIdx < k){
            return select(nums, curIdx+1, end, k);
        } else {
            return select(nums, start, curIdx-1, k);
        }
    }

    private int partition(int[] nums, int start, int end, int pivotIdx){
        int pivot = nums[pivotIdx];
        swap(nums, pivotIdx, end);
        int curIdx = start;
        for(int i=start;i<=end;i++){
            if(nums[i] > pivot){
                swap(nums, curIdx, i);
                curIdx++;
            }
        }
        swap(nums, curIdx, end);
        return curIdx;
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
