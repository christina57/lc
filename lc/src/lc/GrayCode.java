package lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<Integer> grayCode(int n) {
    	List<Integer> result = new ArrayList<Integer>();
    	if(n==0){
    		result.add(0);
    		return result;
    	}
    	if(n==1){
    		result.add(0);
    		result.add(1);
    		return result;
    	}
        List<Integer> sublist = grayCode(n-1);
        
        result.addAll(sublist);
        int len = sublist.size();
        
        for(int i=len-1;i>=0;i--){
        	result.add(sublist.get(i)+(int)Math.pow(2, n-1));
        }
        return result;
    }
}
