package lc;

import java.util.ArrayList;

public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence q = new PermutationSequence();
		System.out.println(q.getPermutation(4, 7));
	}
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> unusednum = new ArrayList<Integer>();
        
        for(int i=1;i<=n;i++){
        	unusednum.add(i);
        }
        
        int leftcount = k;
        int factorial = factorial(n-1);
        
        for(int i=1;i<=n;i++){
        	
        	if(i!=n){
	        	int idx = (leftcount-1)/factorial;
	        	leftcount -= idx*factorial;
	        	char c = (char)(unusednum.get(idx)+'0');
	        	sb.append(c);
	        	System.out.println(c);
	        	unusednum.remove(idx);
	        	factorial /= (n-i);
        	} else {
        		char c = (char)(unusednum.get(0)+'0');
        		sb.append(c);
        	}
        }
        return sb.toString();
    }
    
    private int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
