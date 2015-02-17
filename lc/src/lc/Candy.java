package lc;

public class Candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int candy(int[] ratings) {
        int len =ratings.length;
        
        if(len==0){
        	return 0;
        }
        if(len==1){
        	return 1;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] =1;
        right[len-1] =1;
        
        for(int i=1;i<len;i++){
        	if(ratings[i]>ratings[i-1]){
        		left[i] = left[i-1]+1;
        	} else {
        		left[i] = 1;
        	}
        }
        
        for(int i=len-2;i>=0;i--){
        	if(ratings[i+1]<ratings[i]){
        		right[i] = right[i+1]+1;
        	} else {
        		right[i] = 1;
        	}
        }
        
        int sum=0;
        for(int i=0;i<len;i++){
        	sum+=Math.max(left[i],right[i]);
        }
        return sum;
    }
}
