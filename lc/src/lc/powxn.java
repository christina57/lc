package lc;

public class powxn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(34.00515,-3));
	}

    public static double pow(double x, int n) {
        if (x == 0){
            return 0;
        }
        
    	if(n==0){
    		return 1;
    	} else if(n == 1){
    		return x;
    	} else if (n == -1){
    		return 1/x;
    	}
    	
    	double result;
    	double mid = pow(x, n/2);
    	
		if(n%2==1){
			result = mid*mid*x;
		} else if(n%2==-1) {
			result = mid*mid/x;
		} else {
			result = mid*mid;
		}
		return result;
    }
}
