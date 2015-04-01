package lc;

public class JumpGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int jump(int[] A) {
		int begin = 0;
		int end = 0;
		int step = 1;
		
		while(end<A.length-1){
			int max = end;
			for(int i=begin;i<=end;i++){
				max = Math.max(max, i+A[i]);
				if(max>=(A.length-1)){
					return step;
				}
			}
			if(end == max){
				return 0;
			}
			if(end+1<=max){
				begin = end+1;
			}
			end = max;
			step++;
		}
		return 0; 
    }
}
