package lc;

public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int trailingZeroes(int n) {
        int count = 0;
        int cur = n;
        while(cur>4){
        	cur = cur/5;
        	count += cur;
        }
        return count;
    }
}
