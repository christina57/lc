package lc;

/**
 * Created by zzren on 8/1/2016.
 */
public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        //https://segmentfault.com/a/1190000003817671

        int len = nums.length;

        int slow = 0;
        int fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast){
                break;
            }
        }

        fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[fast];

            if(slow == fast){
                return slow;
            }
        }
    }
}
