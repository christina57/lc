package lc;

import java.util.ArrayList;

public class MinimumAdjustmentCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(4);
		A.add(2);
		A.add(3);
		MinimumAdjustmentCost s = new MinimumAdjustmentCost();
		System.out.println(s.MinAdjustmentCost(A, 1));
	}
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
    	int len = A.size();
        int[][] result = new int[len][101];
        
        for(int j =1; j<101;j++){
        	result[0][j] = Math.abs(j-A.get(0));
        }
        
        for(int i=1;i<len;i++){
        	for(int j =1; j<101;j++){
        		result[i][j] = Integer.MAX_VALUE;
        		int range1 = (j-target)>0?(j-target):1;
        		int range2 = (j+target)<101?(j+target):100;
        		for(int k = range1;k<=range2;k++){
        			result[i][j] = Math.min(result[i][j], result[i-1][k]+Math.abs(j-A.get(i)));
        		}
        	}
        }
        int min = Integer.MAX_VALUE;
        for(int j =1; j<101;j++){
        	min = Math.min(min, result[len-1][j]);
        }
        return min;
    }
}
