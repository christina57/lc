package lc;

import java.util.LinkedList;

public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
    	int start = 0;
    	int remainder = 0;
    	LinkedList<Integer> remainders = new LinkedList<Integer>();
    	
    	for(int i=0;i<gas.length;i++){
    		if((remainder+gas[i]>=cost[i])){
    			remainder = remainder+gas[i]-cost[i];
    		} else {
    			remainders.add(remainder+gas[i]-cost[i]);
    			remainder = 0;
    			start = i+1;
    		}
    	}
    	
    	for(int item: remainders){
    		if(remainder+item>=0){
    			remainder = remainder+item;
    		} else {
    			return -1;
    		}
    	}
    	return start;
    }
}
