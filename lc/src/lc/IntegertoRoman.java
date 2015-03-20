package lc;

public class IntegertoRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String intToRoman(int num) {
    	StringBuilder sb = new StringBuilder();
    	
    	int cnt_4th = num/1000;
    	for(int i=0;i<cnt_4th;i++){
    		sb.append('M');
    	}
    	
    	int cnt_3rd = (num/100)%10;
    	if(cnt_3rd>0 && cnt_3rd<4){
    		for(int i=0;i<cnt_3rd;i++){
        		sb.append('C');
        	}
    	} else if(cnt_3rd == 4){
    		sb.append("CD");
    	} else if(cnt_3rd == 9){
    		sb.append("CM");
    	} else if(cnt_3rd>4 && cnt_3rd<9){
    		sb.append('D');
    		for(int i=0;i<(cnt_3rd-5);i++){
        		sb.append('C');
        	}
    	}
    	
    	int cnt_2nd = (num/10)%10;
    	if(cnt_2nd>0 && cnt_2nd<4){
    		for(int i=0;i<cnt_2nd;i++){
        		sb.append('X');
        	}
    	} else if(cnt_2nd == 4){
    		sb.append("XL");
    	} else if(cnt_2nd == 9){
    		sb.append("XC");
    	} else if(cnt_2nd>4 && cnt_2nd<9){
    		sb.append('L');
    		for(int i=0;i<(cnt_2nd-5);i++){
        		sb.append('X');
        	}
    	}
    	
    	int cnt_1st = num%10;
    	if(cnt_1st>0 && cnt_1st<4){
    		for(int i=0;i<cnt_1st;i++){
        		sb.append('I');
        	}
    	} else if(cnt_1st == 4){
    		sb.append("IV");
    	} else if(cnt_1st == 9){
    		sb.append("IX");
    	} else if(cnt_1st>4 && cnt_1st<9){
    		sb.append('V');
    		for(int i=0;i<(cnt_1st-5);i++){
        		sb.append('I');
        	}
    	}
    	
    	return sb.toString();
    }
}
