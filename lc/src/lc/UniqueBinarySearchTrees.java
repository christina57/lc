package lc;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int numTrees(int n) {
     int result[] = new int[n+1];
     
     result[0] =1;
     if(n==0){
    	 return 1;
     }
     result[1] = 1;
     if(n==1){
    	 return 1;
     }
     result[2] = 2;
     if(n==2){
    	 return 2;
     }
     
     for(int i=3;i<=n;i++){
    	 result[i] =0;
    	 for(int j=0;j<i;j++){
    		 result[i] += result[j]*result[i-1-j];
    	 }
     }
     return result[n];
    }
}
