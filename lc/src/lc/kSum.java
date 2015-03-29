package lc;

public class kSum {

	public static void main(String[] args){
		kSum q = new kSum();
		int[] A = {1,3,4,5,8,10,11,12,14,17,20,22,24,25,28,30,31,34,35,37,38,40,42,44,45,48,51,54,56,59,60,61,63,66};
		System.out.println(q.kSum(A, 24, 842));
	}
	
	public int kSum(int A[], int k, int target) {
		 int[][][] result = new int[A.length+1][k+1][target+1];
		 
		 for(int i=0;i<=A.length;i++){
			 result[i][0][0] = 1;
		 }
		 
		 for(int i=1;i<=A.length;i++){
			 for(int j=1;j<=k;j++){
				 for(int p=1;p<=target;p++){
					result[i][j][p] = result[i-1][j][p];
					if(p-A[i-1]>=0){
						result[i][j][p] += result[i-1][j-1][p-A[i-1]];
					}
				 }
			 }
		 }
		 return result[A.length][k][target];
	}
	
    public int kSum2(int A[], int k, int target) {
    	return kSumHelper(A, k, target, 0);
    }
    
    private int kSumHelper(int A[], int k, int target, int idx){
    	if(target == 0 && k == 0){
    		 return 1;
    	}
    	if(idx>=A.length || target<=0 || k<=0){
    		return 0;
    	}
    	int result = 0;
    	for(int i=idx;i<A.length;i++){
    		result += kSumHelper(A, k-1, target-A[i], i+1);
    	}
    	return result;
    }
}
