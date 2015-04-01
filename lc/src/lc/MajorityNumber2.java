package lc;

import java.util.ArrayList;

public class MajorityNumber2 {
    public int majorityNumber(ArrayList<Integer> nums) {
        int candidate1=0, candidate2=0, count1=0, count2 =0;
        
        int len = nums.size();
        for(int i=0;i<len;i++){
        	int cur = nums.get(i);
        	if(count1 != 0 && cur == candidate1){
        		count1 ++;
        	} else if(count2 != 0 && cur == candidate2){
        		count2 ++;
        	} else if(count1 != 0 && count2 != 0){
        		count1 --;
    			count2 --;
        	} else if(count1 == 0){
        		candidate1 = cur;
        		count1 ++;
        	} else if(count2 == 0){
        		candidate2 = cur;
        		count2 ++;
        	}
        }
        count1 = 0;
        count2 = 0;
        for(int i=0;i<len;i++){
        	int cur = nums.get(i);
        	if(cur == candidate1){
    			count1 ++;
    		} else if(cur == candidate2){
    			count2 ++;
    		}
        }
        return (count1>count2)?candidate1:candidate2;
    }
}
