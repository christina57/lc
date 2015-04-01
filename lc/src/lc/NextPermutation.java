package lc;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public void nextPermutation(int[] num) {
        if(num.length==0 || num.length == 1){
        	return;
        }
        
        int pre = num[num.length-1];
    	for(int i=num.length-2;i>=0;i--){
    		int cur = num[i];
    		if(pre>cur){
    			int minabovecur = pre;
    			int idx = i+1;
    			for(int j=i+1;j<num.length;j++){
    				if(num[j]>cur && num[j]<minabovecur){
    					minabovecur = num[j];
    					idx = j;
    				}
    			}
    			num[i] = minabovecur;
    			num[idx] = cur;
    			Arrays.sort(num, i+1, num.length);
    			return;
    		} else {
    			pre = cur;
    		}
    	}
    	
    	Arrays.sort(num, 0, num.length);
    }
}
